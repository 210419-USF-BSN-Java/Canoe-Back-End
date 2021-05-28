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

@Entity
@Table(name = "travel_destination")
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

	public Destination() {
	}

	public Destination(Integer destination_id, String destination_country, String destination_city, UserRole user_id) {
		super();
		this.destination_id = destination_id;
		this.destination_country = destination_country;
		this.destination_city = destination_city;
		this.user_id = user_id;
	}

	public Integer getDestination_id() {
		return destination_id;
	}

	public void setDestination_id(Integer destination_id) {
		this.destination_id = destination_id;
	}

	public String getDestination_country() {
		return destination_country;
	}

	public void setDestination_country(String destination_country) {
		this.destination_country = destination_country;
	}

	public String getDestination_city() {
		return destination_city;
	}

	public void setDestination_city(String destination_city) {
		this.destination_city = destination_city;
	}

	public UserRole getUser_id() {
		return user_id;
	}

	public void setUser_id(UserRole user_id) {
		this.user_id = user_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destination_city == null) ? 0 : destination_city.hashCode());
		result = prime * result + ((destination_country == null) ? 0 : destination_country.hashCode());
		result = prime * result + ((destination_id == null) ? 0 : destination_id.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Destination other = (Destination) obj;
		if (destination_city == null) {
			if (other.destination_city != null)
				return false;
		} else if (!destination_city.equals(other.destination_city))
			return false;
		if (destination_country == null) {
			if (other.destination_country != null)
				return false;
		} else if (!destination_country.equals(other.destination_country))
			return false;
		if (destination_id == null) {
			if (other.destination_id != null)
				return false;
		} else if (!destination_id.equals(other.destination_id))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Destination [destination_id=" + destination_id + ", destination_country=" + destination_country
				+ ", destination_city=" + destination_city + ", user_id=" + user_id + "]";
	}

}
