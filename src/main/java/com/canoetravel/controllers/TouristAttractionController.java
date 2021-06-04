package com.canoetravel.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canoetravel.entities.Destination;
import com.canoetravel.entities.LocalTouristAttraction;
import com.canoetravel.entities.User;
import com.canoetravel.services.TouristAttractionService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200")
public class TouristAttractionController {
	
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
				LocalTouristAttraction LocalTAttraction = ts.saveLocalTouristAttraction(tAttraction);
				if (LocalTAttraction != null) {
					return new ResponseEntity<String>("local tourist attraction saved successfully", HttpStatus.OK);
				} else {
					return new ResponseEntity<String>("can not save tourist attraction", HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<String>("please select the destination first", HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<String>("Please Login or SignUp for account", HttpStatus.UNAUTHORIZED);
		}

	}

}
