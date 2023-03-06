package com.example.javaeelab1robertmilicevic.repository;


import com.example.javaeelab1robertmilicevic.entity.Movie;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class MovieRepository {

    @PersistenceContext
    EntityManager entityManager;



    public List<Movie> findAll() {
        var query = entityManager.createQuery("select m from Movie m");
        return query.getResultList();
    }
    public Optional<Movie> findOne(Long id){
        return Optional.ofNullable(entityManager.find(Movie.class, id));
    }
    public void insertMovie(Movie movie){
        entityManager.persist(movie);
    }

    public void deleteMovies(Long id) {
        var movie = findOne(id);
        movie.ifPresent((m) -> entityManager.remove(m));
    }
    public Movie update (Long id, Movie movie) {
        var entity = entityManager.find(Movie.class, id);
        entity.setName(movie.getName());
        entity.setPrice(movie.getPrice());
        entityManager.persist(entity);
        return entity;
    }
    public List<Movie> findAllByName(String name) {
        var query = entityManager.createQuery("select m from Movie m where m.name like :name");
        query.setParameter("name",name);
        return (List<Movie>) query.getResultList();
    }

}
