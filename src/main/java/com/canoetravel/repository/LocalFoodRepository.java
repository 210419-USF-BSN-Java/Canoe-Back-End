package com.canoetravel.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.canoetravel.entities.LocalFood;

public interface LocalFoodRepository extends JpaRepository<LocalFood, Integer>  {

}
