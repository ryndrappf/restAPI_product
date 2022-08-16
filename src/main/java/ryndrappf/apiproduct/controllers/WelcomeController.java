package ryndrappf.apiproduct.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {
    //sayWelcome
    @GetMapping
    public String sayWelcome(){
        return "Welcome to Spring Boot Rest API";
    }
}
