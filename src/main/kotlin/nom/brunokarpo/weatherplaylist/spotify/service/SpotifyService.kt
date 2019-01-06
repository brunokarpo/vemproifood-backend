package nom.brunokarpo.weatherplaylist.spotify.service

import nom.brunokarpo.weatherplaylist.spotify.model.MyPlaylistModel
import nom.brunokarpo.weatherplaylist.spotify.model.PlaylistStyle

interface SpotifyService {

    fun getPlaylistByStyle(style: PlaylistStyle): MyPlaylistModel

}
