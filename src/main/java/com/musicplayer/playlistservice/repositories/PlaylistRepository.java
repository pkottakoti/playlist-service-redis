package com.musicplayer.playlistservice.repositories;


import com.musicplayer.playlistservice.models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist,Integer> {
}
