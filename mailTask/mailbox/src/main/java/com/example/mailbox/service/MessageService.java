package com.example.mailbox.service;

import com.example.mailbox.dto.AccountDto;
import com.example.mailbox.dto.Item;
import com.example.mailbox.dto.MessageDto;
import com.example.mailbox.exception.MessageSendException;
import com.example.mailbox.response.MessageListResponse;
import com.example.mailbox.response.MessageResponse;

import java.util.List;

public interface MessageService {

    public MessageListResponse findAllByConsumer(Item item);

    public MessageListResponse findAllByPublisher(Item item);

    public MessageResponse sendMessage(MessageDto messageDto ,String userId)throws MessageSendException;

    MessageResponse readMessages(String messageId);

    MessageResponse findMessage(String messageId);
}
