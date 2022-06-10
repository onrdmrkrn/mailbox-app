package com.example.mailbox.entity;

import com.example.mailbox.dto.AccountDto;

import javax.persistence.*;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountId;
    private int userId;

    @OneToMany(mappedBy = "account")
    private List<Message> messageList;

    public Account() {
    }

    public Account(int accountId, int userId, List<Message> messageList) {
        this.accountId = accountId;
        this.userId = userId;
        this.messageList = messageList;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
