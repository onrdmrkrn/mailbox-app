package com.example.auth.service.AuthServiceImpl;

import com.example.auth.api.AccountCallableApi;
import com.example.auth.dto.UserDto;
import com.example.auth.entity.User;
import com.example.auth.exception.RegistrationException;
import com.example.auth.exception.UserAlreadyException;
import com.example.auth.exception.UserLoginException;

import com.example.auth.repository.UserRepository;
import com.example.auth.response.CreateAccountResponse;
import com.example.auth.response.Meta;
import com.example.auth.response.UserResponse;
import com.example.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountCallableApi accountCallableApi;


    public UserResponse register(UserDto dto) throws UserAlreadyException, RegistrationException {
        User existingUser = userRepository.findUserByMail(dto.mail);
        if (existingUser != null){
            throw new UserAlreadyException();
        }
        User user = User.fromResource(dto);
        user = userRepository.save(user);
        dto.userId=user.getUserId();
        CreateAccountResponse accountResponse= accountCallableApi.createMailBox(dto);
        if (accountResponse.meta.errorCode!=200){
            throw new RegistrationException();
        }
        return createdUser(User.toResource(user));
    }

    public UserResponse login(UserDto userDto) throws UserLoginException {
        User user =userRepository.findUserByMailAndPassword(userDto.mail, userDto.password);
        if (user == null){
            throw new UserLoginException();
        }
        return createdUser(User.toResource(user));
    }

    private UserResponse createdUser(UserDto toResourse) {
        UserResponse userResponse = new UserResponse();
        userResponse.meta=new Meta(200);
        userResponse.user = toResourse;
        return userResponse;
    }

    public User findUser(int userId) {
        User user = userRepository.findUserByUserId(userId);
        return user;
    }
    public UserDto findUserByDto(int userId) {
        User user = findUser(userId);
        UserDto userDto=User.toResource(user);
        return userDto;
    }


}
