package com.cinema.repository;

import com.cinema.model.Movie;

public interface MovieRepository {

    Movie getMovie(int id);

    Movie createMovie(Movie movie);

    Movie updateMovie(int id, Movie movie);

    void deleteMovie(int id);

}
