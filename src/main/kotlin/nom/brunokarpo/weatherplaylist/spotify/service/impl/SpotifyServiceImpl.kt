package nom.brunokarpo.weatherplaylist.spotify.service.impl

import com.wrapper.spotify.model_objects.specification.Paging
import com.wrapper.spotify.model_objects.specification.Track
import nom.brunokarpo.weatherplaylist.spotify.client.SpotifyClient
import nom.brunokarpo.weatherplaylist.spotify.service.SpotifyService
import org.springframework.stereotype.Service

@Service
class SpotifyServiceImpl(
        private var spotifyClient: SpotifyClient
) : SpotifyService {

    override fun getPlaylistByStyle(style: String): Paging<Track> {
        return spotifyClient.getPlaylistByStyle(style)
    }

}