package com.canoetravel.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canoetravel.entities.LocalFood;
import com.canoetravel.repository.LocalFoodRepository;

@Service
@Transactional
public class FoodService {
	
	private static Logger log = LogManager.getLogger(FoodService.class);

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

	public LocalFood updateLocalFood(LocalFood localFood) {
		return localFoodRepo.save(localFood);
	}

	public List<LocalFood> getLocalFoodByUserIdAndDestinationId(int customerId, int destinbationId) {
		return localFoodRepo.findLocalFoodByCustomerIdAndDestinationId(customerId, destinbationId);
		
	}

	public int deleteLocalFoodByLocalFoodId(Integer localFoodId) {
		int c = 0;
		log.warn("inside food service");
		 c = localFoodRepo.removeByLocalFoodId(localFoodId);
		log.warn("The int c value is in service " + c);
		return c;
	}


}
