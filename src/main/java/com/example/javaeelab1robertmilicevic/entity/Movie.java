package com.example.javaeelab1robertmilicevic.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "name cant be null")
    @Size(min = 2,max = 10000)
    String name;

    @JsonbTransient
    String secretMovie = "This shouldn't be visible";

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

    public void setName(String name) {
        this.name = name;
    }
}
