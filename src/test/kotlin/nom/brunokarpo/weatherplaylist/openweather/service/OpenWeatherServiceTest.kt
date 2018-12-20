package nom.brunokarpo.weatherplaylist.openweather.service

import nom.brunokarpo.weatherplaylist.openweather.client.OpenWeatherClient
import nom.brunokarpo.weatherplaylist.openweather.model.MainWeather
import nom.brunokarpo.weatherplaylist.openweather.model.Weather
import nom.brunokarpo.weatherplaylist.openweather.service.impl.OpenWeatherServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@Ignore
class OpenWeatherServiceTest {

    companion object {
        private const val CITY: String = "Salvador"
        private const val LAT: Double = 50.0
        private const val LON: Double = 45.0
        private const val TEMP: Double = 90.0
    }

    @MockBean
    private lateinit var clientMock: OpenWeatherClient

    private lateinit var sut: OpenWeatherService

    @Before
    fun setUp() {
        sut = OpenWeatherServiceImpl(clientMock)

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
}