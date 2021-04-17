package com.cinema.repository.impl;

import com.cinema.model.SessionHasPlace;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SessionHasPlaceRepositoryImpl implements com.cinema.repository.SessionHasPlaceRepository {

    private final List<SessionHasPlace> list = new ArrayList<>();

    @Override
    public SessionHasPlace getSessionHasPlace(int id) {
        return list.stream()
                .filter(sessionHasPlace -> sessionHasPlace.getId() == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public SessionHasPlace createSessionHasPlace(SessionHasPlace sessionHasPlace) {
        list.add(sessionHasPlace);
        return sessionHasPlace;
    }

    @Override
    public SessionHasPlace updateSessionHasPlace(int id, SessionHasPlace sessionHasPlace) {
        boolean isDeleted = list.removeIf(shp -> shp.getId() == id);
        if (isDeleted) {
            list.add(sessionHasPlace);
        } else {
            throw new RuntimeException("Place with id " + id + "in this session does not exist");
        }
        return sessionHasPlace;
    }

    @Override
    public void deleteSessionHasPlace(int id) {
        list.removeIf(sessionHasPlace -> sessionHasPlace.getId() == id);
    }

}
