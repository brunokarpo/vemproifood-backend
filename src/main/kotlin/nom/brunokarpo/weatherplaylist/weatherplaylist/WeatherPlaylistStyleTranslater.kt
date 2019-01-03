package nom.brunokarpo.weatherplaylist.weatherplaylist

import nom.brunokarpo.weatherplaylist.openweather.model.Weather

interface WeatherPlaylistStyleTranslater {

    fun getStyleByTemperature(weather: Weather): String

}
