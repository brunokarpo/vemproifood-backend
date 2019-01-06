package nom.brunokarpo.weatherplaylist.spotify.client

import nom.brunokarpo.weatherplaylist.spotify.model.Playlist
import nom.brunokarpo.weatherplaylist.spotify.model.PlaylistStyle
import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
@Ignore
class SpotifyClientIT {

    @Autowired
    private lateinit var sut: SpotifyClient

    @Test
    fun `should retrieve by music style constants`() {
        var playlist: Playlist = sut.getPlaylistByStyle(PlaylistStyle.PARTY)

        assertThat(playlist).isNotNull

        println(playlist)
    }
}