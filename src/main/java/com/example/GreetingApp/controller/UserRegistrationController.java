package com.example.GreetingApp.controller;

import com.example.GreetingApp.exception.UserException;
import jakarta.validation.Valid;
import com.example.GreetingApp.dto.AuthUserDTO;
import com.example.GreetingApp.dto.LoginDTO;
import com.example.GreetingApp.dto.ResponseDTO;
import com.example.GreetingApp.dto.PasswordResetDTO;
import com.example.GreetingApp.model.AuthUser;
import com.example.GreetingApp.service.EmailSenderService;
import com.example.GreetingApp.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserRegistrationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody AuthUserDTO userDTO) {
        try {
            AuthUser user = authenticationService.register(userDTO);
            ResponseDTO responseUserDTO = new ResponseDTO("User details is submitted!", user);
            return new ResponseEntity<>(responseUserDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO("User details is not submitted!", userDTO), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO loginDTO) throws UserException {
        try {
            String result = authenticationService.login(loginDTO);
            ResponseDTO responseUserDTO = new ResponseDTO("Login successfully!!", result);
            return new ResponseEntity<>(responseUserDTO, HttpStatus.OK);
        } catch (UserException e) {
            return new ResponseEntity<>(new ResponseDTO("Login failed!!"+e.getMessage(), loginDTO), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/forgotPassword/{email}")
    public ResponseEntity<ResponseDTO> forgotPassword(@PathVariable String email, @RequestBody PasswordResetDTO passwordResetDTO) {
        authenticationService.forgotPassword(email, passwordResetDTO.getPassword());
        return ResponseEntity.ok(new ResponseDTO("Password has been changed successfully!", email));
    }

    @PutMapping("/resetPassword/{email}")
    public ResponseEntity<ResponseDTO> resetPassword(@PathVariable String email, @RequestBody PasswordResetDTO passwordResetDTO) {
        authenticationService.resetPassword(email, passwordResetDTO.getCurrentPassword(), passwordResetDTO.getNewPassword());
        return ResponseEntity.ok(new ResponseDTO("Password reset successfully!", email));
    }

}