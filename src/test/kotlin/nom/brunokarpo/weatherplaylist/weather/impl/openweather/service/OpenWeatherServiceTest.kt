package nom.brunokarpo.weatherplaylist.weather.impl.openweather.service

import feign.FeignException
import nom.brunokarpo.weatherplaylist.weather.impl.openweather.client.OpenWeatherClient
import nom.brunokarpo.weatherplaylist.weather.model.MainWeather
import nom.brunokarpo.weatherplaylist.weather.model.Weather
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class OpenWeatherServiceTest {

    companion object {
        private const val CITY: String = "Salvador"
        private const val LAT: Double = 50.0
        private const val LON: Double = 45.0
        private const val TEMP: Double = 90.0
    }

    @MockBean
    private lateinit var clientMock: OpenWeatherClient

    @Autowired
    private lateinit var sut: OpenWeatherService

    @Before
    fun setUp() {
        val weather = Weather(main = MainWeather(TEMP)
                , name = CITY
        )

        Mockito.`when`(clientMock.getWeather(CITY)).thenReturn(weather)
        Mockito.`when`(clientMock.getWeather(LON, LAT)).thenReturn(weather)

    }

    @Test
    fun `should call client to retrieve weather by city name`() {
        var weather: Weather = sut.getWeather(CITY)

        Mockito.verify(clientMock).getWeather(CITY)

        assertThat(weather).isNotNull
    }

    @Test
    fun `should call client to retrieve weather by coordinates`() {
        var weather: Weather = sut.getWeather(LON, LAT)

        Mockito.verify(clientMock).getWeather(LON, LAT)

        assertThat(weather).isNotNull
    }

    @Test
    fun `should return a cool climate when client fail to retrieve by name`() {
        Mockito.doThrow(FeignException::class.java)
                .`when`(clientMock).getWeather(CITY)

        var weather = sut.getWeather(CITY)

        assertThat(weather).isNotNull
        assertThat(weather.name).isEqualTo(CITY)
        assertThat(weather.main).isNotNull
        assertThat(weather.main!!.temp).isEqualTo(71.6)
    }

    @Test
    fun `should return a cool climate when client fail to retrieve by coordinates`() {
        Mockito.doThrow(FeignException::class.java)
                .`when`(clientMock).getWeather(LON, LAT)

        var weather = sut.getWeather(LON, LAT)

        assertThat(weather).isNotNull
        assertThat(weather.main).isNotNull
        assertThat(weather.main!!.temp).isEqualTo(71.6)
    }
}