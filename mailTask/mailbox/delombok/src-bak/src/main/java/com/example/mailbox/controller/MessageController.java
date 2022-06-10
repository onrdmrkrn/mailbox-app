package com.example.mailbox.controller;

import com.example.mailbox.dto.AccountDto;
import com.example.mailbox.dto.Item;
import com.example.mailbox.dto.MessageDto;
import com.example.mailbox.exception.MessageSendException;
import com.example.mailbox.response.MessageListResponse;
import com.example.mailbox.response.MessageResponse;
import com.example.mailbox.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;


    @PostMapping("/consumer")
    public MessageListResponse findConsumer(@RequestBody Item item ){
        return messageService.findAllByConsumer(item);
    }


    @GetMapping("/publisher/{mail}")
    public MessageListResponse findPublisher(@PathVariable (value = "mail") String mail){
        return messageService.findAllByPublisher(mail);
    }


    @GetMapping("/read/{messageId}")
    public MessageResponse readMessages(@PathVariable (value = "messageId") String messageId){
        return messageService.readMessages(messageId);
    }


     @GetMapping("/find/{messageId}")
    public MessageResponse findMessage(@PathVariable (value = "messageId") String messageId){
        return messageService.findMessage(messageId);
    }


    @PostMapping("/sendmessage")
    public MessageResponse sendMessage(@RequestBody MessageDto messageDto, String userId)throws MessageSendException {
        return messageService.sendMessage(messageDto,userId);
    }


}
