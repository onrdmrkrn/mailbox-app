package com.example.auth.service;

import com.example.auth.dto.UserDto;
import com.example.auth.exception.RegistrationException;
import com.example.auth.exception.UserAlreadyException;
import com.example.auth.exception.UserLoginException;
import com.example.auth.response.UserResponse;


public interface UserService {
    public UserResponse register(UserDto userDto) throws UserAlreadyException, RegistrationException;
    public UserResponse login(UserDto userDto) throws UserLoginException;
    public UserDto findUserByDto(int userId);


}
