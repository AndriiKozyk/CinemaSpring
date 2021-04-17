package com.cinema.service;

import com.cinema.dto.MovieDto;

public interface MovieService {

    MovieDto getMovie(int id);

    MovieDto createMovie(MovieDto movieDto);

    MovieDto updateMovie(int id, MovieDto movieDto);

    void deleteUser(int id);

}
