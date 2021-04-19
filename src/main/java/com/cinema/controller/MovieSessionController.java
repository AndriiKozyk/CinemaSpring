package com.cinema.controller;

import com.cinema.dto.MovieSessionGeneralDto;
import com.cinema.dto.MovieSessionPlaceDto;
import com.cinema.dto.MovieSessionStatusDto;
import com.cinema.service.MovieSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sessions")
@RequiredArgsConstructor
public class MovieSessionController {

    private final MovieSessionService sessionService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public MovieSessionGeneralDto getMovieSessionGeneral(@PathVariable Long id) {
        return sessionService.getMovieSessionGeneral(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{idPlace}")
    public MovieSessionPlaceDto getMovieSessionPlace(@PathVariable Long idPlace) {
        return sessionService.getMovieSessionPlace(idPlace);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MovieSessionGeneralDto createMovieSession(@RequestBody MovieSessionGeneralDto sessionGeneralDto) {
        return sessionService.createMovieSession(sessionGeneralDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public MovieSessionGeneralDto updateMovieSessionGeneral(@PathVariable Long id,
                                                            @RequestBody MovieSessionGeneralDto sessionGeneralDto) {
        return sessionService.updateMovieSessionGeneral(id, sessionGeneralDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{idStatus}")
    public MovieSessionStatusDto updateMovieSessionStatus(@PathVariable Long idStatus,
                                                         @RequestBody MovieSessionStatusDto sessionStatusDto) {
        return sessionService.updateMovieSessionStatus(idStatus, sessionStatusDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{idPlace}")
    public MovieSessionPlaceDto updateMovieSessionPlace(@PathVariable Long idPlace,
                                                        @RequestBody MovieSessionPlaceDto sessionPlaceDto) {
        return sessionService.updateMovieSessionPlace(idPlace, sessionPlaceDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieSession(@PathVariable Long id) {
        sessionService.deleteMovieSession(id);
        return ResponseEntity.noContent().build();
    }

}
