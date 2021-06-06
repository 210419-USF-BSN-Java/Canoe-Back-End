package com.canoetravel.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canoetravel.entities.Flight;
import com.canoetravel.entities.LocalTouristAttraction;
import com.canoetravel.repository.FlightRepository;


@Service
@Transactional
public class FlightService  {
	private static Logger log = LogManager.getLogger(FlightService.class);

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

	public List<Flight> getFlightsByUserIdAndDestinationId(Integer userId, Integer destinationId) {
		List<Flight> list =  flightRepo.findFlightBycustomerIdAndDestinationId(userId, destinationId);
		return list;
	}

	public int deleteFlightByFlightInfoId(int flightInfoId) {
		int c = 0;
		log.warn("inside flight service");
		 c = flightRepo.removeByFlightInfoId(flightInfoId);
		log.warn("The int c value is in service " + c);
		return c;
	}

}
