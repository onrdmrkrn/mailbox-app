package com.example.mailbox.response;

import com.example.mailbox.dto.AccountDto;
import com.example.mailbox.dto.MessageDto;

import java.io.Serializable;
import java.util.List;

public class MessageListResponse extends BaseResponse implements Serializable {

    public List<MessageDto> messageList;
}
