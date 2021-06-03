package com.canoetravel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class LocalFoodId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "local_food_id")
	private Integer localFoodId;
	
	/* @ManyToOne(fetch = FetchType.EAGER)
	
	@JoinColumns({
			@JoinColumn(name = "travel_destination_id", referencedColumnName = "destination_id", updatable = true, insertable = true),
			@JoinColumn(name = "user_id", referencedColumnName = "dest_to_user_id", updatable = true, insertable = true) })
	private Destination travelDestinationId;

	public LocalFoodId(Integer localFoodId, Destination travelDestinationId) {
		super();
		this.localFoodId = localFoodId;
		this.travelDestinationId = travelDestinationId;
	}

	public Integer getLocalFoodId() {
		return localFoodId;
	}

	public void setLocalFoodId(Integer localFoodId) {
		this.localFoodId = localFoodId;
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
		result = prime * result + ((localFoodId == null) ? 0 : localFoodId.hashCode());
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
		LocalFoodId other = (LocalFoodId) obj;
		if (localFoodId == null) {
			if (other.localFoodId != null)
				return false;
		} else if (!localFoodId.equals(other.localFoodId))
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
		return "LocalFoodId [localFoodId=" + localFoodId + ", travelDestinationId=" + travelDestinationId + "]";
	}
*/
}
