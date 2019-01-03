package nom.brunokarpo.weatherplaylist.weatherplaylist

import nom.brunokarpo.weatherplaylist.openweather.model.Weather

interface WeatherPlaylistStyleTranslator {

    fun getStyleByTemperature(weather: Weather): String

}
