package com.cinema.controller;

import com.cinema.dto.MovieDto;
import com.cinema.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public MovieDto getMovie(@PathVariable int id) {
        return movieService.getMovie(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MovieDto createMovie(@RequestBody MovieDto movieDto) {
        return movieService.createMovie(movieDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public MovieDto updateMovie(@PathVariable int id, @RequestBody MovieDto movieDto) {
        return movieService.updateMovie(id, movieDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id) {
        movieService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
