package com.musicplayer.playlistservice.repositories;

import com.musicplayer.playlistservice.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongCacheRepository extends CrudRepository<Song,Integer> {

}
