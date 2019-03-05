package com.musicplayer.playlistservice.musicplayerrestapi.RepositoryTests;


import com.musicplayer.playlistservice.models.Playlist;
import com.musicplayer.playlistservice.musicplayerrestapi.TestUtils.TestPlaylist;
import com.musicplayer.playlistservice.repositories.PlaylistRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PlaylistRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PlaylistRepository playlistRepository;

    private Playlist testPlaylist;

    @Before
    public void setUp(){
        testPlaylist = TestPlaylist.getTestPlaylist();
    }

    @Test
    public void findById_findsInRepo()throws Exception{
       Integer id = testEntityManager.persistAndGetId(testPlaylist,Integer.class);
       Playlist playlist =  playlistRepository.findById(id).orElse(null);
       Assertions.assertThat(playlist.getName()).isEqualTo("JMoney's Top 20");
    }
}