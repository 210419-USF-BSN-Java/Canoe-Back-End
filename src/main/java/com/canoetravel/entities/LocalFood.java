package com.canoetravel.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "local_food_info")
public class LocalFood {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer localFood;

	@Column(name = "local_food_name")
	private String locaFoodName;

	@Column(name = "restaurant_name")
	private String restaurantName;

	@Column(name = "booked_date")
	private Date bookedDate;

	public LocalFood() {
	}

	
}
