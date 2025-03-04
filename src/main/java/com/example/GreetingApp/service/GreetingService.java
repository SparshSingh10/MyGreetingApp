package com.example.GreetingApp.service;


import com.example.GreetingApp.dto.GreetingDTO;
import com.example.GreetingApp.dto.UserDTO;
import com.example.GreetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public GreetingDTO addGreeting(UserDTO user) {
        String fullName = (user.getFirstName() != null ? user.getFirstName() : "") +
                (user.getLastName() != null ? " " + user.getLastName() : "");

        // Default to "World" if name is empty
        if (fullName.trim().isEmpty()) {
            fullName = "World";
        }

        String message = String.format(template, fullName);
        return new GreetingDTO(counter.incrementAndGet(), message);
    }

}