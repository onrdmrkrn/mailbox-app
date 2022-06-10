package com.example.mailbox.entity;

import com.example.mailbox.dto.MessageDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int messageId;
    private String consumer;
    private String publisher;
    private String mailDesc;
    private String mailTitle;
    private int status;

    @ManyToOne
    private Account account;

    public static Message fromResource(MessageDto dto, Account account) {
        Message message = new Message();
        message.setAccount(account);
        message.setConsumer(dto.consumer);
        message.setPublisher(dto.publisher);
        message.setMailDesc(dto.mailDesc);
        message.setStatus(dto.status);
        message.setMailTitle(dto.mailTitle);
        return message;
    }
    public static MessageDto toResource(Message message) {
        MessageDto dto = new MessageDto();
        dto.consumer=message.consumer;
        dto.publisher=message.getPublisher();
        dto.mailDesc=message.getMailDesc();
        dto.mailTitle=message.getMailTitle();
        dto.readed=message.status == 0 ? false :true;
        dto.messageId=message.getMessageId();
        return dto;
    }
      public static List<MessageDto> toResourceList(List<Message> messageList) {
       List<MessageDto> dtos=new ArrayList<>();
          for (Message message:messageList ) {
              dtos.add(toResource(message)) ;
          }
        return dtos;
    }

    public Message() {
    }

    public Message(int messageId, String consumer, String publisher, String mailDesc, String mailTitle, int status, Account account) {
        this.messageId = messageId;
        this.consumer = consumer;
        this.publisher = publisher;
        this.mailDesc = mailDesc;
        this.mailTitle = mailTitle;
        this.status = status;
        this.account = account;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getMailDesc() {
        return mailDesc;
    }

    public void setMailDesc(String mailDesc) {
        this.mailDesc = mailDesc;
    }

    public String getMailTitle() {
        return mailTitle;
    }

    public void setMailTitle(String mailTitle) {
        this.mailTitle = mailTitle;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
