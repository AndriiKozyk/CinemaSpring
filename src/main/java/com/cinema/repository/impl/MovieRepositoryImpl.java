package com.cinema.repository.impl;

import com.cinema.model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieRepositoryImpl implements com.cinema.repository.MovieRepository {

    private final List<Movie> list = new ArrayList<>();

    @Override
    public Movie getMovie(int id) {
        return list.stream()
                .filter(movie -> movie.getId() == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Movie createMovie(Movie movie) {
        list.add(movie);
        return movie;
    }

    @Override
    public Movie updateMovie(int id, Movie movie) {
        boolean isDeleted = list.removeIf(m -> m.getId() == id);
        if (isDeleted) {
            list.add(movie);
        } else {
            throw new RuntimeException("Film does not exist with id + " + id);
        }
        return movie;
    }

    @Override
    public void deleteMovie(int id) {
        list.removeIf(movie -> movie.getId() == id);
    }

}
