package com.cinema.controller;

import com.cinema.api.MovieApi;
import com.cinema.controller.assembler.MovieAssembler;
import com.cinema.controller.model.MovieModel;
import com.cinema.dto.MovieDto;
import com.cinema.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MovieController implements MovieApi {

    private final MovieService movieService;
    private final MovieAssembler movieAssembler;

    @Override
    public MovieModel getMovie(int id) {
        log.info("Get movie by id: {}", id);
        MovieDto movie = movieService.getMovie(id);
        return movieAssembler.toModel(movie);
    }

    @Override
    public MovieModel createMovie(MovieDto movieDto) {
        log.info("Create movie {}", movieDto);
        MovieDto movie = movieService.createMovie(movieDto);
        return movieAssembler.toModel(movie);
    }

    @Override
    public MovieModel updateMovie(int id, MovieDto movieDto) {
        log.info("Update movie by id: {}", id);
        MovieDto movie = movieService.updateMovie(id, movieDto);
        return movieAssembler.toModel(movie);
    }

    @Override
    public ResponseEntity<Void> deleteMovie(int id) {
        movieService.deleteUser(id);
        log.info("Delete movie by id: {}", id);
        return ResponseEntity.noContent().build();
    }

}
