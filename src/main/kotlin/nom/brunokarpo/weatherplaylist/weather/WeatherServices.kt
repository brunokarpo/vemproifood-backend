package nom.brunokarpo.weatherplaylist.weather

import nom.brunokarpo.weatherplaylist.weather.model.Weather

interface WeatherServices {

    fun getWeather(city: String): Weather

    fun getWeather(lon: Double, lat: Double): Weather
}