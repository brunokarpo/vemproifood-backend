package nom.brunokarpo.weatherplaylist.weatherplaylist.impl

import nom.brunokarpo.weatherplaylist.openweather.model.Weather
import nom.brunokarpo.weatherplaylist.spotify.model.PlaylistStyle
import nom.brunokarpo.weatherplaylist.weatherplaylist.WeatherPlaylistStyleTranslator
import org.springframework.stereotype.Service

fun Double.Companion.convertFahrenheitToCelsius(fahrenheint: Double): Double {
    return (fahrenheint - 32) * 5 / 9
}

@Service
class WeatherPlaylistStyleTranslatorImpl : WeatherPlaylistStyleTranslator {

    companion object {
        private const val PARTY: String = "party"
        private const val POP: String = "pop"
        private const val ROCK: String = "rock"
        private const val CLASSICAL: String = "classical"
    }

    override fun getStyleByTemperature(weather: Weather): PlaylistStyle {
        var fahrenheit = weather.main!!.temp
        var celsius = Double.convertFahrenheitToCelsius(fahrenheit)

        return when(celsius) {
            in 30.0..Double.MAX_VALUE -> PlaylistStyle.PARTY
            in 15.0..30.0 -> PlaylistStyle.POP
            in 10.0..15.0 -> PlaylistStyle.ROCK
            else -> PlaylistStyle.CLASSICAL
        }

    }

}

