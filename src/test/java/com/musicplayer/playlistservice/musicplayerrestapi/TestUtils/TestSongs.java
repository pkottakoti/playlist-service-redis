package com.musicplayer.playlistservice.musicplayerrestapi.TestUtils;

import com.musicplayer.playlistservice.models.Song;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestSongs {

    public static List<Song> getSongs(){
        List<Song> songs = new ArrayList<Song>();
        songs.add(new Song(1,"Africa","Weezer", Duration.ofSeconds(243)));
        songs.add(new Song(2,"Africa","Toto", Duration.ofSeconds(274)));
        songs.add(new Song(3,"Take On Me","a-Ha", Duration.ofSeconds(227)));
        songs.add(new Song(4,"Billie Jean","Michael Jackson", Duration.ofSeconds(210)));
        songs.add(new Song(5,"I Would Do Anything for Love","Meatloaf",Duration.ofSeconds(756)));
        songs.add(new Song(6,"Closer","The Chainsmokers",Duration.ofSeconds(244)));
        return songs;
    }
}
