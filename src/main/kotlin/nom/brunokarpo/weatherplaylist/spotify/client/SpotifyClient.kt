package nom.brunokarpo.weatherplaylist.spotify.client

import nom.brunokarpo.weatherplaylist.spotify.model.Playlist

interface SpotifyClient {

    fun getPlaylistByStyle(style: String): Playlist

}
