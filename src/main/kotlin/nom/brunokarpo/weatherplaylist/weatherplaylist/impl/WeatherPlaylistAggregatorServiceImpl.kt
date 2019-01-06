package nom.brunokarpo.weatherplaylist.weatherplaylist.impl

import nom.brunokarpo.weatherplaylist.openweather.model.Weather
import nom.brunokarpo.weatherplaylist.openweather.service.OpenWeatherService
import nom.brunokarpo.weatherplaylist.spotify.model.MyPlaylistModel
import nom.brunokarpo.weatherplaylist.spotify.service.SpotifyService
import nom.brunokarpo.weatherplaylist.weatherplaylist.WeatherPlaylistAggregatorService
import nom.brunokarpo.weatherplaylist.weatherplaylist.WeatherPlaylistStyleTranslator
import org.springframework.stereotype.Service

@Service
class WeatherPlaylistAggregatorServiceImpl(
        private var openweatherService: OpenWeatherService,
        private var spotifyService: SpotifyService,
        private var weatherPlaylistStyleTranslator: WeatherPlaylistStyleTranslator)
    : WeatherPlaylistAggregatorService {

    override fun getPlaylist(city: String): MyPlaylistModel {
        var weather: Weather = openweatherService.getWeather(city)
        return getPlaylistByWeather(weather)
    }


    override fun getPlaylist(longitude: Double, latitude: Double): MyPlaylistModel {
        var weather: Weather = openweatherService.getWeather(longitude, latitude)
        return getPlaylistByWeather(weather)
    }

    private fun getPlaylistByWeather(weather: Weather): MyPlaylistModel {
        var style = weatherPlaylistStyleTranslator.getStyleByTemperature(weather)
        return spotifyService.getPlaylistByStyle(style)
    }

}

