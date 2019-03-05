package com.musicplayer.playlistservice.models;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="song-service", url="localhost:8100")
public interface SongServiceProxy {

    @GetMapping("/song/{id}")
    Song getSongById(@PathVariable("id") int id);

}
