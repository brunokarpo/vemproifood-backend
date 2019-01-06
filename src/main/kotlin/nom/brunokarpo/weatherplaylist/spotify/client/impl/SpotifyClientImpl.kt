package nom.brunokarpo.weatherplaylist.spotify.client.impl

import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.model_objects.credentials.ClientCredentials
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest
import nom.brunokarpo.weatherplaylist.spotify.client.SpotifyClient
import nom.brunokarpo.weatherplaylist.spotify.model.MyPlaylistModel
import nom.brunokarpo.weatherplaylist.spotify.model.PlaylistStyle
import nom.brunokarpo.weatherplaylist.spotify.model.converter.PlaylistConverter
import org.springframework.stereotype.Component

@Component
class SpotifyClientImpl(
        private val clientCredentialsRequest: ClientCredentialsRequest
) : SpotifyClient {

    private var clientCredentials : ClientCredentials? = null

    override fun getPlaylistByStyle(style: PlaylistStyle): MyPlaylistModel {
        val paging = getSpotifyApi().searchTracks(style.styleName).limit(50).build().execute()

        return PlaylistConverter(paging).toPlaylist()
    }

    private fun getSpotifyApi() : SpotifyApi {
        val spotifyApi = SpotifyApi.builder().build()
        if (clientCredentials == null || clientCredentials?.expiresIn ?: 0 <= 5) {
            clientCredentials = clientCredentialsRequest.execute()
        }
        spotifyApi.accessToken = clientCredentials?.accessToken
        return spotifyApi
    }

}