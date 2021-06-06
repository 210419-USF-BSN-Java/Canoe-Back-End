package com.canoetravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canoetravel.entities.LocalTouristAttraction;

public interface LocalTouristAttractionRepository extends JpaRepository<LocalTouristAttraction, Integer> {
	List<LocalTouristAttraction> findLocalTouristAttractionBycustomerIdAndDestinationId(int user_Id, int travel_destination_id);
}
