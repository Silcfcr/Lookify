package com.silvia.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.silvia.models.Song;
import com.silvia.services.SongService;

@Controller
public class SongController {
	private final SongService songService;
	
	public SongController(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String landingPage() {
		return "/landingPage.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "/home.jsp";
	}
	
	@RequestMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "/show.jsp";
	}
	
	@RequestMapping("/addSong")
	public String addSong(@Valid @ModelAttribute( "song" ) Song song,
			   BindingResult result) {
		return "/create.jsp";
	}
	

	@RequestMapping(value="/newSong", method=RequestMethod.POST)
	public String createSong(@Valid @ModelAttribute( "song" ) Song song,
			   BindingResult result,
			   RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute( "errorMessage", "You need to provide all details!" );
			System.out.println("I got here with error");
			return "redirect:/newSong";
			
		} else {
			songService.createSong( song );
			System.out.println("I got here with everything okay");
			return "redirect:/dashboard";
			
		}
				
	}
	
	@RequestMapping("/update/{id}")
	public String showUpdateLanguage(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "/update.jsp";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String updateSong(@Valid @ModelAttribute( "song" ) Song song,
			   BindingResult result, RedirectAttributes redirectAttributes) {
		Song currentSong = songService.findSong(song.getId());
		if ( currentSong == null ) {
			redirectAttributes.addFlashAttribute( "errorMessage", "That language identifier doesn't exist." );
		}
		else {
			currentSong.setTitle( song.getTitle() );
			currentSong.setArtist( song.getArtist() );
			currentSong.setRating( song.getRating() );
			songService.updateSong( currentSong );
		}
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteLanguage(@PathVariable("id") Long id) {
		Song currentSong = songService.findSong(id);
		songService.deleteSong(currentSong);
		
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/getArtist")
	public String getArtist(@RequestParam("searchedArtist") String searchedArtist, Model model) {
		List<Song> songs = songService.allSongsby(searchedArtist);
		System.out.println("I got your list songs in the controller");
		model.addAttribute("songs", songs);
		
		return "showArtist.jsp";
	}

	
}
