package nom.brunokarpo.weatherplaylist.openweather.client

import nom.brunokarpo.weatherplaylist.openweather.model.Weather
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class OpenWeatherClientTest {

    @Autowired
    private lateinit var sut : OpenWeatherClient

    @Test
    fun `should return weather of Salvador`() {
        var weather: Weather = sut.getWeather("Salvador")

        println(weather.name)
        println(weather.main!!.temp)
    }
}