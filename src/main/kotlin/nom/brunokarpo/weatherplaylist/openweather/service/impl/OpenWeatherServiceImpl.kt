package nom.brunokarpo.weatherplaylist.openweather.service.impl

import nom.brunokarpo.weatherplaylist.openweather.client.OpenWeatherClient
import nom.brunokarpo.weatherplaylist.openweather.model.Weather
import nom.brunokarpo.weatherplaylist.openweather.service.OpenWeatherService
import org.springframework.stereotype.Service

@Service
class OpenWeatherServiceImpl(
        private var client: OpenWeatherClient
    ): OpenWeatherService {

    override fun getWeather(lon: Double, lat: Double): Weather {
        return client.getWeather(lon, lat)
    }

    override fun getWeather(city: String): Weather {
        return client.getWeather(city)
    }
}