package nom.brunokarpo.weatherplaylist.openweather.client

import nom.brunokarpo.weatherplaylist.openweather.model.Weather
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(url = "http://api.openweathermap.org/data/2.5/", name = "openweather")
interface OpenWeatherClient {

    @GetMapping("/weather")
    fun getWeather(@RequestParam("q") city: String, @RequestParam("appid") apiKey: String): Weather
}
