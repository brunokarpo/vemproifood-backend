package nom.brunokarpo.weatherplaylist.openweather.client

import nom.brunokarpo.weatherplaylist.openweather.model.Weather
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient("openweather", url = "\${openweather.url}")
interface OpenWeatherClient {

    @GetMapping("/weather?APPID=\${openweather.api-key}&units=imperial")
    fun getWeather(@RequestParam("q") city: String): Weather

    @GetMapping("/weather?APPID=\${openweather.api-key}&units=imperial")
    fun getWeather(@RequestParam("lon") lon: Double, @RequestParam("lat") lat: Double): Weather
}
