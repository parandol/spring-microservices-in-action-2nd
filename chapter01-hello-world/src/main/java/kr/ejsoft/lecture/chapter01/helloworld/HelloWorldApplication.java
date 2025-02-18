package kr.ejsoft.lecture.chapter01.helloworld;

import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping(value = "hello")
public class HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }

    @GetMapping("/{firstName}")
    public String helloGet(
            @PathVariable("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        return String.format("{\"message\": \"Hello %s %s.\"}", firstName, lastName);
    }

    @PostMapping
    public String helloPost(@RequestBody HelloRequest request) {
        return String.format("{\"message\": \"Hello %s %s.\"}", request.getFirstName(), request.getLastName());
    }
}

@Getter
class HelloRequest {
    private String firstName;
    private String lastName;
}
