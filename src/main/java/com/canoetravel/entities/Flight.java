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
@Table(name = "flight_info")
@Data
public class Flight {

	@Id
	@Column(name = "flight_info_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flight_info_id;

	@Column(name = "flight_no")
	private String flight_no;

	@Column(name = "airline_name")
	private String airline_name;

	@Column(name = "depart_airport")
	private String depart_airport;

	@Column(name = "depart_date")
	private Date depart_date;

	@Column(name = "arrival_airport")
	private String arrival_airport;

	@Column(name = "arrival_date")
	private Date arrival_date;

	@Column(name = "flight_price")
	private double flight_price;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "travel_destination_id", updatable = true, insertable = true)
	private Destination travel_destination_id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", updatable = true, insertable = true)
	private User user_id;
}
