package com.canoetravel.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	private static Logger log = LogManager.getLogger(FoodController.class);
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
					log.warn("Unable to save local food");
					return new ResponseEntity<String>("can not save local food", HttpStatus.BAD_REQUEST);
				}
			} else {
				log.warn("Unable to find destination information");
				return new ResponseEntity<String>("please select the destination first", HttpStatus.BAD_REQUEST);
			}
		} else {
			log.warn("No session found");
			return new ResponseEntity<String>("Please Login or SignUp for account", HttpStatus.UNAUTHORIZED);
		}

	}
	
	@GetMapping(value = "/allLocalFood")
	public ResponseEntity<List<LocalFood>> getAllLocalFood() {
		log.warn("Returning all local food data");
		List<LocalFood> allLocalFoods = foodService.getAllLocalFood();
		return new ResponseEntity<List<LocalFood>>(allLocalFoods, HttpStatus.OK);
	}
	
	@PutMapping(value = "/updatelocalFood")
	public ResponseEntity<String> updateLocalFood(@RequestBody LocalFood localFood, HttpServletRequest req) {

		HttpSession session = req.getSession(false);
		if (session != null) {
			User authUser = (User) session.getAttribute("authUser");
			Destination dest = (Destination) session.getAttribute("destination");
			if (authUser != null) {
				localFood.setCustomerId(authUser.getUserId());
				localFood.setDestinationId(dest.getDestinationId());
				
				LocalFood localFoodAttraction = foodService.updateLocalFood(localFood);
				if (localFoodAttraction != null) {
					session.setAttribute("destination", dest);
					return new ResponseEntity<String>("local food updated", HttpStatus.ACCEPTED);
				} else {
					log.warn("Unable to update local food");
					return new ResponseEntity<String>("can not update local food  - something went worng", HttpStatus.INTERNAL_SERVER_ERROR);
				}
			} else {
				log.warn("No user found in session, bad request");
				return new ResponseEntity<String>("user not found - something went wrong", HttpStatus.BAD_REQUEST);
			}
		} else {
			log.warn("No user session");
			return new ResponseEntity<String>("Please Login or SignUp for account", HttpStatus.UNAUTHORIZED);

		}
	}
	
	@GetMapping(value = "/getUserlocalfood")
	public ResponseEntity<List<LocalFood>> findLocalFoodByUserAndDestination(HttpServletRequest req){
		List<LocalFood> allLocalFoods = null;
		HttpSession session = req.getSession(false);
		if (session != null) {
			User authUser = (User) session.getAttribute("authUser");
			Destination dest = (Destination) session.getAttribute("destination");
			if (authUser != null) {
				 allLocalFoods = foodService.getLocalFoodByUserIdAndDestinationId(authUser.getUserId(), dest.getDestinationId());
			} else {
				log.warn("No user found in session, bad request");
				return new ResponseEntity<List<LocalFood>>(allLocalFoods, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
	} else {
		log.warn("No session found , bad request");
			return new ResponseEntity<List<LocalFood>>(allLocalFoods, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<LocalFood>>(allLocalFoods, HttpStatus.OK);

	}
	
	@DeleteMapping(value = "/deletelocalFoodByUser")
	public ResponseEntity<String> deleteLocalFoodByUserAndDestination(@RequestBody LocalFood LocalFood, HttpServletRequest req){
		HttpSession session = req.getSession(false);
		if (session != null) {
			User authUser = (User) session.getAttribute("authUser");
			if (authUser != null) {
				int c =  foodService.deleteLocalFoodByLocalFoodId(LocalFood.getLocalFoodId());

				if (c > 0) {
					return new ResponseEntity<String>("local food deleted successfully", HttpStatus.OK);
				} else {
					log.warn("can not delete food");
					return new ResponseEntity<String>("can not delete local food entry", HttpStatus.BAD_REQUEST);
				}
			} else {
				log.warn("No user found in session");
				return new ResponseEntity<String>("No user found in session", HttpStatus.BAD_REQUEST);
			}
		} else {
			log.warn("No session found");
			return new ResponseEntity<String>("Please Login or SignUp for account", HttpStatus.UNAUTHORIZED);
		}
	
	}
}
