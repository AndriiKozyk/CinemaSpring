package com.cinema.repository;

import com.cinema.model.SessionHasPlace;

public interface SessionHasPlaceRepository {

    SessionHasPlace getSessionHasPlace(int id);

    SessionHasPlace createSessionHasPlace(SessionHasPlace sessionHasPlace);

    SessionHasPlace updateSessionHasPlace(int id, SessionHasPlace sessionHasPlace);

    void deleteSessionHasPlace(int id);

}
