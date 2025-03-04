package com.example.GreetingApp.controller;

import com.example.GreetingApp.dto.GreetingDTO;
import org.springframework.web.bind.annotation.*;
    @RestController
    @RequestMapping("/greetings")

    public class GreetingController {
    @GetMapping
    public GreetingDTO getGreeting() {
        return new GreetingDTO("Hello, World!");
    }

    @PostMapping
    public GreetingDTO createGreeting(@RequestBody GreetingDTO greeting) {
        return new GreetingDTO("Created: " + greeting.getMessage());
    }

    @PutMapping
    public GreetingDTO updateGreeting(@RequestBody GreetingDTO greeting) {
        return new GreetingDTO("Updated: " + greeting.getMessage());
    }

    @DeleteMapping
    public GreetingDTO deleteGreeting() {
        return new GreetingDTO("Deleted");
    }

}
