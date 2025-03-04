package com.example.GreetingApp.service;

import com.example.GreetingApp.dto.GreetingDTO;
import com.example.GreetingApp.dto.UserDTO;

public interface IGreetingService {
    GreetingDTO addGreeting(UserDTO user);
    GreetingDTO getGreetingById(long id);
}
