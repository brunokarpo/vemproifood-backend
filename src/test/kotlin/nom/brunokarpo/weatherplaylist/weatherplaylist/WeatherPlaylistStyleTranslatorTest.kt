package nom.brunokarpo.weatherplaylist.weatherplaylist

import nom.brunokarpo.weatherplaylist.openweather.model.MainWeather
import nom.brunokarpo.weatherplaylist.openweather.model.Weather
import nom.brunokarpo.weatherplaylist.weatherplaylist.impl.WeatherPlaylistStyleTranslatorImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class WeatherPlaylistStyleTranslatorTest {

    companion object {
        private const val CELSIUS_35_FAHRENHAINT: Double = 95.0
        private const val CELSIUS_30_FAHRENHAINT: Double = 86.0
        private const val CELSIUS_29_FAHRENHAINT: Double = 84.2
        private const val CELSIUS_15_FAHRENHAINT: Double = 59.0
        private const val CELSIUS_14_FAHRENHAINT: Double = 57.2
        private const val CELSIUS_10_FAHRENHAINT: Double = 50.0
        private const val CELSIUS_9_FAHRENHAINT: Double = 48.2
        private const val PARTY: String = "party"
        private const val POP: String = "pop"
        private const val ROCK: String = "rock"
        private const val CLASSICAL: String = "classical"
    }

    private lateinit var sut: WeatherPlaylistStyleTranslator

    @Before
    fun setUp() {
        sut = WeatherPlaylistStyleTranslatorImpl()
    }

    @Test
    fun `should suggest party tracks when temperature is above 30 C`() {
        validateTempTrackStyle(CELSIUS_35_FAHRENHAINT, PARTY)
    }

    @Test
    fun `should suggest party tracks when temperature is 30 C`() {
        validateTempTrackStyle(CELSIUS_30_FAHRENHAINT, PARTY)
    }

    @Test
    fun `should suggest pop music when temperature is 29 C`() {
        validateTempTrackStyle(CELSIUS_29_FAHRENHAINT, POP)
    }

    @Test
    fun `should suggest pop music when temperature is 15 C`() {
        validateTempTrackStyle(CELSIUS_15_FAHRENHAINT, POP)
    }

    @Test
    fun `should suggest rock tracks when temperature is 14 C`() {
        validateTempTrackStyle(CELSIUS_14_FAHRENHAINT, ROCK)
    }

    @Test
    fun `should suggest rock tracks when temperature is 10 C`() {
        validateTempTrackStyle(CELSIUS_10_FAHRENHAINT, ROCK)
    }

    @Test
    fun `should suggest classical tracks when temperature is above 10 C`() {
        validateTempTrackStyle(CELSIUS_9_FAHRENHAINT, CLASSICAL)
    }

    private fun validateTempTrackStyle(temp: Double, trackStyle: String) {
        var style = sut.getStyleByTemperature(Weather(main = MainWeather(temp)))
        assertThat(style).isEqualTo(trackStyle)
    }
}