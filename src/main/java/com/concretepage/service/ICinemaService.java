package com.concretepage.service;

import java.util.List;

import com.concretepage.entity.Cinema;

public interface ICinemaService {
     List<Cinema> getAllCinemas();
     Cinema getCinemaById(long cinemaId);
     boolean addCinema(Cinema cinema);
     void updateCinema(Cinema cinema);
     void deleteCinema(Cinema cinema);
}
