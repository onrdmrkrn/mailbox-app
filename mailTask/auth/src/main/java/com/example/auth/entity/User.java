package com.example.auth.entity;

import com.example.auth.dto.UserDto;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    private String userLastName;

    @Column(unique = true)
    private String mail;

    private String password;

    public static User fromResource(UserDto dto) {
        User user = new User();
        user.setUserId(dto.userId);
        user.setUserName(dto.userName);
        user.setUserLastName(dto.userLastName);
        user.setPassword(dto.password);
        user.setMail(dto.mail);
        return user;
    }

    public static UserDto toResource(User entity) {
        UserDto dto = new UserDto();
        dto.userId = entity.getUserId();
        dto.userName = entity.getUserName();
        dto.userLastName = entity.getUserLastName();
        dto.mail = entity.getMail();
        return dto;
    }

    public User() {
    }

    public User(int userId, String userName, String userLastName, String mail, String password) {
        this.userId = userId;
        this.userName = userName;
        this.userLastName = userLastName;
        this.mail = mail;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
