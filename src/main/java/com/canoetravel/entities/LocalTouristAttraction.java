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
@Table(name = "local_tourist_attraction")
@Data
public class LocalTouristAttraction {

	@Id
	@Column(name = "local_tourist_attraction_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer local_tourist_attraction_id;

	@Column(name = "local_tourist_attraction_place")
	private String local_tourist_attraction_place;

	@Column(name = "booked_date")
	private Date booked_date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "travel_destination_id", updatable = true, insertable = true)
	private Destination travel_destination_id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", updatable = true, insertable = true)
	private User user_id;

}
