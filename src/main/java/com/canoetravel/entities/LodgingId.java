package com.canoetravel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class LodgingId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "lodging_info_id")
	private Integer lodgingInfoId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
			@JoinColumn(name = "travel_destination_id", referencedColumnName = "destination_id", updatable = true, insertable = true),
			@JoinColumn(name = "user_id", referencedColumnName = "dest_to_user_id", updatable = true, insertable = true) })
	private Destination travelDestinationId;

	
	public LodgingId(Integer lodgingInfoId, Destination travelDestinationId) {
		super();
		this.lodgingInfoId = lodgingInfoId;
		this.travelDestinationId = travelDestinationId;
	}

	public Integer getLodgingInfoId() {
		return lodgingInfoId;
	}

	public void setLodgingInfoId(Integer lodgingInfoId) {
		this.lodgingInfoId = lodgingInfoId;
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
		result = prime * result + ((lodgingInfoId == null) ? 0 : lodgingInfoId.hashCode());
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
		LodgingId other = (LodgingId) obj;
		if (lodgingInfoId == null) {
			if (other.lodgingInfoId != null)
				return false;
		} else if (!lodgingInfoId.equals(other.lodgingInfoId))
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
		return "LodgingId [lodgingInfoId=" + lodgingInfoId + ", travelDestinationId=" + travelDestinationId + "]";
	}
}
