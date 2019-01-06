package nom.brunokarpo.weatherplaylist

import io.restassured.RestAssured
import nom.brunokarpo.weatherplaylist.openweather.client.OpenWeatherClient
import nom.brunokarpo.weatherplaylist.spotify.client.SpotifyClient
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
abstract class WeatherPlaylistApplicationTests {

    @LocalServerPort
    private var port: Int? = null

    @MockBean
    protected lateinit var openWeatherClient: OpenWeatherClient

    @MockBean
    protected lateinit var spotifyClient: SpotifyClient

    @Before
    fun setUp() {
        RestAssured.port = port!!
    }

    @Bean
    @Primary
    fun openWeathereClient(): OpenWeatherClient{
        return openWeatherClient
    }

    @Bean
    @Primary
    fun spotifyClient(): SpotifyClient {
        return spotifyClient
    }
}