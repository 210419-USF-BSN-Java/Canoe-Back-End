package com.canoetravel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canoetravel.entities.Lodging;
import com.canoetravel.repository.LodgingRepository;
import com.canoetravel.service.interfaces.ILodgingService;

@Service
public class LodgingService implements ILodgingService {

	private LodgingRepository lodgingRepo;

	public LodgingService() {

	}

	@Autowired
	public LodgingService(LodgingRepository lodgingRepo) {
		this.lodgingRepo = lodgingRepo;
	}
	
	public Lodging saveFlight(Lodging lodging) {
		return lodgingRepo.save(lodging);
	}

	public List<Lodging> getAllLodgingInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
