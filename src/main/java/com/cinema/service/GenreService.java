package com.cinema.service;

import com.cinema.dto.GenreDto;

public interface GenreService {
    GenreDto getGenre(Long id);

    GenreDto createGenre(GenreDto genreDto);

    GenreDto updateGenre(Long id, GenreDto genreDto);

    void deleteGenre(Long id);
}
