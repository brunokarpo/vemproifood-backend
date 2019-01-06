package nom.brunokarpo.weatherplaylist.spotify.configuration

import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpotifyConfiguration(
        @Value("\${spotify.clientId}") private val clientId: String,
        @Value("\${spotify.secretKey}") private val secretKey: String
) {


    @Bean("clientCredencialRequest")
    fun getClientCredentialsRequest(): ClientCredentialsRequest {
        val spotifyApi: SpotifyApi = SpotifyApi.builder().apply {
            setClientId(clientId)
            setClientSecret(secretKey)
        }.build()
        return spotifyApi.clientCredentials().build()
    }

}