package com.ceng.tutorial.springcloud.userservice.service;

import com.ceng.springcloud.movieservice.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Transactional
    public void saveOrUpdate(User user) {
    }

}
