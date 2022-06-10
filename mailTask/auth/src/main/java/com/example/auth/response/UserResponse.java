package com.example.auth.response;

import com.example.auth.dto.UserDto;


import java.io.Serializable;

public class UserResponse extends BaseResponse implements Serializable {
    public UserDto user;
}
