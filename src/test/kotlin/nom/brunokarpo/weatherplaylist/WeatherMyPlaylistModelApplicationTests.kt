package nom.brunokarpo.weatherplaylist

import io.restassured.RestAssured
import io.restassured.parsing.Parser
import nom.brunokarpo.weatherplaylist.music.impl.spotify.client.SpotifyClient
import nom.brunokarpo.weatherplaylist.weather.impl.openweather.client.OpenWeatherClient
import org.junit.Before
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
abstract class WeatherMyPlaylistModelApplicationTests {

    @LocalServerPort
    private var port: Int? = null

    @MockBean
    protected lateinit var openWeatherClient: OpenWeatherClient

    @MockBean
    protected lateinit var spotifyClient: SpotifyClient

    @Before
    fun setUp() {
        RestAssured.port = port!!
        RestAssured.defaultParser = Parser.JSON
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