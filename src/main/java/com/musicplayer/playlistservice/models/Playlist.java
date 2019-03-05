package com.musicplayer.playlistservice.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ElementCollection
    private List<Integer> songlistIDs;

    public Playlist() {
        songlistIDs = new ArrayList<Integer>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getSonglist() {
        return songlistIDs;
    }

    public void addSong(Integer songId) {
        this.songlistIDs.add(songId);
    }

    public void removeSong(Integer songId) {
        this.songlistIDs.remove(songId);
    }

    public void moveSong(int currentIndex, int newIndex) {
        int songToMove = this.songlistIDs.get(currentIndex);
        this.songlistIDs.remove(songToMove);
        this.songlistIDs.add(newIndex,songToMove);
    }


    public void setId(int id) {
        this.id = id;
    }
}