package nom.brunokarpo.weatherplaylist.spotify.service

import com.wrapper.spotify.model_objects.specification.Paging
import com.wrapper.spotify.model_objects.specification.Track

interface SpotifyService {

    fun getPlaylistByStyle(style: String): Paging<Track>

}
