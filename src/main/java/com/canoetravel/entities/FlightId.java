package com.canoetravel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class FlightId implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flight_info_id", columnDefinition = "serial")
	private Integer flightInfoId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "travel_destination_id", referencedColumnName = "destination_id", updatable = true, insertable = true)
	private Destination travelDestination;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", updatable = true, insertable = true)
	private User user;

	public FlightId() {
	}

	public FlightId(Integer flightInfoId, Destination travelDestination, User user) {
		super();
		this.flightInfoId = flightInfoId;
		this.travelDestination = travelDestination;
		this.user = user;
	}

	public Integer getFlightInfoId() {
		return flightInfoId;
	}

	public void setFlightInfoId(Integer flightInfoId) {
		this.flightInfoId = flightInfoId;
	}

	public Destination getTravelDestination() {
		return travelDestination;
	}

	public void setTravelDestination(Destination travelDestination) {
		this.travelDestination = travelDestination;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flightInfoId == null) ? 0 : flightInfoId.hashCode());
		result = prime * result + ((travelDestination == null) ? 0 : travelDestination.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (travelDestination == null) {
			if (other.travelDestination != null)
				return false;
		} else if (!travelDestination.equals(other.travelDestination))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FlightId [flightInfoId=" + flightInfoId + ", travelDestination=" + travelDestination + ", user=" + user
				+ "]";
	}

}
