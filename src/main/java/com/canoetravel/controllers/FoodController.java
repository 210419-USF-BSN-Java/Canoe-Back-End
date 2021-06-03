package com.canoetravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canoetravel.services.FoodService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200")
public class FoodController {
	
	private FoodService foodService;
	
	@Autowired
	public FoodController(FoodService serv) {
		this.foodService = serv;
	}

}
