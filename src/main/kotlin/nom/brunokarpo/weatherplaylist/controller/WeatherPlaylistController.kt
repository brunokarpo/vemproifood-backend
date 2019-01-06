package nom.brunokarpo.weatherplaylist.controller

import nom.brunokarpo.weatherplaylist.spotify.model.Playlist
import nom.brunokarpo.weatherplaylist.weatherplaylist.WeatherPlaylistAggregatorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/playlist")
class WeatherPlaylistController(
        private var weatherPlaylistAggregatorService: WeatherPlaylistAggregatorService
) {

    @GetMapping("/{city}")
    fun getPlaylistByCity(@PathVariable("city") city: String) : ResponseEntity<Playlist> {
        var playlist = weatherPlaylistAggregatorService.getPlaylist(city)
        return ResponseEntity.ok(playlist)
    }

    @GetMapping("/{longitude}/{latitude}")
    fun getPlaylistByCoordinates(@PathVariable("longitude") longitude: Double,
                                 @PathVariable("latitude") latitude: Double) : ResponseEntity<Playlist> {
        var playlist = weatherPlaylistAggregatorService.getPlaylist(longitude, latitude)
        return ResponseEntity.ok(playlist)
    }
}