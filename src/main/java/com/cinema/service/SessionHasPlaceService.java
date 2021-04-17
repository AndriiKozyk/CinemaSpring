package com.cinema.service;

import com.cinema.dto.SessionHasPlaceDto;

public interface SessionHasPlaceService {
    SessionHasPlaceDto getSessionHasPlace(int id);

    SessionHasPlaceDto createSessionHasPlace(SessionHasPlaceDto sessionHasPlaceDto);

    SessionHasPlaceDto updateSessionHasPlace(int id, SessionHasPlaceDto sessionHasPlaceDto);

    void deleteSessionHasPlace(int id);
}
