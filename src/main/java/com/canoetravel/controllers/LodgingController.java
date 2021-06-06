package com.canoetravel.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.canoetravel.entities.Destination;
import com.canoetravel.entities.LocalTouristAttraction;
import com.canoetravel.entities.Lodging;
import com.canoetravel.entities.User;
import com.canoetravel.repository.DestinationRepository;
import com.canoetravel.services.LodgingService;
import com.canoetravel.services.UserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://canoe-front.s3-website.us-east-2.amazonaws.com/")
@SessionAttributes("authUser")
public class LodgingController {

	private static Logger log = LogManager.getLogger(LodgingController.class);
	private LodgingService lodgeService;
	private DestinationRepository destRepo;
	private UserService userService = new UserService();


	@Autowired
	public LodgingController(LodgingService lodgeService, DestinationRepository destRepo) {
		this.lodgeService = lodgeService;
		this.destRepo = destRepo;
	}

	@PostMapping(value = "/saveLodging")
	public ResponseEntity<String> saveLodging(@RequestBody Lodging lodging, HttpSession session, HttpServletRequest req) {

		Cookie[] cookies = req.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("user_email")){
				User user = userService.findByEmail(cookie.getValue());
				System.out.println(cookie.getValue());
				System.out.println(user);
				if (user != null) {
					Destination dest = (Destination) session.getAttribute("destination");

					if (dest != null) {
						lodging.setCustomerId(user.getUserId());
						lodging.setDestinationId(dest.getDestinationId());
						Lodging saveLodging = lodgeService.saveLodging(lodging);
						if (saveLodging != null) {
							dest.setLodgingId(saveLodging.getLodgingId());
							destRepo.save(dest);
							session.setAttribute("destination", dest);
							return new ResponseEntity<String>("lodging saved successfully", HttpStatus.OK);
						} else {
							log.warn("Unable to save lodging data");
							return new ResponseEntity<String>("can not save lodging", HttpStatus.BAD_REQUEST);
						}
					} else {
						log.warn("Unable to find destination data");
						return new ResponseEntity<String>("please select the destination first", HttpStatus.BAD_REQUEST);
					}
				} else {
					log.warn("Unable to find user session");
					return new ResponseEntity<String>("Please Login or SignUp for Account", HttpStatus.UNAUTHORIZED);
				}
			}
		}/*
		User authUser = (User) session.getAttribute("authUser");
		if (authUser != null) {
			Destination dest = (Destination) session.getAttribute("destination");

			if (dest != null) {
				lodging.setCustomerId(authUser.getUserId());
				lodging.setDestinationId(dest.getDestinationId());
				Lodging saveLodging = lodgeService.saveLodging(lodging);
				if (saveLodging != null) {
					dest.setLodgingId(saveLodging.getLodgingId());
					destRepo.save(dest);
					session.setAttribute("destination", dest);
					return new ResponseEntity<String>("lodging saved successfully", HttpStatus.OK);
				} else {
					log.warn("Unable to save lodging data");
					return new ResponseEntity<String>("can not save lodging", HttpStatus.BAD_REQUEST);
				}
			} else {
				log.warn("Unable to find destination data");
				return new ResponseEntity<String>("please select the destination first", HttpStatus.BAD_REQUEST);
			}
		} else {
			log.warn("Unable to find user session");
			return new ResponseEntity<String>("Please Login or SignUp for Account", HttpStatus.UNAUTHORIZED);
		}*/
		return null;
	}

	@GetMapping(value = "/allLodging")
	public ResponseEntity<List<Lodging>> getAllUsers() {
		log.warn("Retrieved all lodging places");
		List<Lodging> allLodging = lodgeService.getAllLodgingInfo();
		return new ResponseEntity<List<Lodging>>(allLodging, HttpStatus.OK);
	}

	
	@GetMapping(value = "/getUserLodging")
	public ResponseEntity<List<Lodging>> findLocalFoodByUserAndDestination(HttpServletRequest req){
		List<Lodging> allLodgings = null;
		HttpSession session = req.getSession(false);
		if (session != null) {
			User authUser = (User) session.getAttribute("authUser");
			Destination dest = (Destination) session.getAttribute("destination");
			if (authUser != null) {
				allLodgings = lodgeService.getLodgingByUserIdAndDestinationId(authUser.getUserId(), dest.getDestinationId());
//				allLodgings = lodgeService.getLodgingByUserIdAndDestinationId(1, 4); //testing
				

				 return new ResponseEntity<List<Lodging>>(allLodgings, HttpStatus.OK);

			} else {
				log.warn("No user found in session, bad request");
				return new ResponseEntity<List<Lodging>>(allLodgings, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
	} else {
		log.warn("No session found , bad request");
			return new ResponseEntity<List<Lodging>>(allLodgings, HttpStatus.BAD_REQUEST);
		}
	}
}
