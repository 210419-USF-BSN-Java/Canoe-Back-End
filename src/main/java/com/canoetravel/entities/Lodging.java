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
@Table(name = "lodging_info")
public class Lodging {

	@Id
	@Column(name = "lodging_info_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer lodgingInfoId;

	@Column(name = "hotel_name")
	private String hotel_name;

	@Column(name = "check_in_date")
	private Date checkInDate;

	@Column(name = "check_out_date")
	private Date checkOutDate;

	@Column(name = "per_night_price")
	private double pernightPrice;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "travel_destination_id", updatable = true, insertable = true)
	private Destination travelDestinationId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", updatable = true, insertable = true)
	private User userId;

	public Lodging() {
	}

	public Lodging(Integer lodgingInfoId, String hotel_name, Date checkInDate, Date checkOutDate, double pernightPrice,
			Destination travelDestinationId, User userId) {
		super();
		this.lodgingInfoId = lodgingInfoId;
		this.hotel_name = hotel_name;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.pernightPrice = pernightPrice;
		this.travelDestinationId = travelDestinationId;
		this.userId = userId;
	}

	public Integer getLodgingInfoId() {
		return lodgingInfoId;
	}

	public void setLodgingInfoId(Integer lodgingInfoId) {
		this.lodgingInfoId = lodgingInfoId;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
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

	public double getPernightPrice() {
		return pernightPrice;
	}

	public void setPernightPrice(double pernightPrice) {
		this.pernightPrice = pernightPrice;
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
		result = prime * result + ((checkInDate == null) ? 0 : checkInDate.hashCode());
		result = prime * result + ((checkOutDate == null) ? 0 : checkOutDate.hashCode());
		result = prime * result + ((hotel_name == null) ? 0 : hotel_name.hashCode());
		result = prime * result + ((lodgingInfoId == null) ? 0 : lodgingInfoId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pernightPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (hotel_name == null) {
			if (other.hotel_name != null)
				return false;
		} else if (!hotel_name.equals(other.hotel_name))
			return false;
		if (lodgingInfoId == null) {
			if (other.lodgingInfoId != null)
				return false;
		} else if (!lodgingInfoId.equals(other.lodgingInfoId))
			return false;
		if (Double.doubleToLongBits(pernightPrice) != Double.doubleToLongBits(other.pernightPrice))
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
		return "Lodging [lodgingInfoId=" + lodgingInfoId + ", hotel_name=" + hotel_name + ", checkInDate=" + checkInDate
				+ ", checkOutDate=" + checkOutDate + ", pernightPrice=" + pernightPrice + ", travelDestinationId="
				+ travelDestinationId + ", userId=" + userId + "]";
	}

}
