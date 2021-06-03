package com.canoetravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canoetravel.services.LodgingService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200")
public class LodgingController {

	private LodgingService lodService;
	
	@Autowired
	public LodgingController(LodgingService serv) {
		this.lodService = serv;
	}

}
