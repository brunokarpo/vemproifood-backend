package nom.brunokarpo.weatherplaylist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
@EnableCaching
class WeatherPlaylistApplication

fun main(args: Array<String>) {
    runApplication<WeatherPlaylistApplication>(*args)
}

