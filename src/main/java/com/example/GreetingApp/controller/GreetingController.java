package com.example.GreetingApp.controller;

import com.example.GreetingApp.dto.GreetingDTO;
import com.example.GreetingApp.dto.UserDTO;
import com.example.GreetingApp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    @Autowired
    private IGreetingService greetingService;

    @PostMapping("")
    public GreetingDTO getGreeting(@RequestParam(value = "firstName", defaultValue = "", required = false) String firstName,
                                   @RequestParam(value = "lastName", defaultValue = "", required = false) String lastName) {
        UserDTO user = new UserDTO();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/{id}")
    public GreetingDTO getGreetingById(@PathVariable(value = "id") long id) {
        return greetingService.getGreetingById(id);
    }
    @GetMapping("")
    public List<GreetingDTO> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
    @PutMapping("/{id}")
    public GreetingDTO updateGreeting(
            @PathVariable long id,
            @RequestParam String message) {
        return greetingService.updateGreeting(id, message);
    }
    @DeleteMapping("/{id}")
    public String deleteGreeting(@PathVariable long id){
        greetingService.deleteGreeting(id);
        return "Greeting deleted successfully";
    }


}
