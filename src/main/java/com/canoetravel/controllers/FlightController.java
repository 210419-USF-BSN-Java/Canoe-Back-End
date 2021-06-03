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
import com.canoetravel.entities.Flight;
import com.canoetravel.entities.User;
import com.canoetravel.services.FlightService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {

	private FlightService flightService;

	@Autowired
	public FlightController(FlightService flightService) {
		this.flightService = flightService;
	}

	@PostMapping(value = "/saveFlight")
	public ResponseEntity<String> saveFlight(@RequestBody Flight flight, HttpServletRequest req) {

		HttpSession session = req.getSession(false);
		if (session != null) {
			User authUser = (User) session.getAttribute("authUser");

			Destination dest = (Destination) session.getAttribute("destination");

			if (dest != null) {
				flight.setCustomerId(authUser.getUserId());
				flight.setDestinationId(dest.getDestinationId());
				Flight saveFlight = flightService.saveFlight(flight);
				if (saveFlight != null) {
					return new ResponseEntity<String>("flight saved successfully", HttpStatus.OK);
				} else {
					return new ResponseEntity<String>("can not save flight", HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<String>("please select the destination first", HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<String>("Please Login or SignUp for account", HttpStatus.UNAUTHORIZED);

		}

	}

}
