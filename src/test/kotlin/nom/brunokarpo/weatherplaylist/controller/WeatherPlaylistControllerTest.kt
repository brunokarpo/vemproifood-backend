package nom.brunokarpo.weatherplaylist.controller

import io.restassured.RestAssured
import nom.brunokarpo.weatherplaylist.WeatherPlaylistApplicationTests
import nom.brunokarpo.weatherplaylist.openweather.client.OpenWeatherClient
import nom.brunokarpo.weatherplaylist.openweather.model.MainWeather
import nom.brunokarpo.weatherplaylist.openweather.model.Weather
import nom.brunokarpo.weatherplaylist.spotify.client.SpotifyClient
import nom.brunokarpo.weatherplaylist.spotify.model.Playlist
import nom.brunokarpo.weatherplaylist.spotify.model.PlaylistStyle
import nom.brunokarpo.weatherplaylist.spotify.model.Track
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.Mockito
import org.springframework.boot.test.mock.mockito.SpyBean

class WeatherPlaylistControllerTest: WeatherPlaylistApplicationTests() {

    private companion object {
        const val CITY = "São Paulo"
        const val TEMP = 62.6
        val WEATHER = Weather(CITY, MainWeather(TEMP))
        const val NAME = "Cowboy fora da lei"
        const val ALBUM = "O melhor de Raul Seixas"
        const val ARTIST = "Raul Seixas"
        val PLAYLIST = Playlist(listOf(Track(NAME, ALBUM, ARTIST)))
    }

    @Test
    fun `should retrieve playlist by city name`() {
        Mockito.`when`(openWeatherClient.getWeather(CITY))
                .thenReturn(WEATHER)

        Mockito.`when`(spotifyClient.getPlaylistByStyle(PlaylistStyle.ROCK))
                .thenReturn(PLAYLIST)

        var response: Playlist = RestAssured.given()
                .pathParam("city", CITY)
                .get("/playlist/{city}")
                .then()
                .statusCode(200)
                .extract().body().`as`(Playlist::class.java)

        assertThat(response).isEqualTo(PLAYLIST)
    }
}