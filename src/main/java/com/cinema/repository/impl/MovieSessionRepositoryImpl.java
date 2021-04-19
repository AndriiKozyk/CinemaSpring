package com.cinema.repository.impl;

import com.cinema.model.MovieSession;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class MovieSessionRepositoryImpl implements com.cinema.repository.MovieSessionRepository {

    private final List<MovieSession> list = new ArrayList<>();

    @Override
    public MovieSession getMovieSession(Long id) {
        return list.stream()
                .filter(movieSession -> movieSession.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public MovieSession createMovieSession(MovieSession movieSession) {
        list.add(movieSession);
        return movieSession;
    }

    @Override
    public MovieSession updateMovieSession(Long id, MovieSession movieSession) {
        boolean isDeleted = list.removeIf(session -> session.getId().equals(id));
        if (isDeleted) {
            list.add(movieSession);
        } else {
            throw new RuntimeException("Session with id " + id + " does not exist");
        }
        return movieSession;
    }

    @Override
    public MovieSession updateMovieSessionStatus(Long id, MovieSession movieSession) {
        MovieSession session = list.stream()
                .filter(mSession -> mSession.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
        session.setStatus(movieSession.getStatus());
        return movieSession;
    }

    @Override
    public MovieSession updateMovieSessionPlace(Long id, MovieSession movieSession) {
        MovieSession session = list.stream()
                .filter(mSession -> mSession.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
        session.setPlaces(movieSession.getPlaces());
        return movieSession;
    }

    @Override
    public void deleteSession(Long id) {
        list.removeIf(movieSession -> movieSession.getId().equals(id));
    }

}
