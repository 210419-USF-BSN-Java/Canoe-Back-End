package com.canoetravel.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "travel_destination")
public class Destination {

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.AUTO)
	private DestinationId destinationId;

	@Column(name = "destination_country")
	private String destinationCountry;

	@Column(name = "destination_city")
	private String destinationCity;

	public Destination() {
	}

	public Destination(DestinationId destinationId, String destinationCountry, String destinationCity) {
		super();
		this.destinationId = destinationId;
		this.destinationCountry = destinationCountry;
		this.destinationCity = destinationCity;
	}

	public DestinationId getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(DestinationId destinationId) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
				+ ", destinationCity=" + destinationCity + "]";
	}

}
