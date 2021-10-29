package com.silvia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.silvia.models.Song;
import com.silvia.repositories.SongRepository;

@Service
public class SongService {
	
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	//returns all languages
	public List<Song> allSongs() {
		return songRepository.findAll();
		}
	
	public List<Song> allSongsby(String artist) {
		System.out.println("I got your list songs");
		return songRepository.findByArtistEquals(artist);
		
		}
	
	//creates a language
	public Song createSong(Song newSong) {
		return songRepository.save(newSong);
		}
	
	//returns one language
	public Song findSong(Long id) {
		Optional<Song> song = songRepository.findById(id);
		if (song.isPresent()) {
			return song.get();
		} else {
			return null;
		}
	}
	
	public Song updateSong(Song updatedSong) {
		return songRepository.save(updatedSong);
	}
	
	public void deleteSong(Song song) {
		songRepository.delete(song);
	}

}
