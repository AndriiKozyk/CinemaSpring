package com.cinema.controller;

import com.cinema.controller.assembler.MovieAssembler;
import com.cinema.controller.model.MovieModel;
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
    private final MovieAssembler movieAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public MovieModel getMovie(@PathVariable int id) {
        log.info("Get movie by id: {}", id);
        MovieDto movie = movieService.getMovie(id);
        return movieAssembler.toModel(movie);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MovieModel createMovie(@Valid @RequestBody MovieDto movieDto) {
        log.info("Create movie {}", movieDto);
        MovieDto movie = movieService.createMovie(movieDto);
        return movieAssembler.toModel(movie);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public MovieModel updateMovie(@PathVariable int id, @Valid @RequestBody MovieDto movieDto) {
        log.info("Update movie by id: {}", id);
        MovieDto movie = movieService.updateMovie(id, movieDto);
        return movieAssembler.toModel(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id) {
        movieService.deleteUser(id);
        log.info("Delete movie by id: {}", id);
        return ResponseEntity.noContent().build();
    }

}
