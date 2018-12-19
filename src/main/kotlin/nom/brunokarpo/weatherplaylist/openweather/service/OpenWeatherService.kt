package nom.brunokarpo.weatherplaylist.openweather.service

import nom.brunokarpo.weatherplaylist.openweather.model.Weather

interface OpenWeatherService {

    fun getWeather(city: String): Weather

    fun getWeather(lon: Double, lat: Double): Weather

}
