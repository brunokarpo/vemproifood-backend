package nom.brunokarpo.weatherplaylist.spotify.service.impl

import nom.brunokarpo.weatherplaylist.spotify.client.SpotifyClient
import nom.brunokarpo.weatherplaylist.spotify.model.Playlist
import nom.brunokarpo.weatherplaylist.spotify.model.PlaylistStyle
import nom.brunokarpo.weatherplaylist.spotify.service.SpotifyService
import org.springframework.stereotype.Service

@Service
class SpotifyServiceImpl(
        private var spotifyClient: SpotifyClient
) : SpotifyService {

    override fun getPlaylistByStyle(style: PlaylistStyle): Playlist {
        return spotifyClient.getPlaylistByStyle(style)
    }

}