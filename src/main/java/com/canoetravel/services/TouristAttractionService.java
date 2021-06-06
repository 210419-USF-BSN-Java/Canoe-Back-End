package com.canoetravel.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canoetravel.controllers.TouristAttractionController;
import com.canoetravel.entities.LocalTouristAttraction;
import com.canoetravel.repository.LocalTouristAttractionRepository;

@Service
@Transactional
public class TouristAttractionService {

	private LocalTouristAttractionRepository touristAttractionRepo;
	private static Logger log = LogManager.getLogger(TouristAttractionService.class);

	@Autowired
	public TouristAttractionService(LocalTouristAttractionRepository touristAttractionRepo) {
		this.touristAttractionRepo = touristAttractionRepo;
	}

	public LocalTouristAttraction saveLocalTouristAttraction(LocalTouristAttraction localTouristAttraction) {
		return touristAttractionRepo.save(localTouristAttraction);
	}
	
	public List<LocalTouristAttraction> getAllTouristAttractions() {
		return touristAttractionRepo.findAll();
	}

	public LocalTouristAttraction updateLocalTouristAttraction(LocalTouristAttraction localTouristAttraction) {
		return touristAttractionRepo.save(localTouristAttraction);
	}

	public List<LocalTouristAttraction> getLocalTouristAttractionByUserIdAndDestinationId(Integer customerId,
			Integer destinationId) {
		
		List<LocalTouristAttraction> list =  touristAttractionRepo.findLocalTouristAttractionBycustomerIdAndDestinationId(customerId, destinationId);
		System.out.println(list.size());
		return list;
		
	}

	public int deleteTouristAttractionByLocalTouristAttraction(int localTouristAttaraction) {
		int c = 0;
		log.warn("inside tourist service");
		 c = touristAttractionRepo.removeByLocalTouristAttaraction(localTouristAttaraction);
		log.warn("The int c value is in service " + c);
		return c;
	}

}
