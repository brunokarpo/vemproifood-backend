package nom.brunokarpo.weatherplaylist.openweather.model

import java.io.Serializable

data class Weather(
        var name: String? = null,
        var main: MainWeather? = null
): Serializable