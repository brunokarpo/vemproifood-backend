package nom.brunokarpo.weatherplaylist.spotify.client

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class SpotifyClientTest {

    @Autowired
    private lateinit var sut: SpotifyClient


    @Test
    fun `should retrieve by music style`() {
        var playlist: String = sut.getPlaylistByStyle("ROCK")

        println(playlist)
    }
}