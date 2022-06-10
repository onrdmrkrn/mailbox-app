package com.example.auth.api;

import com.example.auth.client.AccountClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient (name = "MAILBOX")
public interface AccountCallableApi extends AccountClient {


}
