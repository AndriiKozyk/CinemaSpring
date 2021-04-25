package com.cinema.controller;

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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public GenreDto getGenre(@PathVariable Long id) {
        log.info("Get genre by id: {}", id);
        return genreService.getGenre(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public GenreDto createGenre(@Valid @RequestBody GenreDto genreDto) {
        log.info("Create genre {}", genreDto);
        return genreService.createGenre(genreDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public GenreDto updateGenre(@PathVariable Long id, @Valid @RequestBody GenreDto genreDto) {
        log.info("Update genre by id: {}", id);
        return genreService.updateGenre(id, genreDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        log.info("Delete genre by id: {}", id);
        return ResponseEntity.noContent().build();
    }

}
