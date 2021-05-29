package com.canoetravel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class FlightId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "flight_info_id")
	private Integer flightInfoId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
			@JoinColumn(name = "travel_destination_id", referencedColumnName = "destination_id", updatable = true, insertable = true),
			@JoinColumn(name = "user_id", referencedColumnName = "user_id", updatable = true, insertable = true) })
	private Destination travelDestinationId;

	public FlightId() {
	}

	public FlightId(Integer flightInfoId, Destination travelDestinationId) {
		super();
		this.flightInfoId = flightInfoId;
		this.travelDestinationId = travelDestinationId;
	}

	public Integer getFlightInfoId() {
		return flightInfoId;
	}

	public void setFlightInfoId(Integer flightInfoId) {
		this.flightInfoId = flightInfoId;
	}

	public Destination getTravelDestinationId() {
		return travelDestinationId;
	}

	public void setTravelDestinationId(Destination travelDestinationId) {
		this.travelDestinationId = travelDestinationId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flightInfoId == null) ? 0 : flightInfoId.hashCode());
		result = prime * result + ((travelDestinationId == null) ? 0 : travelDestinationId.hashCode());
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
		FlightId other = (FlightId) obj;
		if (flightInfoId == null) {
			if (other.flightInfoId != null)
				return false;
		} else if (!flightInfoId.equals(other.flightInfoId))
			return false;
		if (travelDestinationId == null) {
			if (other.travelDestinationId != null)
				return false;
		} else if (!travelDestinationId.equals(other.travelDestinationId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FlightId [flightInfoId=" + flightInfoId + ", travelDestinationId=" + travelDestinationId + "]";
	}

}
