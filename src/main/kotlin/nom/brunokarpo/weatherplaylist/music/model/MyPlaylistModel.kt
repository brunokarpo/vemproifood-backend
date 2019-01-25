package nom.brunokarpo.weatherplaylist.music.model

import java.io.Serializable

data class MyPlaylistModel(
        var tracks: List<Track>
) : Serializable