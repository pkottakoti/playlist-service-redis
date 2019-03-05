package com.musicplayer.playlistservice.musicplayerrestapi.ModelTests;


import com.musicplayer.playlistservice.models.Playlist;
import com.musicplayer.playlistservice.musicplayerrestapi.TestUtils.TestPlaylist;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PlaylistTest {
	
	private Playlist myPlaylist;

	
	@Before
	public void testSetup() {
		myPlaylist = TestPlaylist.getTestPlaylist();
	}

	@Test
	public void newPlaylistEmptyTest() {
	    Playlist playlist = new Playlist();
		int expectedSize = 0;
		int actualSize = playlist.getSonglist().size();
		assertEquals("A new songlist should be empty",expectedSize,actualSize);
	}
	
	@Test
	public void addSongToPlaylistTest() {
        Playlist playlist = new Playlist();
        playlist.addSong(myPlaylist.getSonglist().get(1));
		int expectedSize = 1;
		int actualSize = playlist.getSonglist().size();
		assertEquals("Adding a song to the playlist should increase its size by 1",expectedSize,actualSize);
	}
	
	@Test
	public void removeSongFromPlaylistTest() {
		myPlaylist.removeSong(myPlaylist.getSonglist().get(1));
		assertEquals("Removing a song from a playlist should shorten the songlist by 1",4,myPlaylist.getSonglist().size());
		assertEquals("Removing a song from a playlist should remove only that song",1,(int)myPlaylist.getSonglist().get(0));
		assertEquals("Removing a song from a playlist should remove only that song",2,(int)myPlaylist.getSonglist().get(1));

	}
	
	@Test
	public void moveSongTest() {
		myPlaylist.moveSong(2,0);
		int song0Id = myPlaylist.getSonglist().get(0);
		int song1Id = myPlaylist.getSonglist().get(1);
		int song2Id = myPlaylist.getSonglist().get(2);
		assertEquals("First song is correct",3,song0Id);
		assertEquals("Second song is correct",1,song1Id);
		assertEquals("Third song is correct",2,song2Id);
		
	}

}
