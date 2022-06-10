package com.example.mailbox.controller;

import com.example.mailbox.dto.UserDto;
import com.example.mailbox.response.CreateAccountResponse;
import com.example.mailbox.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/create")
    public CreateAccountResponse createMailBox(@RequestBody UserDto userDto){
        return accountService.createMailBox(userDto);
    }

}
