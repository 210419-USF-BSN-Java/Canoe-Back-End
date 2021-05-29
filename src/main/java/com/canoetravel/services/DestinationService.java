package com.canoetravel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canoetravel.entities.Destination;
import com.canoetravel.entities.DestinationId;
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
	
	public boolean saveDestination(Destination dest, User user) {
		System.out.println("======================================");
		int id = (int) (destRepo.count()+1);
		dest.setDestinationId(new DestinationId(id, user));
		destRepo.save(dest);
		
		return true;
	}

	public List<Destination> getAllDestination() {
				return destRepo.findAll();
	}

}
