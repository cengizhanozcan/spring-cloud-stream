package com.ceng.springcloud.movieservice.consumer;

import com.ceng.springcloud.movieservice.model.Movie;
import com.ceng.springcloud.movieservice.processor.MovieProcessor;
import com.ceng.springcloud.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@EnableBinding(MovieProcessor.class)
@Service
public class MovieConsumer {

    @Autowired
    private MovieService movieService;

    @StreamListener(MovieProcessor.MOVIE_CREATE_INPUT)
    public void movieCreateConsumer(Movie movie) {
        System.out.println("MovieConsumer.movieCreateConsumer: " + movie.getName());
        movieService.saveOrUpdate(movie);
    }

    @StreamListener(MovieProcessor.MOVIE_UPDATE_INPUT)
    public void movieUpdateConsumer(Movie movie) {
        System.out.println("MovieConsumer.movieUpdateConsumer: " + movie.getName());
        movieService.saveOrUpdate(movie);
    }
}
