package com.cinema.api;

import com.cinema.controller.model.GenreModel;
import com.cinema.dto.GenreDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Genre management API")
@RequestMapping("/api/v1/genres")
public interface GenreApi {
    @ApiOperation("Get genre from database")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    GenreModel getGenre(@PathVariable Long id);

    @ApiOperation("Create new genre")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    GenreModel createGenre(@Valid @RequestBody GenreDto genreDto);

    @ApiOperation("Update genre in database")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    GenreModel updateGenre(@PathVariable Long id, @Valid @RequestBody GenreDto genreDto);

    @ApiOperation("Delete genre from database")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteGenre(@PathVariable Long id);
}
