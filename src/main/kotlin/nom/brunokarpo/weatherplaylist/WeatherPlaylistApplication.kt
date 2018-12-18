package nom.brunokarpo.weatherplaylist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WeatherPlaylistApplication

fun main(args: Array<String>) {
    runApplication<WeatherPlaylistApplication>(*args)
}

