package com.cinema.controller;

import com.cinema.api.GenreApi;
import com.cinema.controller.assembler.GenreAssembler;
import com.cinema.controller.model.GenreModel;
import com.cinema.dto.GenreDto;
import com.cinema.service.GenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GenreController implements GenreApi {

    private final GenreService genreService;
    private final GenreAssembler genreAssembler;

    @Override
    public GenreModel getGenre(Long id) {
        log.info("Get genre by id: {}", id);
        GenreDto genre = genreService.getGenre(id);
        return genreAssembler.toModel(genre);
    }

    @Override
    public GenreModel createGenre(GenreDto genreDto) {
        log.info("Create genre {}", genreDto);
        GenreDto genre = genreService.createGenre(genreDto);
        return genreAssembler.toModel(genre);
    }

    @Override
    public GenreModel updateGenre(Long id, GenreDto genreDto) {
        log.info("Update genre by id: {}", id);
        GenreDto genre = genreService.updateGenre(id, genreDto);
        return genreAssembler.toModel(genre);
    }

    @Override
    public ResponseEntity<Void> deleteGenre(Long id) {
        genreService.deleteGenre(id);
        log.info("Delete genre by id: {}", id);
        return ResponseEntity.noContent().build();
    }

}
