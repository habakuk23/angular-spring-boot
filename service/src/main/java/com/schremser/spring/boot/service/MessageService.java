package com.schremser.spring.boot.service;

import com.schremser.spring.boot.domain.Message;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Singleton
@Service
public class MessageService {
    List<Message> messages = Collections.synchronizedList(new ArrayList<>());

    @PostConstruct
    public void init() {
        messages.add(new Message("Hello", "World"));
    }

    public List<Message> getMessages() {
        return messages;
    }
}
