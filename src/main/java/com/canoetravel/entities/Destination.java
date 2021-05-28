package com.canoetravel.entities;

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
@Table(name = "travel_destination")
@Data
public class Destination {

	@Id
	@Column(name = "destination_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer destination_id;

	@Column(name = "destination_country")
	private String destination_country;

	@Column(name = "destination_city")
	private String destination_city;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", updatable = true, insertable = true)
	private UserRole user_id;

}
