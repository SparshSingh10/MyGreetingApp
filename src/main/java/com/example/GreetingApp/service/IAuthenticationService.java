package com.example.GreetingApp.service;

import com.example.GreetingApp.dto.AuthUserDTO;
import com.example.GreetingApp.dto.LoginDTO;
import com.example.GreetingApp.exception.UserException;
import com.example.GreetingApp.model.AuthUser;

public interface IAuthenticationService {
    AuthUser register(AuthUserDTO userDTO) throws Exception;
    String login(LoginDTO loginDTO) throws UserException;
    void forgotPassword(String email, String newPassword);
    void resetPassword(String email, String currentPassword, String newPassword);
}
