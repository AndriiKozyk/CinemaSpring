package com.cinema.service.impl;

import com.cinema.dto.SessionHasPlaceDto;
import com.cinema.model.SessionHasPlace;
import com.cinema.repository.SessionHasPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionHasPlaceServiceImpl implements com.cinema.service.SessionHasPlaceService {
    
    private final SessionHasPlaceRepository sessionHasPlaceRepository;
    
    @Override
    public SessionHasPlaceDto getSessionHasPlace(int id) {
        SessionHasPlace sessionHasPlace = sessionHasPlaceRepository.getSessionHasPlace(id);
        return mapShpToShpDto(sessionHasPlace);
    }
    
    @Override
    public SessionHasPlaceDto createSessionHasPlace(SessionHasPlaceDto sessionHasPlaceDto) {
        SessionHasPlace sessionHasPlace = mapShpDtoToShp(sessionHasPlaceDto);
        sessionHasPlace = sessionHasPlaceRepository.createSessionHasPlace(sessionHasPlace);
        return mapShpToShpDto(sessionHasPlace);
    }

    @Override
    public SessionHasPlaceDto updateSessionHasPlace(int id, SessionHasPlaceDto sessionHasPlaceDto) {
        SessionHasPlace sessionHasPlace = mapShpDtoToShp(sessionHasPlaceDto);
        sessionHasPlace = sessionHasPlaceRepository.updateSessionHasPlace(id, sessionHasPlace);
        return mapShpToShpDto(sessionHasPlace);
    }

    @Override
    public void deleteSessionHasPlace(int id) {
        sessionHasPlaceRepository.deleteSessionHasPlace(id);
    }

    private SessionHasPlaceDto mapShpToShpDto(SessionHasPlace sessionHasPlace) {
        return SessionHasPlaceDto.builder()
                .id(sessionHasPlace.getId())
                .placeId(sessionHasPlace.getPlaceId())
                .available(sessionHasPlace.isAvailable())
                .build();
    }

    private SessionHasPlace mapShpDtoToShp(SessionHasPlaceDto sessionHasPlaceDto) {
        return SessionHasPlace.builder()
                .placeId(sessionHasPlaceDto.getPlaceId())
                .available(sessionHasPlaceDto.isAvailable())
                .build();
    }

}
