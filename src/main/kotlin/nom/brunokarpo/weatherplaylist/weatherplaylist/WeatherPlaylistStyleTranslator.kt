package nom.brunokarpo.weatherplaylist.weatherplaylist

import nom.brunokarpo.weatherplaylist.music.model.PlaylistStyle
import nom.brunokarpo.weatherplaylist.weather.model.Weather

interface WeatherPlaylistStyleTranslator {

    fun getStyleByTemperature(weather: Weather): PlaylistStyle

}
