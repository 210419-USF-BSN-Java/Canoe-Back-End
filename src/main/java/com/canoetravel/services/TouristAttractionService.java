package com.canoetravel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canoetravel.entities.LocalTouristAttraction;
import com.canoetravel.repository.LocalTouristAttractionRepository;

@Service
public class TouristAttractionService {

	private LocalTouristAttractionRepository touristAttractionRepo;

	@Autowired
	public TouristAttractionService(LocalTouristAttractionRepository touristAttractionRepo) {
		this.touristAttractionRepo = touristAttractionRepo;
	}

	public LocalTouristAttraction saveLocalTouristAttraction(LocalTouristAttraction localTouristAttraction) {
		return touristAttractionRepo.save(localTouristAttraction);
	}
	
	public List<LocalTouristAttraction> getAllTouristAttractions() {
		return touristAttractionRepo.findAll();
	}

}
