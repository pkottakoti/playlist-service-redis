package com.musicplayer.playlistservice.models;

import java.time.Duration;


public class Song {

	private Integer id;

	private String title;
	private String artist;


	private Duration length;

	public Song() {	}
	
	public Song(String title, String artist, Duration length) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.length = length;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return this.artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Duration getLength() {
		return length;
	}

	public void setLength(Duration length) {
		this.length = length;
	}

	public String getDurationPretty() {
		long s  = length.toMillis()/1000 % 60;
		long min = length.toMinutes() / 1;
		long h = length.toHours() / 1 ;
		return String.format("%d:%02d:%02d", h, min, s);
	}


}
