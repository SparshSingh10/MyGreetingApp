package com.example.GreetingApp.exception;


import com.example.GreetingApp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ResponseDTO> handleUserException(UserException exception) {
        ResponseDTO responseDTO = new ResponseDTO(exception.getMessage(), null);
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }
}