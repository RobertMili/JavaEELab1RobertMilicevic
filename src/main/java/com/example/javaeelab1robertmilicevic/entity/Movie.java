package com.example.javaeelab1robertmilicevic.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "name cant be null")
    @Size(min = 2, max = 10000)
    String name;

    @JsonbTransient
    String secretMovie = "This shouldn't be visible";
    BigDecimal price;

    public String getSecretMovie() {
        return secretMovie;
    }

    public void setSecretMovie(String secretMovie) {
        this.secretMovie = secretMovie;
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

    public Movie setName(String name) {
        this.name = name;
        return null;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secretMovie='" + secretMovie + '\'' +
                ", price=" + price +
                '}';
    }
    public Movie(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Movie() {
    }

}
