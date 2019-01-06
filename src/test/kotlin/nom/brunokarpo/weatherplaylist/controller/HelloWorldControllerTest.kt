package nom.brunokarpo.weatherplaylist.controller

import io.restassured.RestAssured
import nom.brunokarpo.weatherplaylist.WeatherMyPlaylistModelApplicationTests
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Test

class HelloWorldControllerTest : WeatherMyPlaylistModelApplicationTests() {

    @Test
    fun `should say hello world`() {
        RestAssured.`when`()
                .get("/hello-world")
                .then()
                .statusCode(200)
                .body(equalTo("Hello World"))
    }
}