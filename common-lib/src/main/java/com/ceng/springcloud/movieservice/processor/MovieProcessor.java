package com.ceng.springcloud.movieservice.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MovieProcessor {

    String MOVIE_CREATE_INPUT = "movie_create_input";
    String MOVIE_CREATE_OUTPUT = "movie_create_output";
    String MOVIE_UPDATE_INPUT = "movie_update_input";
    String MOVIE_UPDATE_OUTPUT = "movie_update_output";

    
    @Input(MOVIE_CREATE_INPUT)
    SubscribableChannel movieCreateInput();

    @Output(MOVIE_CREATE_OUTPUT)
    MessageChannel movieCreateOutput();

    @Input(MOVIE_UPDATE_INPUT)
    SubscribableChannel movieUpdateInput();

    @Output(MOVIE_UPDATE_OUTPUT)
    MessageChannel movieUpdateOutput();

}
