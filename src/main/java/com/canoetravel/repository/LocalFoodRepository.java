package com.canoetravel.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canoetravel.entities.LocalFood;

public interface LocalFoodRepository extends JpaRepository<LocalFood, Integer>  {
	
	List<LocalFood> findLocalFoodByCustomerIdAndDestinationId(int customerId, int destinationId);

	int removeByLocalFoodId(Integer localFoodId);

}
