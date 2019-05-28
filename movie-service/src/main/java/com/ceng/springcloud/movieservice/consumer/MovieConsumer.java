package com.ceng.springcloud.movieservice.consumer;

import com.ceng.springcloud.movieservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Processor.class)
@Slf4j
public class MovieConsumer {

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public User handle(User user) {
        System.out.println("Username: " + user.getUsername());
        user.setUsername(user.getUsername() + " - transform");
        return user;
    }

    @StreamListener(Processor.OUTPUT)
    public void handleMod(User user) {
        System.out.println("Username Mod: " + user.getUsername());
    }

}
