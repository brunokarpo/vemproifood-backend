package nom.brunokarpo.weatherplaylist.spotify.service.impl

import nom.brunokarpo.weatherplaylist.spotify.client.SpotifyClient
import nom.brunokarpo.weatherplaylist.spotify.model.MyPlaylistModel
import nom.brunokarpo.weatherplaylist.spotify.model.PlaylistStyle
import nom.brunokarpo.weatherplaylist.spotify.service.SpotifyService
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