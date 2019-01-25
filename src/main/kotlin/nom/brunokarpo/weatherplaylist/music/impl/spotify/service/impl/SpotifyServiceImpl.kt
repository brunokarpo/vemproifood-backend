package nom.brunokarpo.weatherplaylist.music.impl.spotify.service.impl

import nom.brunokarpo.weatherplaylist.music.impl.spotify.client.SpotifyClient
import nom.brunokarpo.weatherplaylist.music.impl.spotify.service.SpotifyService
import nom.brunokarpo.weatherplaylist.music.model.MyPlaylistModel
import nom.brunokarpo.weatherplaylist.music.model.PlaylistStyle
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class SpotifyServiceImpl(
        private var spotifyClient: SpotifyClient
) : SpotifyService {

    @Cacheable(value = "playlists", key = "#style.styleName")
    override fun getPlaylistByStyle(style: PlaylistStyle): MyPlaylistModel {
        return spotifyClient.getPlaylistByStyle(style)
    }

}