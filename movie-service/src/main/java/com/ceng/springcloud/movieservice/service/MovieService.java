package com.ceng.springcloud.movieservice.service;

import com.ceng.springcloud.movieservice.model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    @Transactional
    public void saveOrUpdate(Movie movie) {
    }

}
