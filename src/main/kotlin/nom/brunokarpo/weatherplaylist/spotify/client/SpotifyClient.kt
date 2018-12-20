package nom.brunokarpo.weatherplaylist.spotify.client

import com.wrapper.spotify.model_objects.specification.Paging
import com.wrapper.spotify.model_objects.specification.Track

interface SpotifyClient {

    fun getPlaylistByStyle(style: String): Paging<Track>

}
