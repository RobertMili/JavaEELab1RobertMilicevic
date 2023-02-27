package com.example.javaeelab1robertmilicevic.validate;

import com.example.javaeelab1robertmilicevic.entity.Movie;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MovieValidate {
    public boolean validate(Movie movie) {
        return true;
    }
}
