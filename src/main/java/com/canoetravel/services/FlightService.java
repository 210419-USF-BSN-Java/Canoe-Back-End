package com.canoetravel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canoetravel.entities.Flight;
import com.canoetravel.repository.FlightRepository;
import com.canoetravel.service.interfaces.IFlightService;

@Service
public class FlightService implements IFlightService {

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

	public List<Flight> getAllDestination() {
		return flightRepo.findAll();
	}

}
