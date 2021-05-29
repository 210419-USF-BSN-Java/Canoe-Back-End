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

@Entity
@Table(name = "local_tourist_attraction")
public class LocalTouristAttraction {

	@Id
	@Column(name = "local_tourist_attraction_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer localTouristAttractionId;

	@Column(name = "local_tourist_attraction_place")
	private String localTouristAttractionPlace;

	@Column(name = "booked_date")
	private Date bookedDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "travel_destination_id", updatable = true, insertable = true)
	private Destination travelDestinationId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", updatable = true, insertable = true)
	private User userId;

	public LocalTouristAttraction() {
	}

	public LocalTouristAttraction(Integer localTouristAttractionId, String localTouristAttractionPlace, Date bookedDate,
			Destination travelDestinationId, User userId) {
		super();
		this.localTouristAttractionId = localTouristAttractionId;
		this.localTouristAttractionPlace = localTouristAttractionPlace;
		this.bookedDate = bookedDate;
		this.travelDestinationId = travelDestinationId;
		this.userId = userId;
	}

	public Integer getLocalTouristAttractionId() {
		return localTouristAttractionId;
	}

	public void setLocalTouristAttractionId(Integer localTouristAttractionId) {
		this.localTouristAttractionId = localTouristAttractionId;
	}

	public String getLocalTouristAttractionPlace() {
		return localTouristAttractionPlace;
	}

	public void setLocalTouristAttractionPlace(String localTouristAttractionPlace) {
		this.localTouristAttractionPlace = localTouristAttractionPlace;
	}

	public Date getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}

	public Destination getTravelDestinationId() {
		return travelDestinationId;
	}

	public void setTravelDestinationId(Destination travelDestinationId) {
		this.travelDestinationId = travelDestinationId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookedDate == null) ? 0 : bookedDate.hashCode());
		result = prime * result + ((localTouristAttractionId == null) ? 0 : localTouristAttractionId.hashCode());
		result = prime * result + ((localTouristAttractionPlace == null) ? 0 : localTouristAttractionPlace.hashCode());
		result = prime * result + ((travelDestinationId == null) ? 0 : travelDestinationId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		LocalTouristAttraction other = (LocalTouristAttraction) obj;
		if (bookedDate == null) {
			if (other.bookedDate != null)
				return false;
		} else if (!bookedDate.equals(other.bookedDate))
			return false;
		if (localTouristAttractionId == null) {
			if (other.localTouristAttractionId != null)
				return false;
		} else if (!localTouristAttractionId.equals(other.localTouristAttractionId))
			return false;
		if (localTouristAttractionPlace == null) {
			if (other.localTouristAttractionPlace != null)
				return false;
		} else if (!localTouristAttractionPlace.equals(other.localTouristAttractionPlace))
			return false;
		if (travelDestinationId == null) {
			if (other.travelDestinationId != null)
				return false;
		} else if (!travelDestinationId.equals(other.travelDestinationId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LocalTouristAttraction [localTouristAttractionId=" + localTouristAttractionId
				+ ", localTouristAttractionPlace=" + localTouristAttractionPlace + ", bookedDate=" + bookedDate
				+ ", travelDestinationId=" + travelDestinationId + ", userId=" + userId + "]";
	}

}
