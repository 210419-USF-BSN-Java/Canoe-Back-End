package com.canoetravel.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canoetravel.entities.LocalTouristAttraction;
import com.canoetravel.entities.Lodging;
import com.canoetravel.repository.LodgingRepository;

@Service
@Transactional
public class LodgingService {

	private static Logger log = LogManager.getLogger(LodgingService.class);
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

	public List<Lodging> getLodgingByUserIdAndDestinationId(Integer userId, Integer destinationId) {
		List<Lodging> list =  lodgingRepo.findLodgingBycustomerIdAndDestinationId(userId, destinationId);
//		System.out.println(list.size());
		return list;
	}

	public int deleteLodgingByLodgingId(Integer lodgingId) {
		int c = 0;
		log.warn("inside tourist service");
		 c = lodgingRepo.removeByLodgingId(lodgingId);
		log.warn("The int c value is in service " + c);
		return c;
	}

}
