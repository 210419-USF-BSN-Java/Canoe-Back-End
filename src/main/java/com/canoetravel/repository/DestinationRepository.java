package com.canoetravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canoetravel.entities.Destination;
import com.canoetravel.entities.DestinationId;

public interface DestinationRepository extends JpaRepository<Destination, DestinationId> {

}
