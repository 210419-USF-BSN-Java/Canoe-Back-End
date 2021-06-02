package com.canoetravel.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.canoetravel.entities.Destination;
import com.canoetravel.entities.User;
import com.canoetravel.repository.DestinationRepository;

@Service
public class DestinationService {

	private DestinationRepository destRepo;

	public DestinationService() {

	}

	@Autowired
	public DestinationService(DestinationRepository destRepo) {
		this.destRepo = destRepo;
	}

	public Destination saveDestination(Destination dest, User user) {
		dest.setCustomerId(user.getUserId());
		return destRepo.save(dest);
	}

	public List<Destination> getAllDestination() {
		return destRepo.findAll();
	}

	public Destination updateDestination(Destination dest) {
		return destRepo.save(dest);
	}
	

}
