package nom.brunokarpo.weatherplaylist.openweather.client

import nom.brunokarpo.weatherplaylist.openweather.model.Weather
import org.assertj.core.api.Assertions.assertThat
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

        assertThat(weather).isNotNull
        assertThat(weather.name).isEqualTo("Salvador")
        assertThat(weather.main).isNotNull
        assertThat(weather.main!!.temp).isNotNull()
    }

    @Test
    fun `should return weather for lat and log coordinates`() {
        var weather: Weather = sut.getWeather(-49.25, -16.68)

        assertThat(weather).isNotNull
        assertThat(weather.name).isEqualTo("Goiania")
        assertThat(weather.main).isNotNull
        assertThat(weather.main!!.temp).isNotNull()
    }
}