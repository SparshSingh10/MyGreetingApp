package com.example.GreetingApp.service;

import com.example.GreetingApp.dto.GreetingDTO;
import com.example.GreetingApp.dto.UserDTO;

import java.util.List;

public interface IGreetingService {
    GreetingDTO addGreeting(UserDTO user);
    GreetingDTO getGreetingById(long id);
    List<GreetingDTO> getAllGreetings();
}
