package nom.brunokarpo.weatherplaylist.weatherplaylist.impl

import nom.brunokarpo.weatherplaylist.openweather.model.Weather
import nom.brunokarpo.weatherplaylist.openweather.service.OpenWeatherService
import nom.brunokarpo.weatherplaylist.spotify.model.Playlist
import nom.brunokarpo.weatherplaylist.spotify.service.SpotifyService
import nom.brunokarpo.weatherplaylist.weatherplaylist.WeatherPlaylistAggregatorService
import nom.brunokarpo.weatherplaylist.weatherplaylist.WeatherPlaylistStyleTranslater
import org.springframework.stereotype.Service

@Service
class WeatherPlaylistAggregatorServiceImpl(
        private var openweatherService: OpenWeatherService,
        private var spotifyService: SpotifyService,
        private var weatherPlaylistStyleTranslater: WeatherPlaylistStyleTranslater)
    : WeatherPlaylistAggregatorService {

    override fun getPlaylist(city: String): Playlist {
        var weather: Weather = openweatherService.getWeather(city)
        return getPlaylistByWeather(weather)
    }


    override fun getPlaylist(longitude: Double, latitude: Double): Playlist {
        var weather: Weather = openweatherService.getWeather(longitude, latitude)
        return getPlaylistByWeather(weather)
    }

    private fun getPlaylistByWeather(weather: Weather): Playlist {
        var style: String = weatherPlaylistStyleTranslater.getStyleByTemperature(weather)
        return spotifyService.getPlaylistByStyle(style)
    }

}

