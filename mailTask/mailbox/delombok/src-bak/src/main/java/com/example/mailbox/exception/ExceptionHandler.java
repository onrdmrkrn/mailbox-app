package com.example.mailbox.exception;


import com.example.mailbox.response.MessageResponse;
import com.example.mailbox.response.Meta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> mailAddException(MessageSendException exception, WebRequest webRequest) {
        MessageResponse messageResponse=new MessageResponse();
        Meta meta = new Meta();
        meta.errorCode = 4004;
        meta.errorDesc = "Error while sending messages";
        messageResponse.meta=meta;
        ResponseEntity<Object> entity = new ResponseEntity<>(messageResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
}
