package nom.brunokarpo.weatherplaylist.controller

import io.restassured.RestAssured
import nom.brunokarpo.weatherplaylist.WeatherPlaylistApplicationTests
import nom.brunokarpo.weatherplaylist.openweather.model.MainWeather
import nom.brunokarpo.weatherplaylist.openweather.model.Weather
import nom.brunokarpo.weatherplaylist.spotify.model.Playlist
import nom.brunokarpo.weatherplaylist.spotify.model.PlaylistStyle
import nom.brunokarpo.weatherplaylist.spotify.model.Track
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.Mockito

class WeatherPlaylistControllerIT: WeatherPlaylistApplicationTests() {

    private companion object {
        const val CITY = "São Paulo"
        const val LONGITUDE = -27.45
        const val LATITUDE = -45.87
        const val TEMP = 54.32
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

        var playlistResponse = RestAssured.given()
                .pathParam("city", CITY)
                .get("/playlist/{city}")
                .then()
                .statusCode(200)
                .extract().body().`as`(Playlist::class.java)

        assertThat(playlistResponse).isEqualTo(PLAYLIST)
    }


    @Test
    fun `should retrieve playlist by coordinates`() {
        Mockito.`when`(openWeatherClient.getWeather(LONGITUDE, LATITUDE))
                .thenReturn(WEATHER)

        Mockito.`when`(spotifyClient.getPlaylistByStyle(PlaylistStyle.ROCK))
                .thenReturn(PLAYLIST)


        var playlistResponse = RestAssured.given()
                .pathParam("longitude", LONGITUDE)
                .pathParam("latitude", LATITUDE)
                .get("/playlist/{longitude}/{latitude}")
                .then()
                .statusCode(200)
                .extract().body().`as`(Playlist::class.java)

        assertThat(playlistResponse).isEqualTo(PLAYLIST)
    }
}