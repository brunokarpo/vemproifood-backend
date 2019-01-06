package nom.brunokarpo.weatherplaylist.weatherplaylist

import nom.brunokarpo.weatherplaylist.spotify.model.MyPlaylistModel

interface WeatherPlaylistAggregatorService {

    fun getPlaylist(city: String): MyPlaylistModel

    fun getPlaylist(longitude: Double, latitude: Double): MyPlaylistModel

}
