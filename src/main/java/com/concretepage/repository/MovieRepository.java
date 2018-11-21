package com.concretepage.repository;

import java.util.List;

import com.concretepage.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>  {
    Movie findByMovieId(long movieId);
    List<Movie> findByTitleAndDateProduction(String title, String dateProduction);
}
