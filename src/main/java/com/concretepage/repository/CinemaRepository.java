package com.concretepage.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.concretepage.entity.Cinema;

public interface CinemaRepository extends CrudRepository<Cinema, Long>  {
	Cinema findByCinemaId(long cinemaId);
    List<Cinema> findByTitleAndAdresse(String title, String adresse);
}
