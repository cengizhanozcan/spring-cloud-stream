package com.ceng.tutorial.springcloud.userservice.consumer;

import com.ceng.springcloud.movieservice.model.User;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

@EnableBinding(Source.class)
public class UserSource {

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1"))
    public MessageSource<User> timerUserSource(){
        return () -> new GenericMessage<>(new User("cengizhanozcan"));
    }
}
