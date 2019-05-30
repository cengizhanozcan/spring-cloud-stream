package com.ceng.tutorial.springcloud.dispatcher.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class BaseController {

    protected static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }
}
