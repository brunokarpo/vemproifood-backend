package nom.brunokarpo.weatherplaylist.music.impl.spotify.client

import nom.brunokarpo.weatherplaylist.music.model.MyPlaylistModel
import nom.brunokarpo.weatherplaylist.music.model.PlaylistStyle

interface SpotifyClient {

    fun getPlaylistByStyle(style: PlaylistStyle): MyPlaylistModel

}
