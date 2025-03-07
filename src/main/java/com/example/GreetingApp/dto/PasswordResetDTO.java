package com.example.GreetingApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordResetDTO {
    private String currentPassword;
    private String newPassword;
    private String password;
}
