package com.canoetravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canoetravel.entities.Flight;
import com.canoetravel.entities.FlightId;

public interface FlightRepository extends JpaRepository<Flight, FlightId>{

}
