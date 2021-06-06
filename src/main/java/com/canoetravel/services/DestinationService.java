package com.canoetravel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Destination saveDestination(Destination dest) {
		return destRepo.save(dest);
	}

	public List<Destination> getAllDestination() {
		return destRepo.findAll();
	}

	public Destination updateDestination(Destination dest) {
		return destRepo.save(dest);
	}

	public List<Destination> getTripListByUserId(int user_id) {
	 List<Destination> tripList = destRepo.findByCustomerId(user_id);
	return tripList;
	}

}
