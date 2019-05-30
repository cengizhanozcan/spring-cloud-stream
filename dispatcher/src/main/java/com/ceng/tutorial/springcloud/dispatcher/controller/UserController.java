package com.ceng.tutorial.springcloud.dispatcher.controller;

import com.ceng.springcloud.movieservice.model.User;
import com.ceng.springcloud.movieservice.processor.UserProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@EnableBinding(UserProcessor.class)
public class UserController extends BaseController {

    @Autowired
    private UserProcessor userProcessor;

    @PostMapping(value = "/")
    public boolean createUser(@RequestBody User user) {
        userProcessor.userCreateOutput().send(message(user));

        return true;
    }

    @PutMapping(value = "/")
    public boolean updateUser(@RequestBody User user) {
        userProcessor.userUpdateOutput().send(message(user));

        return true;
    }

}
