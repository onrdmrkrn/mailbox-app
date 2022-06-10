package com.example.mailbox.entity;

import com.example.mailbox.dto.AccountDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountId;
    private int userId;

    @OneToMany(mappedBy = "account")
    private List<Message> messageList;

}
