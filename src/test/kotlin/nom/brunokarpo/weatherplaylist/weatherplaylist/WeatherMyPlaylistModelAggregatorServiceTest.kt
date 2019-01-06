package nom.brunokarpo.weatherplaylist.weatherplaylist

import nom.brunokarpo.weatherplaylist.openweather.model.MainWeather
import nom.brunokarpo.weatherplaylist.openweather.model.Weather
import nom.brunokarpo.weatherplaylist.openweather.service.OpenWeatherService
import nom.brunokarpo.weatherplaylist.spotify.model.MyPlaylistModel
import nom.brunokarpo.weatherplaylist.spotify.model.PlaylistStyle
import nom.brunokarpo.weatherplaylist.spotify.model.Track
import nom.brunokarpo.weatherplaylist.spotify.service.SpotifyService
import nom.brunokarpo.weatherplaylist.weatherplaylist.impl.WeatherPlaylistAggregatorServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootApplication
class WeatherMyPlaylistModelAggregatorServiceTest {

    companion object {
        private const val CITY: String = "São Paulo"
        private const val LAT: Double = 2.1
        private const val LONG: Double = 1.1
        private const val TEMP: Double = 82.4
        private const val NAME: String = "Another Brick on The Wall"
        private const val ALBUM: String = "Another Brick on the Wall"
        private const val ARTIST: String = "Led Zepplin"
        private val STYLE: PlaylistStyle = PlaylistStyle.ROCK
        private val WEATHER: Weather = Weather( name = CITY, main = MainWeather(TEMP))
        private val MY_PLAYLIST_MODEL: MyPlaylistModel = MyPlaylistModel(tracks = listOf(Track(name = NAME, album = ALBUM,  artist = ARTIST)
        ))
    }

    @MockBean
    private lateinit var openweatherServiceMock: OpenWeatherService

    @MockBean
    private lateinit var spotifyServiceMock: SpotifyService

    @MockBean
    private lateinit var weatherPlaylistStyleTranslatorMock: WeatherPlaylistStyleTranslator

    private lateinit var sut: WeatherPlaylistAggregatorService


    @Before
    fun setUp() {
        sut = WeatherPlaylistAggregatorServiceImpl(openweatherServiceMock, spotifyServiceMock, weatherPlaylistStyleTranslatorMock)

        Mockito.`when`(openweatherServiceMock.getWeather(CITY))
                .thenReturn(WEATHER)

        Mockito.`when`(openweatherServiceMock.getWeather(LONG, LAT))
                .thenReturn(WEATHER)

        Mockito.`when`(spotifyServiceMock.getPlaylistByStyle(STYLE))
                .thenReturn(MY_PLAYLIST_MODEL)

        Mockito.`when`(weatherPlaylistStyleTranslatorMock.getStyleByTemperature(WEATHER))
                .thenReturn(STYLE)
    }

    @Test
    fun `should return playlist by city name`() {
        var myPlaylistModel: MyPlaylistModel = sut.getPlaylist(CITY)

        assertThat(myPlaylistModel).isNotNull
        assertThat(myPlaylistModel).isEqualTo(MY_PLAYLIST_MODEL)
    }

    @Test
    fun `should return playlist by coordinates`() {
        var playlist = sut.getPlaylist(LONG, LAT)

        assertThat(playlist).isNotNull
        assertThat(playlist).isEqualTo(MY_PLAYLIST_MODEL)
    }
}