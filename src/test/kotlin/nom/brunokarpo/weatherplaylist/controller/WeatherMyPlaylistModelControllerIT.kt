package nom.brunokarpo.weatherplaylist.controller

import io.restassured.RestAssured
import nom.brunokarpo.weatherplaylist.WeatherMyPlaylistModelApplicationTests
import nom.brunokarpo.weatherplaylist.music.model.MyPlaylistModel
import nom.brunokarpo.weatherplaylist.music.model.PlaylistStyle
import nom.brunokarpo.weatherplaylist.music.model.Track
import nom.brunokarpo.weatherplaylist.weather.model.MainWeather
import nom.brunokarpo.weatherplaylist.weather.model.Weather
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.Mockito

class WeatherMyPlaylistModelControllerIT: WeatherMyPlaylistModelApplicationTests() {

    private companion object {
        const val CITY = "São Paulo"
        const val LONGITUDE = -27.45
        const val LATITUDE = -45.87
        const val TEMP = 54.32
        val WEATHER = Weather(CITY, MainWeather(TEMP))
        const val NAME = "Cowboy fora da lei"
        const val ALBUM = "O melhor de Raul Seixas"
        const val ARTIST = "Raul Seixas"
        val PLAYLIST = MyPlaylistModel(listOf(Track(NAME, ALBUM, ARTIST)))
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
                .extract().body().`as`(MyPlaylistModel::class.java)

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
                .extract().body().`as`(MyPlaylistModel::class.java)

        assertThat(playlistResponse).isEqualTo(PLAYLIST)
    }
}