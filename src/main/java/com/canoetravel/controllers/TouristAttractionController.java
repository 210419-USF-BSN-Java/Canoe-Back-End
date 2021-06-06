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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canoetravel.entities.Destination;
import com.canoetravel.entities.LocalFood;
import com.canoetravel.entities.LocalTouristAttraction;
import com.canoetravel.entities.User;
import com.canoetravel.services.TouristAttractionService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200")
public class TouristAttractionController {
	private static Logger log = LogManager.getLogger(TouristAttractionController.class);
	private TouristAttractionService ts;

	@Autowired
	public TouristAttractionController(TouristAttractionService ts) {
		this.ts = ts;
	}
	
	@PostMapping(value = "/saveTouristAttraction")
	public ResponseEntity<String> saveLodging(@RequestBody LocalTouristAttraction tAttraction, HttpServletRequest req) {

		HttpSession session = req.getSession(false);
		if (session != null) {
			User authUser = (User) session.getAttribute("authUser");
			Destination dest = (Destination) session.getAttribute("destination");

			if (tAttraction != null) {
				tAttraction.setCustomerId(authUser.getUserId());
				tAttraction.setDestinationId(dest.getDestinationId());
				LocalTouristAttraction localTAttraction = ts.saveLocalTouristAttraction(tAttraction);
				if (localTAttraction != null) {
					return new ResponseEntity<String>("local tourist attraction saved successfully", HttpStatus.OK);
				} else {
					log.warn("can not save tourist attraction");
					return new ResponseEntity<String>("can not save tourist attraction", HttpStatus.BAD_REQUEST);
				}
			} else {
				log.warn("No destination");
				return new ResponseEntity<String>("please select the destination first", HttpStatus.BAD_REQUEST);
			}
		} else {
			log.warn("No user session");
			return new ResponseEntity<String>("Please Login or SignUp for account", HttpStatus.UNAUTHORIZED);
		}

	}
	
	@GetMapping(value = "/allTouristAttractions")
	public ResponseEntity<List<LocalTouristAttraction>> getAllTouristAttractions() {
		log.warn("Inside get all tourist attractions" );
		List<LocalTouristAttraction> allAttractions = ts.getAllTouristAttractions();
		return new ResponseEntity<List<LocalTouristAttraction>>(allAttractions, HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateTouristAttraction")
	public ResponseEntity<String> updateDestination(@RequestBody LocalTouristAttraction tAttraction, HttpServletRequest req) {

		HttpSession session = req.getSession(false);
		if (session != null) {
			User authUser = (User) session.getAttribute("authUser");
			Destination dest = (Destination) session.getAttribute("destination");
			if (authUser != null) {
				tAttraction.setCustomerId(authUser.getUserId());
				tAttraction.setDestinationId(dest.getDestinationId());
				
				LocalTouristAttraction localtAttraction = ts.updateLocalTouristAttraction(tAttraction);
				if (localtAttraction != null) {
					session.setAttribute("destination", dest);
					return new ResponseEntity<String>("local tourist attraction updated", HttpStatus.ACCEPTED);
				} else {
					log.warn("Unable to update local tourist attraction");
					return new ResponseEntity<String>("can not update local attraction destination - something went worng", HttpStatus.INTERNAL_SERVER_ERROR);
				}
			} else {
				log.warn("No user  found");
				return new ResponseEntity<String>("user not found - something went wrong", HttpStatus.BAD_REQUEST);
			}
		} else {
			log.warn("No user session");
			return new ResponseEntity<String>("Please Login or SignUp for account", HttpStatus.UNAUTHORIZED);

		}
	}
	
	@GetMapping(value = "/getUserlocaltouristAttractions")
	public ResponseEntity<List<LocalTouristAttraction>> findLocalFoodByUserAndDestination(HttpServletRequest req){
		List<LocalTouristAttraction> allLocalTA = null;
		HttpSession session = req.getSession(false);
		if (session != null) {
			User authUser = (User) session.getAttribute("authUser");
			Destination dest = (Destination) session.getAttribute("destination");
			if (authUser != null) {
				allLocalTA = ts.getLocalTouristAttractionByUserIdAndDestinationId(authUser.getUserId(), dest.getDestinationId());
//				 allLocalTA = ts.getLocalTouristAttractionByUserIdAndDestinationId(1, 4); // for testing
				 return new ResponseEntity<List<LocalTouristAttraction>>(allLocalTA, HttpStatus.OK);

			} else {
				log.warn("No user found in session, bad request");
				return new ResponseEntity<List<LocalTouristAttraction>>(allLocalTA, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
	} else {
		log.warn("No session found , bad request");
			return new ResponseEntity<List<LocalTouristAttraction>>(allLocalTA, HttpStatus.BAD_REQUEST);
		}
	}

}
