package com.cinema.service.impl;

import com.cinema.dto.MovieDto;
import com.cinema.model.Movie;
import com.cinema.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements com.cinema.service.MovieService {

    private final MovieRepository movieRepository;

    @Override
    public MovieDto getMovie(int id) {
        Movie movie = movieRepository.getMovie(id);
        return mapMovieToMovieDto(movie);
    }

    @Override
    public MovieDto createMovie(MovieDto movieDto) {
        Movie movie = mapMovieDtoToMovie(movieDto);
        movie = movieRepository.createMovie(movie);
        return mapMovieToMovieDto(movie);
    }

    @Override
    public MovieDto updateMovie(int id, MovieDto movieDto) {
        Movie movie = mapMovieDtoToMovie(movieDto);
        movie = movieRepository.updateMovie(id, movie);
        return mapMovieToMovieDto(movie);
    }

    @Override
    public void deleteUser(int id) {
        movieRepository.deleteMovie(id);
    }

    private MovieDto mapMovieToMovieDto(Movie movie) {
        return MovieDto.builder()
                .id(movie.getId())
                .name(movie.getName())
                .duration(movie.getDuration())
                .price(movie.getPrice())
                .genre(movie.getGenre())
                .build();
    }

    private Movie mapMovieDtoToMovie(MovieDto movieDto) {
        return Movie.builder()
                .name(movieDto.getName())
                .duration(movieDto.getDuration())
                .price(movieDto.getPrice())
                .genre(movieDto.getGenre())
                .build();
    }

}
