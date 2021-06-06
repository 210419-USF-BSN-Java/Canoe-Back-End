package com.canoetravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canoetravel.entities.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Integer> {
	
	List<Destination> findByCustomerId(int user_id);  

}
