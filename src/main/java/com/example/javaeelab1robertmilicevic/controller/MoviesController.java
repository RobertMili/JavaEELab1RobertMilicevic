package com.example.javaeelab1robertmilicevic.controller;

import com.example.javaeelab1robertmilicevic.dto.MovieDto;
import com.example.javaeelab1robertmilicevic.entity.Movie;
import com.example.javaeelab1robertmilicevic.exception.IdNotFoundException;
import com.example.javaeelab1robertmilicevic.mapper.Mapper;
import com.example.javaeelab1robertmilicevic.repository.MovieRepository;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
public class MoviesController {

    @Inject
    MovieRepository repository;
    @Inject
    Mapper mapper;

    @GET
    public List<MovieDto> getAll(@QueryParam("name") String name) {
        if (name == null)
            return mapper.map(repository.findAll());

        return mapper.map(repository.findAllByName(name));
    }

    @GET
    @Path("/{id}")
    public Response getOne(@PathParam("id") Long id) {
        var movie = repository.findOne(id);
        if (movie.isPresent())
            return Response.ok().entity(movie.get()).build();
        throw new IdNotFoundException("Not found ID: " + id);
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


    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update (@PathParam("id") Long id, MovieDto movie) {
        return Response.ok().entity(mapper.map(repository.update(id, mapper.map(movie)))).build();
    }
}
