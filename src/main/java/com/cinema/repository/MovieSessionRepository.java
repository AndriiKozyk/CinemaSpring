package com.cinema.repository;

import com.cinema.model.MovieSession;

public interface MovieSessionRepository {
    MovieSession getMovieSession(Long id);

    MovieSession createMovieSession(MovieSession movieSession);

    MovieSession updateMovieSession(Long id, MovieSession movieSession);

    MovieSession updateMovieSessionStatus(Long id, MovieSession movieSession);

    MovieSession updateMovieSessionPlace(Long id, MovieSession movieSession);

    void deleteSession(Long id);
}
