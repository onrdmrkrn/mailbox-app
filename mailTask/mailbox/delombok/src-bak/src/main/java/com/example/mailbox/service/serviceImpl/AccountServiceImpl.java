package com.example.mailbox.service.serviceImpl;

import com.example.mailbox.dto.UserDto;
import com.example.mailbox.entity.Account;
import com.example.mailbox.feign.AuthCallableApi;
import com.example.mailbox.repository.AccountRepository;
import com.example.mailbox.response.CreateAccountResponse;
import com.example.mailbox.response.Meta;
import com.example.mailbox.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AuthCallableApi authCallableApi;

    @Autowired
    AccountRepository accountRepository;


    public CreateAccountResponse createMailBox(UserDto userDto){
        CreateAccountResponse response = new CreateAccountResponse();
        Meta meta=new Meta();
        meta.errorCode=200;
        Account account = new Account();
        account.setUserId(userDto.userId);
        account = accountRepository.save(account);
        if (account==null){
            meta.errorCode=3005;
        }
        response.meta=meta;
        return response;
    }

    @Override
    public Account findAccount(int userId) {
        return accountRepository.findByUserId(userId);
    }


}


