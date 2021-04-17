package com.cinema.repository.impl;

import com.cinema.model.Genre;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenreRepositoryImpl implements com.cinema.repository.GenreRepository {

    private final List<Genre> list = new ArrayList<>();

    @Override
    public Genre getGenre(Long id) {
        return list.stream()
                .filter(genre -> genre.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Genre createGenre(Genre genre) {
        list.add(genre);
        return genre;
    }

    @Override
    public Genre updateGenre(Long id, Genre genre) {
        boolean isDeleted = list.removeIf(g -> g.getId().equals(id));
        if (isDeleted) {
            list.add(genre);
        } else {
            throw new RuntimeException("Genre with id " + id + " does not exist");
        }
        return genre;
    }

    @Override
    public void deleteGenre(Long id) {
        list.removeIf(genre -> genre.getId().equals(id));
    }

}
