package com.ceng.tutorial.springcloud.userservice.consumer;

import com.ceng.springcloud.movieservice.model.User;
import com.ceng.springcloud.movieservice.processor.UserProcessor;
import com.ceng.tutorial.springcloud.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@EnableBinding(UserProcessor.class)
@Service
public class UserConsumer {

    @Autowired
    private UserService userService;

//    @Bean
//    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1"))
//    public MessageSource<User> timerUserSource(){
//        return () -> new GenericMessage<>(new User("cengizhanozcan"));
//    }

    @StreamListener(UserProcessor.USER_CREATE_INPUT)
    public void userCreateConsumer(User user) {
        System.out.println("UserConsumer.userCreateConsumer: " + user.getUsername());
        userService.saveOrUpdate(user);
    }

    @StreamListener(UserProcessor.USER_UPDATE_INPUT)
    public void userUpdateConsumer(User user){
        System.out.println("UserConsumer.userUpdateConsumer: " + user.getUsername());
        userService.saveOrUpdate(user);
    }
}
