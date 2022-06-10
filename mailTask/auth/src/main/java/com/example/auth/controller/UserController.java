package com.example.auth.controller;

import com.example.auth.dto.UserDto;
import com.example.auth.exception.UserLoginException;
import com.example.auth.response.UserResponse;
import com.example.auth.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserDto userDto) throws Exception{
        return userService.register(userDto);
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody UserDto userDto) throws UserLoginException {
        return userService.login(userDto);
    }

    @GetMapping("/findUser/{userId}")
    public UserDto find(@PathVariable(value = "userId") String userId){
        return  userService.findUserByDto(Integer.parseInt(userId));
    }

}
