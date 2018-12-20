package nom.brunokarpo.weatherplaylist.spotify.client.impl

import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.model_objects.credentials.ClientCredentials
import com.wrapper.spotify.model_objects.specification.Paging
import com.wrapper.spotify.model_objects.specification.Track
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest
import nom.brunokarpo.weatherplaylist.spotify.client.SpotifyClient
import org.springframework.stereotype.Component

@Component
class SpotifyClientImpl(
        private val clientCredentialsRequest: ClientCredentialsRequest
) : SpotifyClient {

    private var clientCredentials : ClientCredentials? = null

    override fun getPlaylistByStyle(style: String): Paging<Track> {
        return getSpotifyApi().searchTracks(style).limit(10).build().execute()
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