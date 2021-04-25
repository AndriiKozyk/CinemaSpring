package com.cinema.api;

import com.cinema.controller.model.MovieModel;
import com.cinema.dto.MovieDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Movie management API")
@RequestMapping("/api/v1/movies")
public interface MovieApi {
    @ApiOperation("Get movie from database")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    MovieModel getMovie(@PathVariable int id);

    @ApiOperation("Create new movie")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    MovieModel createMovie(@Valid @RequestBody MovieDto movieDto);

    @ApiOperation("Update movie in database")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    MovieModel updateMovie(@PathVariable int id, @Valid @RequestBody MovieDto movieDto);

    @ApiOperation("Delete movie from database")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMovie(@PathVariable int id);
}
