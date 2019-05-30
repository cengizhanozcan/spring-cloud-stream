package com.ceng.springcloud.movieservice.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface UserProcessor {

    String USER_CREATE_INPUT = "user_create_input";
    String USER_CREATE_OUTPUT = "user_create_output";
    String USER_UPDATE_INPUT = "user_update_input";
    String USER_UPDATE_OUTPUT = "user_update_output";

    
    @Input(USER_CREATE_INPUT)
    SubscribableChannel userCreateInput();

    @Output(USER_CREATE_OUTPUT)
    MessageChannel userCreateOutput();

    @Input(USER_UPDATE_INPUT)
    SubscribableChannel userUpdateInput();

    @Output(USER_UPDATE_OUTPUT)
    MessageChannel userUpdateOutput();

}
