package com.canoetravel.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "local_food_info")
@Data
public class LocalFood {

	@Id
	@Column(name = "local_food_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer local_food_id;

	@Column(name = "local_food_name")
	private String local_food_name;

	@Column(name = "restaurant_name")
	private String restaurant_name;

	@Column(name = "booked_date")
	private Date booked_date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "travel_destination_id", updatable = true, insertable = true)
	private Destination travel_destination_id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", updatable = true, insertable = true)
	private User user_id;

}
