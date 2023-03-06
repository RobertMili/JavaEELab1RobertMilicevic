package com.example.javaeelab1robertmilicevic.dto;

import com.example.javaeelab1robertmilicevic.entity.Movie;

import java.math.BigDecimal;

public class MovieDto {
    private Long id;
    private String name;
    BigDecimal price;

    public MovieDto(){

    }
    public MovieDto(Movie movie) {
        this.id = movie.getId();
        this.name = movie.getName();
        this.price = movie.getPrice();

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
