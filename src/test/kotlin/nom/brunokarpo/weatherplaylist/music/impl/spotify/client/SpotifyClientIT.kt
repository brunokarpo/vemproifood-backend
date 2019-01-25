package nom.brunokarpo.weatherplaylist.music.impl.spotify.client

import nom.brunokarpo.weatherplaylist.music.model.MyPlaylistModel
import nom.brunokarpo.weatherplaylist.music.model.PlaylistStyle
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
        var myPlaylistModel: MyPlaylistModel = sut.getPlaylistByStyle(PlaylistStyle.PARTY)

        assertThat(myPlaylistModel).isNotNull

        println(myPlaylistModel)
    }
}