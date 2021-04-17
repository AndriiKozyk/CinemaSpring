package com.cinema.controller;

import com.cinema.dto.MovieSessionGeneralDto;
import com.cinema.dto.MovieSessionPlaceDto;
import com.cinema.service.MovieSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessions")
@RequiredArgsConstructor
public class MovieSessionController {

    private final MovieSessionService sessionService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public MovieSessionGeneralDto getMovieSessionGeneral(@PathVariable Long id) {
        return sessionService.getMovieSessionGeneral(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public MovieSessionPlaceDto getMovieSessionPlace(@PathVariable Long id) {
        return sessionService.getMovieSessionPlace(id);
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
    @PatchMapping("/{id}")
    public MovieSessionPlaceDto updateMovieSessionPlace(@PathVariable Long id,
                                                        @RequestBody MovieSessionPlaceDto sessionPlaceDto) {
        return sessionService.updateMovieSessionPlace(id, sessionPlaceDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieSession(@PathVariable Long id) {
        sessionService.deleteMovieSession(id);
        return ResponseEntity.noContent().build();
    }

}
