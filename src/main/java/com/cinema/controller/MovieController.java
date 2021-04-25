package com.cinema.controller;

import com.cinema.dto.MovieDto;
import com.cinema.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public MovieDto getMovie(@PathVariable int id) {
        log.info("Get movie by id: {}", id);
        return movieService.getMovie(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MovieDto createMovie(@Valid @RequestBody MovieDto movieDto) {
        log.info("Create movie {}", movieDto);
        return movieService.createMovie(movieDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public MovieDto updateMovie(@PathVariable int id, @Valid @RequestBody MovieDto movieDto) {
        log.info("Update movie by id: {}", id);
        return movieService.updateMovie(id, movieDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id) {
        movieService.deleteUser(id);
        log.info("Delete movie by id: {}", id);
        return ResponseEntity.noContent().build();
    }

}
