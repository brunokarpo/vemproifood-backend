package nom.brunokarpo.weatherplaylist.weatherplaylist

import nom.brunokarpo.weatherplaylist.spotify.model.Playlist

interface WeatherPlaylistAggregatorService {

    fun getPlaylist(city: String): Playlist

    fun getPlaylist(longitude: Double, latitude: Double): Playlist

}
