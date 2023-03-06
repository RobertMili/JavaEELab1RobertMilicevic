package com.example.javaeelab1robertmilicevic.mapper;

import com.example.javaeelab1robertmilicevic.dto.MovieDto;
import com.example.javaeelab1robertmilicevic.entity.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MapperTest {
    Mapper mapper = new Mapper();
    Movie movie = new Movie();
    @Test
    void mappingListOfMoviesReturnMovieDTO() {
        var movie = new Movie();
        var movie2 = new Movie();
        List<Movie> flowers = List.of(movie, movie2);

        var actualDtoList = mapper.map(flowers);
        var expected = List.of(mapper.map(movie), mapper.map(movie2));

        assertThat(actualDtoList).usingRecursiveComparison().isEqualTo(expected);

    }

    @Test
    public void testMapToDto() {

        movie.setId(1L);
        movie.setName("Test Movie");
        movie.setPrice(BigDecimal.valueOf(10.99));


        MovieDto movieDto = mapper.map(movie);

        Assertions.assertEquals(movie.getId(), movieDto.getId());
        Assertions.assertEquals(movie.getName(), movieDto.getName());
        Assertions.assertEquals(movie.getPrice(), movieDto.getPrice());
    }
    @Test
    public void testMapToListDto() {

        List<Movie> movies = new ArrayList<>();
        Movie movie1 = new Movie();
        movie1.setId(1L);
        movie1.setName("Test Movie 1");
        movie1.setPrice(BigDecimal.valueOf(10.99));
        movies.add(movie1);

        Movie movie2 = new Movie();
        movie2.setId(2L);
        movie2.setName("Test Movie 2");
        movie2.setPrice(BigDecimal.valueOf(20.99));
        movies.add(movie2);


        Mapper mapper = new Mapper();
        List<MovieDto> movieDtos = mapper.map(movies);


        Assertions.assertEquals(movies.size(), movieDtos.size());


        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            MovieDto movieDto = movieDtos.get(i);
            Assertions.assertEquals(movie.getId(), movieDto.getId());
            Assertions.assertEquals(movie.getName(), movieDto.getName());
            Assertions.assertEquals(movie.getPrice(), movieDto.getPrice());
        }
    }
}