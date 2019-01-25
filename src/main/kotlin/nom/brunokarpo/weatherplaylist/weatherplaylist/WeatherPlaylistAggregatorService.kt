package nom.brunokarpo.weatherplaylist.weatherplaylist

import nom.brunokarpo.weatherplaylist.music.model.MyPlaylistModel

interface WeatherPlaylistAggregatorService {

    fun getPlaylist(city: String): MyPlaylistModel

    fun getPlaylist(longitude: Double, latitude: Double): MyPlaylistModel

}
