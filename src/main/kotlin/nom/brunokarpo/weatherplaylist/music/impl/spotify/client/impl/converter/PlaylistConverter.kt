package nom.brunokarpo.weatherplaylist.music.impl.spotify.client.impl.converter

import com.wrapper.spotify.model_objects.specification.Paging
import nom.brunokarpo.weatherplaylist.music.model.MyPlaylistModel
import nom.brunokarpo.weatherplaylist.music.model.Track

class PlaylistConverter(
        var paging: Paging<com.wrapper.spotify.model_objects.specification.Track>
) {

    fun toPlaylist(): MyPlaylistModel {
        var trackList = mutableListOf<nom.brunokarpo.weatherplaylist.music.model.Track>()
        paging.items.asList().stream().forEach {
            trackList.add(
                    Track(
                            name = it.name,
                            album = it.album.name,
                            artist = it.album.artists[0].name
                    )
            )
        }
        return MyPlaylistModel(trackList)
    }
}