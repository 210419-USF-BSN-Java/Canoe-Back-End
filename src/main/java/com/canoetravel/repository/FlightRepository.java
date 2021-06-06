package com.canoetravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canoetravel.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{

	List<Flight> findFlightBycustomerIdAndDestinationId(int user_Id, int travel_destination_id);
}
