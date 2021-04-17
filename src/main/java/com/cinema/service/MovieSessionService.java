package com.cinema.service;

import com.cinema.dto.MovieSessionGeneralDto;
import com.cinema.dto.MovieSessionPlaceDto;

public interface MovieSessionService {
    MovieSessionGeneralDto getMovieSessionGeneral(Long id);

    MovieSessionPlaceDto getMovieSessionPlace(Long id);

    MovieSessionGeneralDto createMovieSession(MovieSessionGeneralDto sessionGeneralDto);

    MovieSessionGeneralDto updateMovieSessionGeneral(Long id, MovieSessionGeneralDto sessionGeneralDto);

    MovieSessionPlaceDto updateMovieSessionPlace(Long id, MovieSessionPlaceDto sessionPlaceDto);

    void deleteMovieSession(Long id);
}
