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
@Table(name = "flight_info")
public class Lodging {

	@Id
	@Column(name = "lodging_info_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer lodging_info_id;

	@Column(name = "hotel_name")
	private String hotel_name;

	@Column(name = "check_in_date")
	private Date check_in_date;

	@Column(name = "check_out_date")
	private Date check_out_date;

	@Column(name = "per_night_price")
	private double per_night_price;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "travel_destination_id", updatable = true, insertable = true)
	private Destination travel_destination_id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", updatable = true, insertable = true)
	private User user_id;

	public Lodging() {
	}

	public Lodging(Integer lodging_info_id, String hotel_name, Date check_in_date, Date check_out_date,
			double per_night_price, Destination travel_destination_id, User user_id) {
		super();
		this.lodging_info_id = lodging_info_id;
		this.hotel_name = hotel_name;
		this.check_in_date = check_in_date;
		this.check_out_date = check_out_date;
		this.per_night_price = per_night_price;
		this.travel_destination_id = travel_destination_id;
		this.user_id = user_id;
	}

	public Integer getLodging_info_id() {
		return lodging_info_id;
	}

	public void setLodging_info_id(Integer lodging_info_id) {
		this.lodging_info_id = lodging_info_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public Date getCheck_in_date() {
		return check_in_date;
	}

	public void setCheck_in_date(Date check_in_date) {
		this.check_in_date = check_in_date;
	}

	public Date getCheck_out_date() {
		return check_out_date;
	}

	public void setCheck_out_date(Date check_out_date) {
		this.check_out_date = check_out_date;
	}

	public double getPer_night_price() {
		return per_night_price;
	}

	public void setPer_night_price(double per_night_price) {
		this.per_night_price = per_night_price;
	}

	public Destination getTravel_destination_id() {
		return travel_destination_id;
	}

	public void setTravel_destination_id(Destination travel_destination_id) {
		this.travel_destination_id = travel_destination_id;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((check_in_date == null) ? 0 : check_in_date.hashCode());
		result = prime * result + ((check_out_date == null) ? 0 : check_out_date.hashCode());
		result = prime * result + ((hotel_name == null) ? 0 : hotel_name.hashCode());
		result = prime * result + ((lodging_info_id == null) ? 0 : lodging_info_id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(per_night_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((travel_destination_id == null) ? 0 : travel_destination_id.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
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
		if (check_in_date == null) {
			if (other.check_in_date != null)
				return false;
		} else if (!check_in_date.equals(other.check_in_date))
			return false;
		if (check_out_date == null) {
			if (other.check_out_date != null)
				return false;
		} else if (!check_out_date.equals(other.check_out_date))
			return false;
		if (hotel_name == null) {
			if (other.hotel_name != null)
				return false;
		} else if (!hotel_name.equals(other.hotel_name))
			return false;
		if (lodging_info_id == null) {
			if (other.lodging_info_id != null)
				return false;
		} else if (!lodging_info_id.equals(other.lodging_info_id))
			return false;
		if (Double.doubleToLongBits(per_night_price) != Double.doubleToLongBits(other.per_night_price))
			return false;
		if (travel_destination_id == null) {
			if (other.travel_destination_id != null)
				return false;
		} else if (!travel_destination_id.equals(other.travel_destination_id))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lodging [lodging_info_id=" + lodging_info_id + ", hotel_name=" + hotel_name + ", check_in_date="
				+ check_in_date + ", check_out_date=" + check_out_date + ", per_night_price=" + per_night_price
				+ ", travel_destination_id=" + travel_destination_id + ", user_id=" + user_id + "]";
	}

}
