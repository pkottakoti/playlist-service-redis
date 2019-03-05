package com.musicplayer.playlistservice.controllers;


import com.musicplayer.playlistservice.PlaylistNotFoundException;
import com.musicplayer.playlistservice.models.Playlist;
import com.musicplayer.playlistservice.models.Song;
import com.musicplayer.playlistservice.models.SongServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.musicplayer.playlistservice.services.PlaylistService;

import java.util.ArrayList;
import java.util.List;


@RestController
public class PlaylistController {

    private final SongServiceProxy songServiceProxy;
    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService, SongServiceProxy songServiceProxy) {
        this.playlistService = playlistService;
        this.songServiceProxy = songServiceProxy;
    }

    @GetMapping("/playlist-songs/{id}")
    public List<Song> getSongsInPlaylist(@PathVariable int id){
        Playlist playlist = getPlaylistByUserID(id);
        List<Song> songs = new ArrayList<Song>();

        playlist.getSonglist().forEach(songId->songs.add(songServiceProxy.getSongById(
                songId)));
        return songs;
    }



    @GetMapping("/song-limit")
    public String getPlaylistLimit(){
        return "The playlistLimit="+playlistService.getSongLimit();
    }

    @GetMapping("/playlists/{id}")
    public Playlist getPlaylistByUserID(@PathVariable Integer id){
        return playlistService.getPlaylistByUserID(id);
    }

    @PostMapping("/playlist")
    public String savePlaylist(@RequestBody Playlist playlist){
        playlistService.savePlaylist(playlist);
        return "saved";
    }



    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void playlistNotFoundHandler(PlaylistNotFoundException ex){

    }


}
