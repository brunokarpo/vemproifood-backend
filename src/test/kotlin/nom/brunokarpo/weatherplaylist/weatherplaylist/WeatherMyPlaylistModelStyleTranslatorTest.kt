package nom.brunokarpo.weatherplaylist.weatherplaylist

import nom.brunokarpo.weatherplaylist.music.model.PlaylistStyle
import nom.brunokarpo.weatherplaylist.weather.model.MainWeather
import nom.brunokarpo.weatherplaylist.weather.model.Weather
import nom.brunokarpo.weatherplaylist.weatherplaylist.impl.WeatherPlaylistStyleTranslatorImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class WeatherMyPlaylistModelStyleTranslatorTest {

    companion object {
        private const val CELSIUS_35_FAHRENHAINT: Double = 95.0
        private const val CELSIUS_30_FAHRENHAINT: Double = 86.0
        private const val CELSIUS_29_FAHRENHAINT: Double = 84.2
        private const val CELSIUS_15_FAHRENHAINT: Double = 59.0
        private const val CELSIUS_14_FAHRENHAINT: Double = 57.2
        private const val CELSIUS_10_FAHRENHAINT: Double = 50.0
        private const val CELSIUS_9_FAHRENHAINT: Double = 48.2
    }

    private lateinit var sut: WeatherPlaylistStyleTranslator

    @Before
    fun setUp() {
        sut = WeatherPlaylistStyleTranslatorImpl()
    }

    @Test
    fun `should suggest party tracks when temperature is above 30 C`() {
        validateTempTrackStyle(CELSIUS_35_FAHRENHAINT, PlaylistStyle.PARTY)
    }

    @Test
    fun `should suggest party tracks when temperature is 30 C`() {
        validateTempTrackStyle(CELSIUS_30_FAHRENHAINT, PlaylistStyle.PARTY)
    }

    @Test
    fun `should suggest pop music when temperature is 29 C`() {
        validateTempTrackStyle(CELSIUS_29_FAHRENHAINT, PlaylistStyle.POP)
    }

    @Test
    fun `should suggest pop music when temperature is 15 C`() {
        validateTempTrackStyle(CELSIUS_15_FAHRENHAINT, PlaylistStyle.POP)
    }

    @Test
    fun `should suggest rock tracks when temperature is 14 C`() {
        validateTempTrackStyle(CELSIUS_14_FAHRENHAINT, PlaylistStyle.ROCK)
    }

    @Test
    fun `should suggest rock tracks when temperature is 10 C`() {
        validateTempTrackStyle(CELSIUS_10_FAHRENHAINT, PlaylistStyle.ROCK)
    }

    @Test
    fun `should suggest classical tracks when temperature is above 10 C`() {
        validateTempTrackStyle(CELSIUS_9_FAHRENHAINT, PlaylistStyle.CLASSICAL)
    }

    private fun validateTempTrackStyle(temp: Double, trackStyle: PlaylistStyle) {
        var style = sut.getStyleByTemperature(Weather(main = MainWeather(temp)))
        assertThat(style).isEqualTo(trackStyle)
    }
}