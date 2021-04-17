package com.cinema.controller;

import com.cinema.dto.SessionHasPlaceDto;
import com.cinema.service.SessionHasPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shps")
public class SessionHasPlaceController {

    private final SessionHasPlaceService sessionHasPlaceService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public SessionHasPlaceDto getSessionHasPlace(@PathVariable int id) {
        return sessionHasPlaceService.getSessionHasPlace(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public SessionHasPlaceDto createSessionHasPlace(@RequestBody SessionHasPlaceDto sessionHasPlaceDto) {
        return sessionHasPlaceService.createSessionHasPlace(sessionHasPlaceDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public SessionHasPlaceDto updateSessionHasPlace(@PathVariable int id,
                                                    @RequestBody SessionHasPlaceDto sessionHasPlaceDto) {
        return sessionHasPlaceService.updateSessionHasPlace(id, sessionHasPlaceDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSessionHasPlace(@PathVariable int id) {
        sessionHasPlaceService.deleteSessionHasPlace(id);
        return ResponseEntity.noContent().build();
    }

}
