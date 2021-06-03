package com.canoetravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canoetravel.entities.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Integer> {
	//Destination deleteByCustomerIdAndDestinationId(int customerId, int destinationId);

}
