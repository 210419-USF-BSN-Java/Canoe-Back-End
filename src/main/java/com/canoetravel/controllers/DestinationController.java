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
import com.canoetravel.entities.User;
import com.canoetravel.services.DestinationService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200")
public class DestinationController {

	private DestinationService destService;

	@Autowired
	public DestinationController(DestinationService serv) {
		this.destService = serv;
	}

	@PostMapping(value = "/saveDestination")
	public ResponseEntity<String> saveDestination(@RequestBody Destination dest, HttpServletRequest req) {

		HttpSession session = req.getSession(false);
		if (session != null) {
			User authUser = (User) session.getAttribute("authUser");
			if (authUser != null) {
				dest = destService.saveDestination(dest, authUser);
				if (dest != null) {
					session.setAttribute("destination", dest);
					return new ResponseEntity<String>("destination saved", HttpStatus.ACCEPTED);
				} else {
					return new ResponseEntity<String>("can not save destination", HttpStatus.INTERNAL_SERVER_ERROR);
				}
			} else {
				return new ResponseEntity<String>("user not found", HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<String>("Please Login or SignUp for account", HttpStatus.UNAUTHORIZED);

		}
	}

	// TODO below code is Just for testing purpose need to delete or secured for
	// employee/admin user only
	@GetMapping(value = "/allDestination")
	public ResponseEntity<List<Destination>> getAllUsers() {
		List<Destination> alldestination = destService.getAllDestination();
		return new ResponseEntity<List<Destination>>(alldestination, HttpStatus.OK);
	}

}
