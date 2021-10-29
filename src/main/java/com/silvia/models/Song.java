//domain model

package com.silvia.models;

import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="songs")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@NotNull
	@Size(min = 5)
	private String title;
	
	
	private String artist;
	
	@NotNull
	@Min(1)
	@Max(10)
	private int rating;

	private Date updatedAt;

	private Date createdAt;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public int getRating() {
		return rating;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Song(String title, String artist,int rating) {
		this.title = title;
		this.artist = artist;
		this.rating = rating;
	}
	
	public Song() {}
	
	@PrePersist
    protected void onCreate(){
        this.setCreatedAt(new Date());
    }
    @PreUpdate
    protected void onUpdate(){
        this.setUpdatedAt(new Date());
    }

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	
	
}