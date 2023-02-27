package com.example.javaeelab1robertmilicevic.controller;

import com.example.javaeelab1robertmilicevic.entity.Movie;
import com.example.javaeelab1robertmilicevic.repository.MovieRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/foods")
public class MoviesController {

    @Inject
    MovieRepository repository;

    @GET
    public Response getAllFoods(){
        return Response.ok().entity("Hello World").header("CustomHeader","MyValue").build();
    }
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Movie>filter(@QueryParam("name") String name, @QueryParam("id") long id) {
//        if (name == null)
//            return repository.findAll();
//
//        return repository.findAllByName(name);
//    }
}
