package com.example.mailbox.repository;

import com.example.mailbox.entity.Account;
import com.example.mailbox.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    public Account findByUserId(int userId);


    public List<Message> findAllByUserId (int userId);
}
