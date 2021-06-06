package com.canoetravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canoetravel.entities.Lodging;

public interface LodgingRepository extends JpaRepository<Lodging, Integer>{

	List<Lodging> findLodgingBycustomerIdAndDestinationId(Integer userId, Integer destinationId);

	int removeByLodgingId(Integer lodgingId);

}
