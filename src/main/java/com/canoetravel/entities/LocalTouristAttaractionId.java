package com.canoetravel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class LocalTouristAttaractionId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "local_tourist_attraction_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer localTouristAttractionId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
			@JoinColumn(name = "travel_destination_id", referencedColumnName = "destination_id", updatable = true, insertable = true),
			@JoinColumn(name = "user_id", referencedColumnName = "user_id", updatable = true, insertable = true) })
	private Destination travelDestinationId;

	public LocalTouristAttaractionId(Integer localTouristAttractionId, Destination travelDestinationId) {
		super();
		this.localTouristAttractionId = localTouristAttractionId;
		this.travelDestinationId = travelDestinationId;
	}

	public Integer getLocalTouristAttractionId() {
		return localTouristAttractionId;
	}

	public void setLocalTouristAttractionId(Integer localTouristAttractionId) {
		this.localTouristAttractionId = localTouristAttractionId;
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
		result = prime * result + ((localTouristAttractionId == null) ? 0 : localTouristAttractionId.hashCode());
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
		LocalTouristAttaractionId other = (LocalTouristAttaractionId) obj;
		if (localTouristAttractionId == null) {
			if (other.localTouristAttractionId != null)
				return false;
		} else if (!localTouristAttractionId.equals(other.localTouristAttractionId))
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
		return "LocalTouristAttaractionId [localTouristAttractionId=" + localTouristAttractionId
				+ ", travelDestinationId=" + travelDestinationId + "]";
	}

}
