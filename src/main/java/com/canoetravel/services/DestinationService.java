package com.canoetravel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canoetravel.entities.Destination;
import com.canoetravel.entities.User;
import com.canoetravel.repository.DestinationRepository;
import com.canoetravel.service.interfaces.IDestinationService;

@Service
public class DestinationService implements IDestinationService {

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

	@Override
	public Destination deleteDestination(Destination dest) {
		return destRepo.deleteByCustomerIdAndDestinationId(dest.getCustomerId(), dest.getDestinationId());
	}
	

}
