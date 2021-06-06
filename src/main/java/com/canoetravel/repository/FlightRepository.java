package com.canoetravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canoetravel.entities.Flight;
import com.canoetravel.entities.LocalTouristAttraction;

public interface FlightRepository extends JpaRepository<Flight, Integer>{

	List<Flight> findFlightBycustomerIdAndDestinationId(int user_Id, int travel_destination_id);

	int removeByFlightInfoId(Integer flightInfoId);
}
