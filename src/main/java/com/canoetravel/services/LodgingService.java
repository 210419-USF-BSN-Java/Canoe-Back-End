package com.canoetravel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canoetravel.entities.Lodging;
import com.canoetravel.repository.LodgingRepository;

@Service
public class LodgingService {

	private LodgingRepository lodgingRepo;

	public LodgingService() {

	}

	@Autowired
	public LodgingService(LodgingRepository lodgingRepo) {
		this.lodgingRepo = lodgingRepo;
	}

	public Lodging saveLodging(Lodging lodging) {
		return lodgingRepo.save(lodging);
	}

	public List<Lodging> getAllLodgingInfo() {
		return lodgingRepo.findAll();
	}

}
