package com.concretepage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.entity.Movie;
import com.concretepage.repository.MovieRepository;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public Movie getMovieById(long movieId) {
        Movie obj = movieRepository.findByMovieId(movieId);
        return obj;
    }
    @Override
    public List<Movie> getAllMovies(){
        List<Movie> list = new ArrayList<>();
        movieRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
    @Override
    public synchronized boolean addMovie(Movie movie){
        List<Movie> list = movieRepository.findByTitleAndDateProduction(movie.getTitle(), movie.getdateProduction());
        if (list.size() > 0) {
            return false;
        } else {
            movie = movieRepository.save(movie);
            return true;
        }
    }
    @Override
    public void updateMovie(Movie movie) {
        movieRepository.save(movie);
    }
    @Override
    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
    }
}
