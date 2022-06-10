package com.example.auth.dto;

import com.example.auth.entity.User;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;

public class UserDto implements Serializable {
    public int userId;
    public String userName;
    public String userLastName;
    public String mail;
    public String password;


}
