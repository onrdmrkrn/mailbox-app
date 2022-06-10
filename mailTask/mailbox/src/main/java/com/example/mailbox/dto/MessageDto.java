package com.example.mailbox.dto;

import java.io.Serializable;

public class MessageDto implements Serializable {
    public int messageId;
    public String consumer;
    public String publisher;
    public String mailDesc;
    public String mail;
    public boolean readed;
    public int status;
    public int accountId;

    public String mailTitle;
}
