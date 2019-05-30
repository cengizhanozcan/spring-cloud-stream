package com.ceng.springcloud.orderservice.consumer;

import com.ceng.springcloud.movieservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;

@EnableBinding(Processor.class)
@Slf4j
public class OrderConsumer {

    @StreamListener(Processor.INPUT)
    public void handle(User user) {
        System.out.println("Order Service Username: " + user.getUsername());
    }

    @StreamListener(Processor.INPUT)
    public void handleMod(User user) {
        System.out.println("Username Mod: " + user.getUsername());
    }

}
