package com.canoetravel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canoetravel.entities.Destination;
import com.canoetravel.entities.LocalFood;
import com.canoetravel.repository.LocalFoodRepository;

@Service
public class FoodService {
	
	private LocalFoodRepository localFoodRepo;

	@Autowired
	public FoodService(LocalFoodRepository localFoodRepo) {
		this.localFoodRepo = localFoodRepo;
	}

	public FoodService() {

	}
	
	public LocalFood saveLocalFood(LocalFood localFood) {
		return localFoodRepo.save(localFood);
	}
	
	public List<LocalFood> getAllLocalFood() {
		return localFoodRepo.findAll();
	}

}
