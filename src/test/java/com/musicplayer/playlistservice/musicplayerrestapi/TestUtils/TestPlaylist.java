package com.musicplayer.playlistservice.musicplayerrestapi.TestUtils;



import com.musicplayer.playlistservice.models.Playlist;
import com.musicplayer.playlistservice.models.Song;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPlaylist{

    private static Playlist playlist;
    private static List<Integer> songIds = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));


    public static Playlist getTestPlaylist(){
        playlist = new Playlist();
        playlist.setName("JMoney's Top 20");

        songIds.forEach((songId) -> playlist.addSong(songId));
        return playlist;
    }

}
