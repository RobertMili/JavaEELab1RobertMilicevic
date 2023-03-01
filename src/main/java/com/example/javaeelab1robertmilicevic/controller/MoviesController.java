package com.example.javaeelab1robertmilicevic.controller;

import com.example.javaeelab1robertmilicevic.entity.Movie;
import com.example.javaeelab1robertmilicevic.repository.MovieRepository;
import com.example.javaeelab1robertmilicevic.validate.MovieValidate;
import jakarta.enterprise.inject.build.compatible.spi.Validation;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/movies")
public class MoviesController {

    @Inject
    MovieRepository repository;

    @Inject
    MovieValidate validate;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getAll(@QueryParam("name") String name, @QueryParam("id") long id) {
        if (name == null)
            return repository.findAll();
        return repository.findAllByName(name);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOne(@PathParam("id") Long id) {
        var movie = repository.findOne(id);
        if (movie.isPresent())
            return Response.ok().entity(movie.get()).build();
        return Response.status(404).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOne(@Valid Movie movie) {

        repository.insertMovie(movie);
        return Response.created(URI.create("/movies/" + movie.getId())).build();
    }

    @DELETE
    @Path("/{id}")
    public void deleteOne(@PathParam("id") Long id) {
        repository.deleteMovies(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> filter(@QueryParam("name") String name) {
        return repository.findAll().stream().filter(e -> e.getName().equals(name)).toList();
    }
}
