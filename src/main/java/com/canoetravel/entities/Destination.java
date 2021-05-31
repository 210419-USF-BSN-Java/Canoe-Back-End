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
//@IdClass(DestinationId.class)
public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "destination_id", columnDefinition = "serial")
	private Integer destinationId;

	@Column(name = "destination_country")
	private String destinationCountry;

	@Column(name = "destination_city")
	private String destinationCity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dest_to_user_id", updatable = false, insertable = false)
	private User customer;
	
	@Column(name = "dest_to_user_id")
	private Integer customerId;
	

	public Destination() {
	}

	public Destination(Integer destinationId, String destinationCountry, String destinationCity, User customer) {
		super();
		this.destinationId = destinationId;
		this.destinationCountry = destinationCountry;
		this.destinationCity = destinationCity;
		this.customer = customer;
	}

	public Integer getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}

	public String getDestinationCountry() {
		return destinationCountry;
	}

	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((destinationCity == null) ? 0 : destinationCity.hashCode());
		result = prime * result + ((destinationCountry == null) ? 0 : destinationCountry.hashCode());
		result = prime * result + ((destinationId == null) ? 0 : destinationId.hashCode());
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
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (destinationCity == null) {
			if (other.destinationCity != null)
				return false;
		} else if (!destinationCity.equals(other.destinationCity))
			return false;
		if (destinationCountry == null) {
			if (other.destinationCountry != null)
				return false;
		} else if (!destinationCountry.equals(other.destinationCountry))
			return false;
		if (destinationId == null) {
			if (other.destinationId != null)
				return false;
		} else if (!destinationId.equals(other.destinationId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Destination [destinationId=" + destinationId + ", destinationCountry=" + destinationCountry
				+ ", destinationCity=" + destinationCity + ", customer=" + customer + "]";
	}

}
