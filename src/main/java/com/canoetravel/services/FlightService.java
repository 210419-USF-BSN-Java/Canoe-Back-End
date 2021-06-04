package com.canoetravel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canoetravel.entities.Flight;
import com.canoetravel.repository.FlightRepository;

@Service
public class FlightService  {

	private FlightRepository flightRepo;

	public FlightService() {

	}

	@Autowired
	public FlightService(FlightRepository flightRepo) {
		this.flightRepo = flightRepo;
	}

	public Flight saveFlight(Flight flight) {
		return flightRepo.save(flight);
	}

	public List<Flight> getAllFlight() {
		return flightRepo.findAll();
	}

}
