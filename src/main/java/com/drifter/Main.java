package com.drifter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/hello")
    public GreetResponse greet(){
        GreetResponse response = new GreetResponse(
                "Hello",
                List.of("Java", "Python", "C#"),
                new Person("Don", 23, 10000)
        );
        return response;
    }

    public record Person (String name, int age, double savings) {

    }

    public record GreetResponse (
            String greet,
            List<String> favoriteProgrammingLanguages,
            Person person
    ) {

    }
}
