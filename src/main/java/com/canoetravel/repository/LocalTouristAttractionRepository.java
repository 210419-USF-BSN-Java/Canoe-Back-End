package com.canoetravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canoetravel.entities.LocalTouristAttraction;

public interface LocalTouristAttractionRepository extends JpaRepository<LocalTouristAttraction, Integer> {
	
	List<LocalTouristAttraction> findLocalTouristAttractionBycustomerIdAndDestinationId(Integer user_Id, Integer travel_destination_id);

	int removeByLocalTouristAttaraction(Integer localTouristAttaraction);
}
