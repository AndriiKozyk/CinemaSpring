package com.cinema.service.impl;

import com.cinema.dto.MovieSessionGeneralDto;
import com.cinema.dto.MovieSessionPlaceDto;
import com.cinema.model.MovieSession;
import com.cinema.repository.MovieSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieSessionServiceImpl implements com.cinema.service.MovieSessionService {

    private final MovieSessionRepository sessionRepository;

    @Override
    public MovieSessionGeneralDto getMovieSessionGeneral(Long id) {
        MovieSession session = sessionRepository.getMovieSession(id);
        return mapSessionToSessionGeneralDto(session);
    }

    @Override
    public MovieSessionPlaceDto getMovieSessionPlace(Long id) {
        MovieSession session = sessionRepository.getMovieSession(id);
        return mapSessionToSessionPlaceDto(session);
    }

    @Override
    public MovieSessionGeneralDto createMovieSession(MovieSessionGeneralDto sessionGeneralDto) {
        MovieSession session = mapSessionGeneralDtoToSession(sessionGeneralDto);
        sessionRepository.createMovieSession(session);
        return sessionGeneralDto;
    }

    @Override
    public MovieSessionGeneralDto updateMovieSessionGeneral(Long id, MovieSessionGeneralDto sessionGeneralDto) {
        MovieSession session = mapSessionGeneralDtoToSession(sessionGeneralDto);
        sessionRepository.updateMovieSession(id, session);
        return sessionGeneralDto;
    }

    @Override
    public MovieSessionPlaceDto updateMovieSessionPlace(Long id, MovieSessionPlaceDto sessionPlaceDto) {
        MovieSession session = mapSessionPlaceDtoToSession(sessionPlaceDto);
        sessionRepository.updateMovieSessionPlace(id, session);
        return sessionPlaceDto;
    }

    @Override
    public void deleteMovieSession(Long id) {
        sessionRepository.deleteSession(id);
    }

    private MovieSession mapSessionPlaceDtoToSession(MovieSessionPlaceDto sessionPlaceDto) {
        return MovieSession.builder()
                .places(sessionPlaceDto.getPlaces())
                .build();
    }

    private MovieSession mapSessionGeneralDtoToSession(MovieSessionGeneralDto sessionGeneralDto) {
        return MovieSession.builder()
                .dateTime(sessionGeneralDto.getDateTime())
                .movieId(sessionGeneralDto.getMovieId())
                .price(sessionGeneralDto.getPrice())
                .build();
    }

    private MovieSessionPlaceDto mapSessionToSessionPlaceDto(MovieSession session) {
        return MovieSessionPlaceDto.builder()
                .id(session.getId())
                .places(session.getPlaces())
                .build();
    }

    private MovieSessionGeneralDto mapSessionToSessionGeneralDto(MovieSession session) {
        return MovieSessionGeneralDto.builder()
                .id(session.getId())
                .dateTime(session.getDateTime())
                .movieId(session.getMovieId())
                .price(session.getPrice())
                .status(session.getStatus())
                .build();
    }

}
