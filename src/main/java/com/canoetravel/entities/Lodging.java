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
@Table(name = "lodging_info")
@Data
public class Lodging {

	@Id
	@Column(name = "lodging_info_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer lodging_info_id;

	@Column(name = "hotel_name")
	private String hotel_name;

	@Column(name = "check_in_date")
	private Date check_in_date;

	@Column(name = "check_out_date")
	private Date check_out_date;

	@Column(name = "per_night_price")
	private double per_night_price;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "travel_destination_id", updatable = true, insertable = true)
	private Destination travel_destination_id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", updatable = true, insertable = true)
	private User user_id;

}
