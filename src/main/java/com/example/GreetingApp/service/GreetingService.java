package com.example.GreetingApp.service;

import com.example.GreetingApp.dto.GreetingDTO;
import com.example.GreetingApp.dto.UserDTO;
import com.example.GreetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GreetingService implements IGreetingService {
    private static final String template = "Hello, %s!";

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public GreetingDTO addGreeting(UserDTO user) {
        String message = String.format(template, (user.getFirstName().isEmpty() && user.getLastName().isEmpty()) ? "World" : user.getFirstName() + " " + user.getLastName());
        GreetingDTO greeting = new GreetingDTO(null, message); // ID is auto-generated
        return greetingRepository.save(greeting);
    }

    @Override
    public GreetingDTO getGreetingById(long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with id: " + id));
    }
    @Override
    public List<GreetingDTO> getAllGreetings() {
        return greetingRepository.findAll()
                .stream()
                .map(greeting -> new GreetingDTO(greeting.getId(), greeting.getMessage()))
                .collect(Collectors.toList());
    }
}
