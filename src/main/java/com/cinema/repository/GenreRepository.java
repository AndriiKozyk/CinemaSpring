package com.cinema.repository;

import com.cinema.model.Genre;

public interface GenreRepository {
    Genre getGenre(Long id);

    Genre createGenre(Genre genre);

    Genre updateGenre(Long id, Genre genre);

    void deleteGenre(Long id);
}
