package com.canoetravel.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "lodging_info")
public class Lodging {

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.AUTO)
	private LodgingId lodgingId;

	@Column(name = "hotel_name")
	private String hotel_name;

	@Column(name = "check_in_date")
	private Date checkInDate;

	@Column(name = "check_out_date")
	private Date checkOutDate;

	@Column(name = "per_night_price")
	private double pernightPrice;

	public Lodging() {
	}

	public Lodging(LodgingId lodgingId, String hotel_name, Date checkInDate, Date checkOutDate, double pernightPrice) {
		super();
		this.lodgingId = lodgingId;
		this.hotel_name = hotel_name;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.pernightPrice = pernightPrice;
	}

	public LodgingId getLodgingId() {
		return lodgingId;
	}

	public void setLodgingId(LodgingId lodgingId) {
		this.lodgingId = lodgingId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkInDate == null) ? 0 : checkInDate.hashCode());
		result = prime * result + ((checkOutDate == null) ? 0 : checkOutDate.hashCode());
		result = prime * result + ((hotel_name == null) ? 0 : hotel_name.hashCode());
		result = prime * result + ((lodgingId == null) ? 0 : lodgingId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pernightPrice);
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
		if (hotel_name == null) {
			if (other.hotel_name != null)
				return false;
		} else if (!hotel_name.equals(other.hotel_name))
			return false;
		if (lodgingId == null) {
			if (other.lodgingId != null)
				return false;
		} else if (!lodgingId.equals(other.lodgingId))
			return false;
		if (Double.doubleToLongBits(pernightPrice) != Double.doubleToLongBits(other.pernightPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lodging [lodgingId=" + lodgingId + ", hotel_name=" + hotel_name + ", checkInDate=" + checkInDate
				+ ", checkOutDate=" + checkOutDate + ", pernightPrice=" + pernightPrice + "]";
	}

}
