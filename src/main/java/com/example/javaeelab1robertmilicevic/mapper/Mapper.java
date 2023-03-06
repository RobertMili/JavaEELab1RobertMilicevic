package com.example.javaeelab1robertmilicevic.mapper;

import com.example.javaeelab1robertmilicevic.dto.MovieDto;
import com.example.javaeelab1robertmilicevic.entity.Movie;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Mapper {

    public List<MovieDto> map(List<Movie> all) {
       return all.stream().map(MovieDto::new).toList();
    }
    public Movie map(MovieDto movie) {
        var m = new Movie();
        m.setId(movie.getId());
        m.setName(movie.getName());
        m.setPrice(movie.getPrice());
        return m;
    }

    public MovieDto map(Movie movie) {
        return new MovieDto(movie);
    }
}
