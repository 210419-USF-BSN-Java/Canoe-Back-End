package com.canoetravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canoetravel.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{

}
