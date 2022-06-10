package com.example.mailbox.repository;

import com.example.mailbox.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    public List<Message> findAllByConsumerContaining(String consumer);
    public Message findMessageByConsumer(String consumer);
    public List<Message> findAllByPublisherContaining(String publisher);
    public Message findMessageByMessageId(int messageId);
}
