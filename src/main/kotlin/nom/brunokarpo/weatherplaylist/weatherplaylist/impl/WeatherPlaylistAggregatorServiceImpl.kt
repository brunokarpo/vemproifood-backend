package nom.brunokarpo.weatherplaylist.weatherplaylist.impl

import nom.brunokarpo.weatherplaylist.music.MusicService
import nom.brunokarpo.weatherplaylist.music.model.MyPlaylistModel
import nom.brunokarpo.weatherplaylist.weather.WeatherServices
import nom.brunokarpo.weatherplaylist.weather.model.Weather
import nom.brunokarpo.weatherplaylist.weatherplaylist.WeatherPlaylistAggregatorService
import nom.brunokarpo.weatherplaylist.weatherplaylist.WeatherPlaylistStyleTranslator
import org.springframework.stereotype.Service

@Service
class WeatherPlaylistAggregatorServiceImpl(
        private var openweatherService: WeatherServices,
        private var spotifyService: MusicService,
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

