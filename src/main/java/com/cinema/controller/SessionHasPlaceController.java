package com.cinema.controller;

import com.cinema.api.SessionHasPlaceApi;
import com.cinema.controller.assembler.SessionHasPlaceAssembler;
import com.cinema.controller.model.SessionHasPlaceModel;
import com.cinema.dto.SessionHasPlaceDto;
import com.cinema.service.SessionHasPlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SessionHasPlaceController implements SessionHasPlaceApi {

    private final SessionHasPlaceService sessionHasPlaceService;
    private final SessionHasPlaceAssembler sessionHasPlaceAssembler;

    @Override
    public SessionHasPlaceModel getSessionHasPlace(int id) {
        log.info("Get SessionPlace by id: {}", id);
        SessionHasPlaceDto sessionHasPlace = sessionHasPlaceService.getSessionHasPlace(id);
        return sessionHasPlaceAssembler.toModel(sessionHasPlace);
    }

    @Override
    public SessionHasPlaceModel createSessionHasPlace(SessionHasPlaceDto sessionHasPlaceDto) {
        log.info("Create session place {}", sessionHasPlaceDto);
        SessionHasPlaceDto sessionHasPlace = sessionHasPlaceService.createSessionHasPlace(sessionHasPlaceDto);
        return sessionHasPlaceAssembler.toModel(sessionHasPlace);
    }

    @Override
    public SessionHasPlaceModel updateSessionHasPlace(int id, SessionHasPlaceDto sessionHasPlaceDto) {
        log.info("Update session place by id: {}", id);
        SessionHasPlaceDto sessionHasPlace = sessionHasPlaceService.updateSessionHasPlace(id, sessionHasPlaceDto);
        return sessionHasPlaceAssembler.toModel(sessionHasPlace);
    }

    @Override
    public ResponseEntity<Void> deleteSessionHasPlace(int id) {
        sessionHasPlaceService.deleteSessionHasPlace(id);
        log.info("Delete session place by id: {}", id);
        return ResponseEntity.noContent().build();
    }

}
