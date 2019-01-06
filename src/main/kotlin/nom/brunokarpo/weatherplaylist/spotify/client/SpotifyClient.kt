package nom.brunokarpo.weatherplaylist.spotify.client

import nom.brunokarpo.weatherplaylist.spotify.model.MyPlaylistModel
import nom.brunokarpo.weatherplaylist.spotify.model.PlaylistStyle

interface SpotifyClient {

    fun getPlaylistByStyle(style: PlaylistStyle): MyPlaylistModel

}
