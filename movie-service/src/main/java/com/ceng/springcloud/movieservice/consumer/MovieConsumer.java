package com.ceng.springcloud.movieservice.consumer;

import com.ceng.springcloud.movieservice.model.User;
import com.ceng.springcloud.movieservice.processor.UserProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(UserProcessor.class)
@Slf4j
public class MovieConsumer {

    @StreamListener(UserProcessor.USER_CREATE_OUTPUT)
    public void userCreateConsumerAgain(User user) {
        System.out.println("UserConsumer.userCreateConsumerAgain: " + user.getUsername());
    }
}
