package com.cinema.controller;

import com.cinema.controller.assembler.GenreAssembler;
import com.cinema.controller.model.GenreModel;
import com.cinema.dto.GenreDto;
import com.cinema.service.GenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;
    private final GenreAssembler genreAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public GenreModel getGenre(@PathVariable Long id) {
        log.info("Get genre by id: {}", id);
        GenreDto genre = genreService.getGenre(id);
        return genreAssembler.toModel(genre);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public GenreModel createGenre(@Valid @RequestBody GenreDto genreDto) {
        log.info("Create genre {}", genreDto);
        GenreDto genre = genreService.createGenre(genreDto);
        return genreAssembler.toModel(genre);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public GenreModel updateGenre(@PathVariable Long id, @Valid @RequestBody GenreDto genreDto) {
        log.info("Update genre by id: {}", id);
        GenreDto genre = genreService.updateGenre(id, genreDto);
        return genreAssembler.toModel(genre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        log.info("Delete genre by id: {}", id);
        return ResponseEntity.noContent().build();
    }

}
