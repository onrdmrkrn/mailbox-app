package com.example.mailbox.response;

import com.example.mailbox.dto.AccountDto;

import java.io.Serializable;

public class AccountResponse extends BaseResponse implements Serializable {
    public AccountDto accountDto;
}
