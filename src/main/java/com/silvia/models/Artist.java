//package com.silvia.models;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//@Entity
//@Table(name="artists")
//public class Artist {
//	
//		@Id
//		@GeneratedValue(strategy = GenerationType.IDENTITY)
//		private Long id;
//		
//		@OneToMany(mappedBy="artist", fetch = FetchType.LAZY)
//		private List<Song> songs;
//		
//		@NotNull
//		@Size(min = 5)
//		private String artist;
//
//		public Long getId() {
//			return id;
//		}
//
//		public List<Song> getSongs() {
//			return songs;
//		}
//
//		public String getArtist() {
//			return artist;
//		}
//
//		public void setId(Long id) {
//			this.id = id;
//		}
//
//		public void setSongs(List<Song> songs) {
//			this.songs = songs;
//		}
//
//		public void setArtist(String artist) {
//			this.artist = artist;
//		}
//
//		public Artist(String artist) {
//			this.artist = artist;
//		}
//		
//		
//		
//
//
//		
//
//
//		
//
//}
