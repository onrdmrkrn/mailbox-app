package com.example.mailbox.response;

import com.example.mailbox.dto.MessageDto;

import java.io.Serializable;

public class MessageResponse extends BaseResponse implements Serializable {
    public MessageDto message;
}
