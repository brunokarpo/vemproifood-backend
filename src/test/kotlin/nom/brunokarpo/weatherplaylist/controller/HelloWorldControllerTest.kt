package nom.brunokarpo.weatherplaylist.controller

import io.restassured.RestAssured
import nom.brunokarpo.weatherplaylist.WeatherPlaylistApplicationTests
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Test

class HelloWorldControllerTest : WeatherPlaylistApplicationTests() {

    @Test
    fun `should say hello world`() {
        RestAssured.`when`()
                .get("/hello-world")
                .then()
                .statusCode(200)
                .body(equalTo("Hello World"))
    }
}