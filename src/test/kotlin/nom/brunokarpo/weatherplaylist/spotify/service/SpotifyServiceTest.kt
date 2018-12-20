package nom.brunokarpo.weatherplaylist.spotify.service

import com.wrapper.spotify.model_objects.specification.Paging
import com.wrapper.spotify.model_objects.specification.Track
import nom.brunokarpo.weatherplaylist.spotify.client.SpotifyClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class SpotifyServiceTest {

    @MockBean
    private lateinit var spotifyClient: SpotifyClient

    @MockBean
    private lateinit var playlist: Paging<Track>

    @Autowired
    private lateinit var sut: SpotifyService

    @Before
    fun setUp() {
        Mockito.`when`(spotifyClient.getPlaylistByStyle("ROCK")).thenReturn(playlist)
    }

    @Test
    fun `should call client to retrieve playlist by style`() {
        val paging: Paging<Track> = sut.getPlaylistByStyle("ROCK")

        assertThat(paging).isNotNull
    }
}