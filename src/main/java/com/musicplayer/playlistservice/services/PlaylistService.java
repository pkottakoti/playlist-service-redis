package com.musicplayer.playlistservice.services;

import com.musicplayer.playlistservice.PlaylistNotFoundException;

import com.musicplayer.playlistservice.models.Playlist;
import com.musicplayer.playlistservice.repositories.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    private int songLimit =5;//hard coded for Redis example. Normally pulled from Config Server

    private PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository){
        this.playlistRepository = playlistRepository;
    }

    public int getSongLimit() {
        return songLimit;
    }

    public void setSongLimit(int songLimit) {
        this.songLimit = songLimit;
    }


    public Playlist getPlaylistByUserID(Integer id)  {
        Playlist playlist = playlistRepository.findById(id).orElse(null);

        if(playlist == null){
            throw new PlaylistNotFoundException();
        }
        return playlist;
    }

    public void savePlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
    }
}
