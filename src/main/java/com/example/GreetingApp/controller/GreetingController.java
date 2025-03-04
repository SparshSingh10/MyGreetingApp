package com.example.GreetingApp.controller;

import com.example.GreetingApp.dto.GreetingDTO;
import com.example.GreetingApp.dto.UserDTO;
import com.example.GreetingApp.service.GreetingService;
import com.example.GreetingApp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/greetings")
public class GreetingController {
    @Autowired
    private IGreetingService greetingService;

    @PostMapping ("/add")
    public GreetingDTO getGreeting(@RequestParam(value = "firstName", required = false) String firstName, @RequestParam(value = "lastName", required = false) String lastName) {
        UserDTO user = new UserDTO();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }
}
