package com.canoetravel.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lodging_info")
public class Lodging {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer lodgingId;

	@Column(name = "hotelName")
	private String hotelName;

	@Column(name = "check_in_date")
	private Date checkInDate;

	@Column(name = "check_out_date")
	private Date checkOutDate;

	@Column(name = "per_night_price")
	private double pricePerNight;

	@Column(name = "user_id")
	private Integer customerId;

	@Column(name = "travel_destination_id")
	private Integer destinationId;

	public Lodging() {
	}

	public Lodging(Integer lodgingId, String hotelName, Date checkInDate, Date checkOutDate, double pricePerNight,
			Integer customerId, Integer destinationId) {
		super();
		this.lodgingId = lodgingId;
		this.hotelName = hotelName;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.pricePerNight = pricePerNight;
		this.customerId = customerId;
		this.destinationId = destinationId;
	}

	public Integer getLodgingId() {
		return lodgingId;
	}

	public void setLodgingId(Integer lodgingId) {
		this.lodgingId = lodgingId;
	}

	public String gethotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
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
		result = prime * result + ((checkInDate == null) ? 0 : checkInDate.hashCode());
		result = prime * result + ((checkOutDate == null) ? 0 : checkOutDate.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((destinationId == null) ? 0 : destinationId.hashCode());
		result = prime * result + ((hotelName == null) ? 0 : hotelName.hashCode());
		result = prime * result + ((lodgingId == null) ? 0 : lodgingId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pricePerNight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Lodging other = (Lodging) obj;
		if (checkInDate == null) {
			if (other.checkInDate != null)
				return false;
		} else if (!checkInDate.equals(other.checkInDate))
			return false;
		if (checkOutDate == null) {
			if (other.checkOutDate != null)
				return false;
		} else if (!checkOutDate.equals(other.checkOutDate))
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
		if (hotelName == null) {
			if (other.hotelName != null)
				return false;
		} else if (!hotelName.equals(other.hotelName))
			return false;
		if (lodgingId == null) {
			if (other.lodgingId != null)
				return false;
		} else if (!lodgingId.equals(other.lodgingId))
			return false;
		if (Double.doubleToLongBits(pricePerNight) != Double.doubleToLongBits(other.pricePerNight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lodging [lodgingId=" + lodgingId + ", hotelName=" + hotelName + ", checkInDate=" + checkInDate
				+ ", checkOutDate=" + checkOutDate + ", pernightPrice=" + pricePerNight + ", customerId=" + customerId
				+ ", destinationId=" + destinationId + "]";
	}

}
