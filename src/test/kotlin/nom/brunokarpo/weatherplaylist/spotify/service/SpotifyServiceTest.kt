package nom.brunokarpo.weatherplaylist.spotify.service

import nom.brunokarpo.weatherplaylist.spotify.client.SpotifyClient
import nom.brunokarpo.weatherplaylist.spotify.model.MyPlaylistModel
import nom.brunokarpo.weatherplaylist.spotify.model.PlaylistStyle
import nom.brunokarpo.weatherplaylist.spotify.model.Track
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
@ActiveProfiles("test")
class SpotifyServiceTest {

    @MockBean
    private lateinit var spotifyClient: SpotifyClient

    @Autowired
    private lateinit var sut: SpotifyService

    @Before
    fun setUp() {

        val playlist = MyPlaylistModel(
                arrayListOf(
                        Track(name = "Cowboy fora da Lei",
                                artist = "Raul Seixas",
                                album = "Cowboy fora da Lei")
                )
        )

        Mockito.`when`(spotifyClient.getPlaylistByStyle(PlaylistStyle.ROCK)).thenReturn(playlist)
    }

    @Test
    fun `should call client to retrieve playlist by style`() {
        val paging: MyPlaylistModel = sut.getPlaylistByStyle(PlaylistStyle.ROCK)

        assertThat(paging).isNotNull
    }


}