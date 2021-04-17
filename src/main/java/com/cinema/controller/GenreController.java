package com.cinema.controller;

import com.cinema.dto.GenreDto;
import com.cinema.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public GenreDto getGenre(@PathVariable Long id) {
        return genreService.getGenre(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public GenreDto createGenre(@RequestBody GenreDto genreDto) {
        return genreService.createGenre(genreDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public GenreDto updateGenre(@PathVariable Long id, @RequestBody GenreDto genreDto) {
        return genreService.updateGenre(id, genreDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }

}
