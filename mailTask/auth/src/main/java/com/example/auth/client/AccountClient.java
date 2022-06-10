package com.example.auth.client;

import com.example.auth.dto.UserDto;
import com.example.auth.response.CreateAccountResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AccountClient {

    @PostMapping("/account/create")
    public CreateAccountResponse createMailBox(@RequestBody UserDto userDto);
}
