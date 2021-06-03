package com.canoetravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canoetravel.entities.Lodging;
import com.canoetravel.entities.LodgingId;

public interface LodgingRepository extends JpaRepository<Lodging, LodgingId>{

}
