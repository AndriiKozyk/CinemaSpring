package com.cinema.controller;

import com.cinema.controller.assembler.SessionHasPlaceAssembler;
import com.cinema.controller.model.SessionHasPlaceModel;
import com.cinema.dto.SessionHasPlaceDto;
import com.cinema.service.SessionHasPlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/shps")
public class SessionHasPlaceController {

    private final SessionHasPlaceService sessionHasPlaceService;
    private final SessionHasPlaceAssembler sessionHasPlaceAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public SessionHasPlaceModel getSessionHasPlace(@PathVariable int id) {
        log.info("Get SessionPlace by id: {}", id);
        SessionHasPlaceDto sessionHasPlace = sessionHasPlaceService.getSessionHasPlace(id);
        return sessionHasPlaceAssembler.toModel(sessionHasPlace);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public SessionHasPlaceModel createSessionHasPlace(@RequestBody SessionHasPlaceDto sessionHasPlaceDto) {
        log.info("Create session place {}", sessionHasPlaceDto);
        SessionHasPlaceDto sessionHasPlace = sessionHasPlaceService.createSessionHasPlace(sessionHasPlaceDto);
        return sessionHasPlaceAssembler.toModel(sessionHasPlace);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public SessionHasPlaceModel updateSessionHasPlace(@PathVariable int id,
                                                    @RequestBody SessionHasPlaceDto sessionHasPlaceDto) {
        log.info("Update session place by id: {}", id);
        SessionHasPlaceDto sessionHasPlace = sessionHasPlaceService.updateSessionHasPlace(id, sessionHasPlaceDto);
        return sessionHasPlaceAssembler.toModel(sessionHasPlace);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSessionHasPlace(@PathVariable int id) {
        sessionHasPlaceService.deleteSessionHasPlace(id);
        log.info("Delete session place by id: {}", id);
        return ResponseEntity.noContent().build();
    }

}
