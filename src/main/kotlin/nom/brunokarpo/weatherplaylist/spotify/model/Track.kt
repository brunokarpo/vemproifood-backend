package nom.brunokarpo.weatherplaylist.spotify.model

import java.io.Serializable

data class Track(
        var name: String,
        var album: String,
        var artist: String
): Serializable