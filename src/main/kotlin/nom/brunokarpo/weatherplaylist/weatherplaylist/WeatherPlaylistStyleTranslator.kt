package nom.brunokarpo.weatherplaylist.weatherplaylist

import nom.brunokarpo.weatherplaylist.openweather.model.Weather
import nom.brunokarpo.weatherplaylist.spotify.model.PlaylistStyle

interface WeatherPlaylistStyleTranslator {

    fun getStyleByTemperature(weather: Weather): PlaylistStyle

}
