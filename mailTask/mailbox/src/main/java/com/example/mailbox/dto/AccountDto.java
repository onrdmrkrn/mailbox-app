package com.example.mailbox.dto;

import com.example.mailbox.entity.Account;
import com.example.mailbox.entity.Message;

import java.io.Serializable;
import java.util.List;

public class AccountDto implements Serializable {
    public int accountId;
    public int userId;
    public List<Message> messageList;




    public AccountDto accountToDto(Account account){
        AccountDto accountDto = new AccountDto();
        accountDto.accountId = account.getAccountId();
        accountDto.userId = account.getUserId();
        return accountDto;
    }
}
