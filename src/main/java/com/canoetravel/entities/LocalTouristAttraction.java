package com.canoetravel.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "local_tourist_attraction")
public class LocalTouristAttraction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer localTouristAttaraction;

	@Column(name = "local_tourist_attraction_place")
	private String localTouristAttractionPlace;

	@Column(name = "booked_date")
	private Date bookedDate;

	@Column(name = "user_id")
	private Integer customerId;

	@Column(name = "travel_destination_id")
	private Integer destinationId;

	public LocalTouristAttraction() {
	}

	public LocalTouristAttraction(Integer localTouristAttaraction, String localTouristAttractionPlace, Date bookedDate,
			Integer customerId, Integer destinationId) {
		super();
		this.localTouristAttaraction = localTouristAttaraction;
		this.localTouristAttractionPlace = localTouristAttractionPlace;
		this.bookedDate = bookedDate;
		this.customerId = customerId;
		this.destinationId = destinationId;
	}

	public Integer getLocalTouristAttaraction() {
		return localTouristAttaraction;
	}

	public void setLocalTouristAttaraction(Integer localTouristAttaraction) {
		this.localTouristAttaraction = localTouristAttaraction;
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

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookedDate == null) ? 0 : bookedDate.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((destinationId == null) ? 0 : destinationId.hashCode());
		result = prime * result + ((localTouristAttaraction == null) ? 0 : localTouristAttaraction.hashCode());
		result = prime * result + ((localTouristAttractionPlace == null) ? 0 : localTouristAttractionPlace.hashCode());
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
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (destinationId == null) {
			if (other.destinationId != null)
				return false;
		} else if (!destinationId.equals(other.destinationId))
			return false;
		if (localTouristAttaraction == null) {
			if (other.localTouristAttaraction != null)
				return false;
		} else if (!localTouristAttaraction.equals(other.localTouristAttaraction))
			return false;
		if (localTouristAttractionPlace == null) {
			if (other.localTouristAttractionPlace != null)
				return false;
		} else if (!localTouristAttractionPlace.equals(other.localTouristAttractionPlace))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LocalTouristAttraction [localTouristAttaraction=" + localTouristAttaraction
				+ ", localTouristAttractionPlace=" + localTouristAttractionPlace + ", bookedDate=" + bookedDate
				+ ", customerId=" + customerId + ", destinationId=" + destinationId + "]";
	}

}
