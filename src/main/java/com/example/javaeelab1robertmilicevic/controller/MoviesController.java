package com.example.javaeelab1robertmilicevic.controller;

import com.example.javaeelab1robertmilicevic.entity.Movie;
import com.example.javaeelab1robertmilicevic.repository.MovieRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/movies")
public class MoviesController {

    @Inject
    MovieRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getAll() {

        return repository.findAll();
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
    @Produces(MediaType.APPLICATION_JSON)
    public void addOne(Movie movie){

    }
}
