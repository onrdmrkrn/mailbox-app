package com.example.mailbox.feign;

import com.example.mailbox.dto.UserDto;
import org.springframework.web.bind.annotation.*;



public interface AuthFeignClient {

    @GetMapping("/user/findUser/{userId}")
    UserDto find(@PathVariable(value = "userId") String userId);

    @GetMapping("/user/findMail/{mail}")
    UserDto findMail(@PathVariable (value = "mail") String mail);
}
