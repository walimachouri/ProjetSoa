package com.concretepage.service;

import java.util.List;

import com.concretepage.entity.Movie;

public interface IMovieService {
    List<Movie> getAllMovies();
    Movie getMovieById(long movieId);
    boolean addMovie(Movie movie);
    void updateMovie(Movie movie);
    void deleteMovie(Movie movie);
}
