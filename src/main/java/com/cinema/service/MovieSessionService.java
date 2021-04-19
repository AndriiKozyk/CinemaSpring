package com.cinema.service;

import com.cinema.dto.MovieSessionGeneralDto;
import com.cinema.dto.MovieSessionPlaceDto;
import com.cinema.dto.MovieSessionStatusDto;

public interface MovieSessionService {
    MovieSessionGeneralDto getMovieSessionGeneral(Long id);

    MovieSessionPlaceDto getMovieSessionPlace(Long id);

    MovieSessionGeneralDto createMovieSession(MovieSessionGeneralDto sessionGeneralDto);

    MovieSessionGeneralDto updateMovieSessionGeneral(Long id, MovieSessionGeneralDto sessionGeneralDto);

    MovieSessionStatusDto updateMovieSessionStatus(Long id, MovieSessionStatusDto sessionStatusDto);

    MovieSessionPlaceDto updateMovieSessionPlace(Long id, MovieSessionPlaceDto sessionPlaceDto);

    void deleteMovieSession(Long id);
}
