package com.cinema.service.impl;

import com.cinema.dto.GenreDto;
import com.cinema.model.Genre;
import com.cinema.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements com.cinema.service.GenreService {

    private final GenreRepository genreRepository;

    @Override
    public GenreDto getGenre(Long id) {
        Genre genre = genreRepository.getGenre(id);
        return mapGenreToGenreDto(genre);
    }

    @Override
    public GenreDto createGenre(GenreDto genreDto) {
        Genre genre = mapGenreDtoToGenre(genreDto);
        genreRepository.createGenre(genre);
        return genreDto;
    }

    @Override
    public GenreDto updateGenre(Long id, GenreDto genreDto) {
        Genre genre = mapGenreDtoToGenre(genreDto);
        genreRepository.updateGenre(id, genre);
        return genreDto;
    }
    @Override
    public void deleteGenre(Long id) {
        genreRepository.deleteGenre(id);
    }

    private GenreDto mapGenreToGenreDto(Genre genre) {
        return GenreDto.builder()
                .id(genre.getId())
                .genre(genre.getGenre())
                .build();
    }

    private Genre mapGenreDtoToGenre(GenreDto genreDto) {
        return Genre.builder()
                .genre(genreDto.getGenre())
                .build();
    }

}
