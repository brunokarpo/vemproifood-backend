package nom.brunokarpo.weatherplaylist.controller

import nom.brunokarpo.weatherplaylist.music.model.MyPlaylistModel
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
    fun getPlaylistByCity(@PathVariable("city") city: String) : ResponseEntity<MyPlaylistModel> {
        var playlist = weatherPlaylistAggregatorService.getPlaylist(city)
        return ResponseEntity.ok(playlist)
    }

    @GetMapping("/{longitude}/{latitude}")
    fun getPlaylistByCoordinates(@PathVariable("longitude") longitude: Double,
                                 @PathVariable("latitude") latitude: Double) : ResponseEntity<MyPlaylistModel> {
        var playlist = weatherPlaylistAggregatorService.getPlaylist(longitude, latitude)
        return ResponseEntity.ok(playlist)
    }
}