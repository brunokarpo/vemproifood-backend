package nom.brunokarpo.weatherplaylist.weather.impl.openweather.service.impl

import nom.brunokarpo.weatherplaylist.weather.impl.openweather.client.OpenWeatherClient
import nom.brunokarpo.weatherplaylist.weather.impl.openweather.service.OpenWeatherService
import nom.brunokarpo.weatherplaylist.weather.model.MainWeather
import nom.brunokarpo.weatherplaylist.weather.model.Weather
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class OpenWeatherServiceImpl(
        private var client: OpenWeatherClient
    ): OpenWeatherService {


    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(OpenWeatherServiceImpl::class.java)
        const val COOL_TEMPERATURE = 71.6
    }

    override fun getWeather(lon: Double, lat: Double): Weather {
        return try {
            client.getWeather(lon, lat)
        } catch (e: Exception) {
            LOG.error("An error occurs when try to retrieve weather by coordinates. I'll return a cool climate: {}", e.message, e)
            Weather("", MainWeather(COOL_TEMPERATURE))
        }
    }

    override fun getWeather(city: String): Weather {
        return try {
            client.getWeather(city)
        } catch (e: Exception) {
            LOG.error("An error occurs when try to retrieve weather by city. I'll return a cool climate: {}", e.message, e)
            Weather(city, MainWeather(COOL_TEMPERATURE))
        }
    }
}