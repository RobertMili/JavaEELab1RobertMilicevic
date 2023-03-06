package com.example.javaeelab1robertmilicevic.repository;

import com.example.javaeelab1robertmilicevic.entity.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieRepositoryTest {

    @InjectMocks
    private MovieRepository repository;
    @Mock
    private EntityManager entitymanager;
    @Mock
    private Query query;

    BigDecimal bigDecimal = new BigDecimal(1);
    Movie movie = new Movie("test", bigDecimal);
    Movie movie2 = new Movie("test2", bigDecimal);
    List<Movie> movieList = List.of(movie, movie2);



    @Test
    void findOneShouldReturnMovie() {
        when(entitymanager.find(Movie.class, 1L)).thenReturn(movie);

        var result = repository.findOne(1L);
        assertEquals(movie, result.get());
    }

    @Test
    void findAllShouldReturnListOfMovies() {
        when(query.getResultList()).thenReturn(movieList);
        when(entitymanager.createQuery("select m from Movie m")).thenReturn(query);

        var result = repository.findAll();
        assertEquals(movieList, result);
    }
}