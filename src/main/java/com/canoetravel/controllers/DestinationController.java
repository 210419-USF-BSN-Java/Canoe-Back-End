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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canoetravel.entities.Destination;
import com.canoetravel.entities.User;
import com.canoetravel.services.DestinationService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://canoe-front.s3-website.us-east-2.amazonaws.com/")
public class DestinationController {

	private static Logger log = LogManager.getLogger(DestinationController.class);

	private DestinationService destService;
	static Destination choosedDestination;
	
	
	@Autowired
	public DestinationController(DestinationService serv) {
		this.destService = serv;
	}

	@PostMapping(value = "/saveDestination")
	public ResponseEntity<String> saveDestination(@RequestBody Destination dest, HttpServletRequest req) {

//		HttpSession session = req.getSession(false);
//		if (session != null) {
//			User authUser = (User) session.getAttribute("authUser");
//			if (authUser != null) {
		//dest.setCustomerId(authUser.getUserId());
				User loginUser = UserController.loginUser;
				dest.setCustomerId(loginUser.getUserId());
				Destination saveDest = destService.saveDestination(dest);
				if (saveDest != null) {
					choosedDestination = saveDest;
					req.setAttribute("destination", dest);
					return new ResponseEntity<String>("destination saved successfully", HttpStatus.ACCEPTED);
				} else {
					log.warn("Unable to save destination");
					return new ResponseEntity<String>("can not save destination", HttpStatus.INTERNAL_SERVER_ERROR);
				}
//			} else {
//				log.warn("No user session");
//				return new ResponseEntity<String>("user not found - something went wrong", HttpStatus.BAD_REQUEST);
//			}
//		} else {
//			log.warn("No user session");
//			return new ResponseEntity<String>("Please Login or SignUp for account", HttpStatus.UNAUTHORIZED);
//		}
	}
	
	@GetMapping(value = "/gettripplan/{userid}", produces = "application/json")
    public ResponseEntity<List<Destination>> getUser(@PathVariable int user_id) {
		List<Destination> tripList = destService.getTripListByUserId(user_id);		
		if (tripList != null) {
			return new ResponseEntity<List<Destination>>(tripList, HttpStatus.OK);
		}else {
			log.warn("Unable to get user");
			return new ResponseEntity<>(null, HttpStatus.OK);

		}
	}
	
	
	@PutMapping(value = "/updateDestination")
	public ResponseEntity<String> updateDestination(@RequestBody Destination dest, HttpServletRequest req) {

		HttpSession session = req.getSession(false);
		if (session != null) {
			User authUser = (User) session.getAttribute("authUser");
			if (authUser != null) {
				dest.setCustomerId(authUser.getUserId());
				dest = destService.updateDestination(dest);
				if (dest != null) {
					session.setAttribute("destination", dest);
					return new ResponseEntity<String>("destination updated", HttpStatus.ACCEPTED);
				} else {
					log.warn("Unable to update destination");
					return new ResponseEntity<String>("can not update destination - something went worng", HttpStatus.INTERNAL_SERVER_ERROR);
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

}
