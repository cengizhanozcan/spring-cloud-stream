package com.ceng.tutorial.springcloud.dispatcher.controller;

import com.ceng.springcloud.movieservice.model.Movie;
import com.ceng.springcloud.movieservice.processor.MovieProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movie")
@EnableBinding(MovieProcessor.class)
public class MovieController extends BaseController {

    @Autowired
    private MovieProcessor movieProcessor;

    @PostMapping(value = "/")
    public boolean createMovie(@RequestBody Movie movie) {
        movieProcessor.movieCreateOutput().send(message(movie));

        return true;
    }

    @PutMapping(value = "/")
    public boolean updateMovie(@RequestBody Movie movie) {
        movieProcessor.movieUpdateOutput().send(message(movie));

        return true;
    }

}
