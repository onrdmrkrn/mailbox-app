package com.example.mailbox.feign;

@org.springframework.cloud.openfeign.FeignClient(name = "AUTH")
public interface AuthCallableApi extends AuthFeignClient {



}
