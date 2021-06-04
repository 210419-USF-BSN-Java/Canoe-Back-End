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
import com.canoetravel.entities.Lodging;
import com.canoetravel.entities.User;
import com.canoetravel.repository.DestinationRepository;
import com.canoetravel.services.LodgingService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://canoe-front.s3-website.us-east-2.amazonaws.com/")
public class LodgingController {

	private LodgingService lodgeService;
	private DestinationRepository destRepo;

	@Autowired
	public LodgingController(LodgingService lodgeService, DestinationRepository destRepo) {
		this.lodgeService = lodgeService;
		this.destRepo = destRepo;
	}

	@PostMapping(value = "/saveLodging")
	public ResponseEntity<String> saveLodging(@RequestBody Lodging lodging, HttpServletRequest req) {

		HttpSession session = req.getSession(false);
		if (session != null) {
			User authUser = (User) session.getAttribute("authUser");
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
					return new ResponseEntity<String>("can not save lodging", HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<String>("please select the destination first", HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<String>("Please Login or SignUp for Account", HttpStatus.UNAUTHORIZED);

		}

	}

	@GetMapping(value = "/allLodging")
	public ResponseEntity<List<Lodging>> getAllUsers() {
		List<Lodging> allLodging = lodgeService.getAllLodgingInfo();
		return new ResponseEntity<List<Lodging>>(allLodging, HttpStatus.OK);
	}

}
