package nom.brunokarpo.weatherplaylist.spotify.model

import java.io.Serializable

data class MyPlaylistModel(
        var tracks: List<Track>
) : Serializable