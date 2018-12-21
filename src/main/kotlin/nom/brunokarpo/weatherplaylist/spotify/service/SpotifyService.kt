package nom.brunokarpo.weatherplaylist.spotify.service

import nom.brunokarpo.weatherplaylist.spotify.model.Playlist

interface SpotifyService {

    fun getPlaylistByStyle(style: String): Playlist

}
