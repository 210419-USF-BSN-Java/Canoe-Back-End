package com.canoetravel.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "local_tourist_attraction")
public class LocalTouristAttraction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer localTouristAttaraction;

	@Column(name = "local_tourist_attraction_place")
	private String localTouristAttractionPlace;

	@Column(name = "booked_date")
	private Date bookedDate;

	public LocalTouristAttraction() {
	}

	

}
