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
@Table(name = "local_food_info")
public class LocalFood {

	@Id
	@Column(name = "local_food_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer local_food_id;

	@Column(name = "local_food_name")
	private String local_food_name;

	@Column(name = "restaurant_name")
	private String restaurant_name;

	@Column(name = "booked_date")
	private Date booked_date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "travel_destination_id", updatable = true, insertable = true)
	private Destination travel_destination_id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", updatable = true, insertable = true)
	private User user_id;

	public LocalFood() {
	}

	public LocalFood(Integer local_food_id, String local_food_name, String restaurant_name, Date booked_date,
			Destination travel_destination_id, User user_id) {
		super();
		this.local_food_id = local_food_id;
		this.local_food_name = local_food_name;
		this.restaurant_name = restaurant_name;
		this.booked_date = booked_date;
		this.travel_destination_id = travel_destination_id;
		this.user_id = user_id;
	}

	public Integer getLocal_food_id() {
		return local_food_id;
	}

	public void setLocal_food_id(Integer local_food_id) {
		this.local_food_id = local_food_id;
	}

	public String getLocal_food_name() {
		return local_food_name;
	}

	public void setLocal_food_name(String local_food_name) {
		this.local_food_name = local_food_name;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public Date getBooked_date() {
		return booked_date;
	}

	public void setBooked_date(Date booked_date) {
		this.booked_date = booked_date;
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
		result = prime * result + ((booked_date == null) ? 0 : booked_date.hashCode());
		result = prime * result + ((local_food_id == null) ? 0 : local_food_id.hashCode());
		result = prime * result + ((local_food_name == null) ? 0 : local_food_name.hashCode());
		result = prime * result + ((restaurant_name == null) ? 0 : restaurant_name.hashCode());
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
		LocalFood other = (LocalFood) obj;
		if (booked_date == null) {
			if (other.booked_date != null)
				return false;
		} else if (!booked_date.equals(other.booked_date))
			return false;
		if (local_food_id == null) {
			if (other.local_food_id != null)
				return false;
		} else if (!local_food_id.equals(other.local_food_id))
			return false;
		if (local_food_name == null) {
			if (other.local_food_name != null)
				return false;
		} else if (!local_food_name.equals(other.local_food_name))
			return false;
		if (restaurant_name == null) {
			if (other.restaurant_name != null)
				return false;
		} else if (!restaurant_name.equals(other.restaurant_name))
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
		return "LocalFood [local_food_id=" + local_food_id + ", local_food_name=" + local_food_name
				+ ", restaurant_name=" + restaurant_name + ", booked_date=" + booked_date + ", travel_destination_id="
				+ travel_destination_id + ", user_id=" + user_id + "]";
	}

}
