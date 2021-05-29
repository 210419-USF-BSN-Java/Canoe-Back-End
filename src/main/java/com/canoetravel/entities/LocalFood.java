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
	private Integer localFoodId;

	@Column(name = "local_food_name")
	private String locaFoodName;

	@Column(name = "restaurant_name")
	private String restaurantName;

	@Column(name = "booked_date")
	private Date bookedDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "travel_destination_id", updatable = true, insertable = true)
	private Destination travelDestinationId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", updatable = true, insertable = true)
	private User userId;

	public LocalFood() {
	}

	public LocalFood(Integer localFoodId, String locaFoodName, String restaurantName, Date bookedDate,
			Destination travelDestinationId, User userId) {
		super();
		this.localFoodId = localFoodId;
		this.locaFoodName = locaFoodName;
		this.restaurantName = restaurantName;
		this.bookedDate = bookedDate;
		this.travelDestinationId = travelDestinationId;
		this.userId = userId;
	}

	public Integer getLocalFoodId() {
		return localFoodId;
	}

	public void setLocalFoodId(Integer localFoodId) {
		this.localFoodId = localFoodId;
	}

	public String getLocaFoodName() {
		return locaFoodName;
	}

	public void setLocaFoodName(String locaFoodName) {
		this.locaFoodName = locaFoodName;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
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
		result = prime * result + ((locaFoodName == null) ? 0 : locaFoodName.hashCode());
		result = prime * result + ((localFoodId == null) ? 0 : localFoodId.hashCode());
		result = prime * result + ((restaurantName == null) ? 0 : restaurantName.hashCode());
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
		LocalFood other = (LocalFood) obj;
		if (bookedDate == null) {
			if (other.bookedDate != null)
				return false;
		} else if (!bookedDate.equals(other.bookedDate))
			return false;
		if (locaFoodName == null) {
			if (other.locaFoodName != null)
				return false;
		} else if (!locaFoodName.equals(other.locaFoodName))
			return false;
		if (localFoodId == null) {
			if (other.localFoodId != null)
				return false;
		} else if (!localFoodId.equals(other.localFoodId))
			return false;
		if (restaurantName == null) {
			if (other.restaurantName != null)
				return false;
		} else if (!restaurantName.equals(other.restaurantName))
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
		return "LocalFood [localFoodId=" + localFoodId + ", locaFoodName=" + locaFoodName + ", restaurantName="
				+ restaurantName + ", bookedDate=" + bookedDate + ", travelDestinationId=" + travelDestinationId
				+ ", userId=" + userId + "]";
	}

}
