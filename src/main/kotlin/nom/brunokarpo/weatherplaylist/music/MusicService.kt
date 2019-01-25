package nom.brunokarpo.weatherplaylist.music

import nom.brunokarpo.weatherplaylist.music.model.MyPlaylistModel
import nom.brunokarpo.weatherplaylist.music.model.PlaylistStyle

interface MusicService {

    fun getPlaylistByStyle(style: PlaylistStyle): MyPlaylistModel
}