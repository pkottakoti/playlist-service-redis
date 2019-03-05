package com.musicplayer.playlistservice.musicplayerrestapi.ServiceTests;


import com.musicplayer.playlistservice.PlaylistNotFoundException;
import com.musicplayer.playlistservice.musicplayerrestapi.TestUtils.TestPlaylist;
import com.musicplayer.playlistservice.models.Playlist;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.musicplayer.playlistservice.repositories.PlaylistRepository;
import com.musicplayer.playlistservice.services.PlaylistService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class PlaylistServiceTest {

    @Mock
    private PlaylistRepository playlistRepository;

    private PlaylistService playlistService;

    private Playlist myPlaylist;


    @Before
    public void setUp() throws Exception{
        playlistService = new PlaylistService(playlistRepository);
        myPlaylist = TestPlaylist.getTestPlaylist();
    }


    @Test
    public void getPlaylistByUserID_returnsUsersPlaylist(){
       given(playlistRepository.findById(1)).willReturn(Optional.of(myPlaylist));

       Playlist playlist = playlistService.getPlaylistByUserID(1);

       assertThat(playlist.getName()).isEqualTo("JMoney's Top 20");
       assertThat(playlist.getSonglist().size()).isEqualTo(myPlaylist.getSonglist().size());
    }

    @Test
    public void savePlaylist_savesThePlaylist(){
        playlistService.savePlaylist(myPlaylist);
        verify(playlistRepository, times(1)).save(myPlaylist);
    }

    @Test(expected = PlaylistNotFoundException.class)
    public void getPlaylist_whenPlaylistNotFound() throws Exception{
        given(playlistRepository.findById(1)).willReturn(Optional.empty());

        playlistService.getPlaylistByUserID(1);
    }


}
