package nom.brunokarpo.weatherplaylist.music.model

import java.io.Serializable

data class Track(
        var name: String,
        var album: String,
        var artist: String
): Serializable