package com.example.mailbox.service.serviceImpl;

import com.example.mailbox.dto.AccountDto;
import com.example.mailbox.dto.Item;
import com.example.mailbox.dto.MessageDto;
import com.example.mailbox.entity.Account;
import com.example.mailbox.entity.Message;
import com.example.mailbox.exception.MessageSendException;
import com.example.mailbox.repository.MessageRepository;
import com.example.mailbox.response.MessageListResponse;
import com.example.mailbox.response.MessageResponse;
import com.example.mailbox.response.Meta;
import com.example.mailbox.service.AccountService;
import com.example.mailbox.service.MessageService;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MessagesServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    public Map<String, Message>messageMap;

    @Autowired
    AccountService accountService;

    private final HazelcastInstance hazelcastInstance;

    public MessagesServiceImpl(@Qualifier("hazelcastInstance")HazelcastInstance hazelcastInstance){
        this.hazelcastInstance=hazelcastInstance;
    }

    @Override
    public MessageListResponse findAllByConsumer(Item item) {
        MessageListResponse messageListResponse = new MessageListResponse();
        messageListResponse.messageList =Message.toResourceList(messageRepository.findAllByConsumerContaining(item.mail));
        messageListResponse.meta=new Meta(200);
        return messageListResponse;

    }

    @Override
    public MessageListResponse findAllByPublisher(String email) {
        MessageListResponse messageListResponse = new MessageListResponse();
        messageListResponse.messageList =Message.toResourceList(messageRepository.findAllByPublisherContaining(email));
        messageListResponse.meta=new Meta(200);
        return null;
    }

    public MessageResponse sendMessage(MessageDto messageDto, String userId) throws MessageSendException {
        MessageResponse messageResponse = new MessageResponse();
        Account account = accountService.findAccount(Integer.parseInt(userId));
        account.setAccountId(messageDto.accountId);
        Message message =Message.fromResource(messageDto,account);

        message = messageRepository.save(message);
        if (message == null)
            throw new MessageSendException();
        messageResponse.meta=new Meta(200);
        return messageResponse;
    }

    @Override
    public MessageResponse readMessages(String messageId) {
        Message message = messageRepository.findMessageByMessageId(Integer.parseInt(messageId));
        message.setStatus(1);
        message=messageRepository.save(message);
        MessageResponse response = new MessageResponse();
        response.message =Message.toResource(message);
        response.meta = new Meta(200);
        return response;
    }

    @Override
    public MessageResponse findMessage(String messageId) {
        MessageResponse response = new MessageResponse();
        response.message = Message.toResource(messageRepository.findMessageByMessageId(Integer.parseInt(messageId)));
        response.meta = new Meta(200);
        return response;
    }

    public Message getSession(String key) {
        Map<String, Message> messageIMap = hazelcastInstance.getMap("messageMap");
        return messageIMap.get(key);
    }

    public void addSession(String key, Message order) {
        Map<String, Message> messageIMap = hazelcastInstance.getMap("messageMap");
        messageIMap.put(key, order);
    }
}
