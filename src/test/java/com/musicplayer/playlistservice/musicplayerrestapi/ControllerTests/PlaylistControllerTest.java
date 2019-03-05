package com.musicplayer.playlistservice.musicplayerrestapi.ControllerTests;


import com.musicplayer.playlistservice.PlaylistNotFoundException;
import com.musicplayer.playlistservice.models.SongServiceProxy;
import com.musicplayer.playlistservice.musicplayerrestapi.TestUtils.TestPlaylist;
import com.musicplayer.playlistservice.controllers.PlaylistController;
import com.musicplayer.playlistservice.models.Playlist;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.musicplayer.playlistservice.services.PlaylistService;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PlaylistController.class)
public class PlaylistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlaylistService playlistService;

    @MockBean
    private SongServiceProxy songServiceProxy;

    private Playlist myPlaylist;


    @Before
    public void testSetup() {
        myPlaylist = TestPlaylist.getTestPlaylist();
    }

    @Test
    public void getPlaylistByUserID_shouldReturnUsersPlaylist() throws Exception{
        given(playlistService.getPlaylistByUserID(any())).willReturn(myPlaylist);

        mockMvc.perform(MockMvcRequestBuilders.get("/playlists/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("songlist",hasSize(myPlaylist.getSonglist().size())))
                .andExpect(jsonPath("name").value("JMoney's Top 20"));
    }

    @Test
    public void getPlaylist_NotFound() throws Exception{
        given(playlistService.getPlaylistByUserID(any())).willThrow(new PlaylistNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/playlists/1"))
                .andExpect(status().isNotFound());

    }

    @Test
    public void savePlaylist_savesThePlaylist() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.post("/playlist",TestPlaylist.getTestPlaylist()));
        verify(playlistService, times(1)).savePlaylist(any(Playlist.class));
    }
}
