package com.canoetravel.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canoetravel.entities.Destination;
import com.canoetravel.entities.LocalFood;
import com.canoetravel.entities.User;
import com.canoetravel.services.FoodService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://canoe-front.s3-website.us-east-2.amazonaws.com/")
public class FoodController {

	private FoodService foodService;

	@Autowired
	public FoodController(FoodService foodService) {
		this.foodService = foodService;
	}

	@PostMapping(value = "/saveLocalFood")
	public ResponseEntity<String> saveLodging(@RequestBody LocalFood localFood, HttpServletRequest req) {

		HttpSession session = req.getSession(false);
		if (session != null) {
			User authUser = (User) session.getAttribute("authUser");
			Destination dest = (Destination) session.getAttribute("destination");

			if (dest != null) {
				localFood.setCustomerId(authUser.getUserId());
				localFood.setDestinationId(dest.getDestinationId());
				LocalFood saveLocalFood = foodService.saveLocalFood(localFood);
				if (saveLocalFood != null) {
					return new ResponseEntity<String>("local food event saved successfully", HttpStatus.OK);
				} else {
					return new ResponseEntity<String>("can not save local food", HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<String>("please select the destination first", HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<String>("Please Login or SignUp for account", HttpStatus.UNAUTHORIZED);
		}

	}
	
	@GetMapping(value = "/allLocalFood")
	public ResponseEntity<List<LocalFood>> getAllUsers() {
		List<LocalFood> allLocalFoods = foodService.getAllLocalFood();
		return new ResponseEntity<List<LocalFood>>(allLocalFoods, HttpStatus.OK);
	}

}
