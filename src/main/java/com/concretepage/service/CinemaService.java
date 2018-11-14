package com.concretepage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.entity.Cinema;
import com.concretepage.repository.CinemaRepository;
@Service
public class CinemaService implements ICinemaService {
	@Autowired
	private CinemaRepository cinemaRepository;
	@Override
	public Cinema getCinemaById(long cinemaId) {
		Cinema obj = cinemaRepository.findByCinemaId(cinemaId);
		return obj;
	}	
	@Override
	public List<Cinema> getAllCinemas(){
		List<Cinema> list = new ArrayList<>();
		cinemaRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
	@Override
	public synchronized boolean addCinema(Cinema cinema){
	   List<Cinema> list = cinemaRepository.findByTitleAndAdresse(cinema.getTitle(), cinema.getAdresse());
       if (list.size() > 0) {
    	   return false;
       } else {
    	   cinema = cinemaRepository.save(cinema);
    	   return true;
       }
	}
	@Override
	public void updateCinema(Cinema cinema) {
		cinemaRepository.save(cinema);
	}
	@Override
	public void deleteCinema(Cinema cinema) {
		cinemaRepository.delete(cinema);
	}
}
