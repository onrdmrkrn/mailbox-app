package com.example.auth.repository;

import com.example.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserByMailAndPassword(String mail, String password);
    public User findUserByUserId(int userId);

    public User findUserByMail (String mail);
}
