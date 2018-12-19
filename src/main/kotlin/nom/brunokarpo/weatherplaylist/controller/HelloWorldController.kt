package nom.brunokarpo.weatherplaylist.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello-world")
class HelloWorldController {

    @GetMapping
    fun sayHello() : ResponseEntity<String> {
        return ResponseEntity.ok("Hello World")
    }

}