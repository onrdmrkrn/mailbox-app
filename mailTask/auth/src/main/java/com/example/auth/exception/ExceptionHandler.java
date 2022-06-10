package com.example.auth.exception;

import com.example.auth.response.Meta;
import com.example.auth.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(UserLoginException.class)
    public ResponseEntity<Object> loginException(UserLoginException exception, WebRequest webRequest) {
        UserResponse userResponse = new UserResponse();
        Meta response = new Meta();
        response.errorCode = 4004;
        response.errorDesc = " You must controll the information.";
        userResponse.meta = response;
        ResponseEntity<Object> entity = new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        return entity;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RegistrationException.class)
    public ResponseEntity<Object> createMailBox(RegistrationException exception, WebRequest webRequest) {
        UserResponse userResponse = new UserResponse();
        Meta response = new Meta();
        response.errorCode = 3005;
        response.errorDesc = "Cannot create account releated database.";
        userResponse.meta = response;
        ResponseEntity<Object> entity = new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        return entity;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserAlreadyException.class)
    public ResponseEntity<Object> userFoundedException(UserAlreadyException exception, WebRequest webRequest) {
        UserResponse userResponse = new UserResponse();
        Meta response = new Meta();
        response.errorCode = 4004;
        response.errorDesc = " This user already exists. Login";
        userResponse.meta = response;
        ResponseEntity<Object> entity = new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        return entity;
    }


}
