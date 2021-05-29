package com.canoetravel.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "local_food_info")
public class LocalFood {

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.AUTO)
	private LocalFoodId localFood;

	@Column(name = "local_food_name")
	private String locaFoodName;

	@Column(name = "restaurant_name")
	private String restaurantName;

	@Column(name = "booked_date")
	private Date bookedDate;

	public LocalFood() {
	}

	public LocalFood(LocalFoodId localFood, String locaFoodName, String restaurantName, Date bookedDate) {
		super();
		this.localFood = localFood;
		this.locaFoodName = locaFoodName;
		this.restaurantName = restaurantName;
		this.bookedDate = bookedDate;
	}

	public LocalFoodId getLocalFood() {
		return localFood;
	}

	public void setLocalFood(LocalFoodId localFood) {
		this.localFood = localFood;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookedDate == null) ? 0 : bookedDate.hashCode());
		result = prime * result + ((locaFoodName == null) ? 0 : locaFoodName.hashCode());
		result = prime * result + ((localFood == null) ? 0 : localFood.hashCode());
		result = prime * result + ((restaurantName == null) ? 0 : restaurantName.hashCode());
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
		if (localFood == null) {
			if (other.localFood != null)
				return false;
		} else if (!localFood.equals(other.localFood))
			return false;
		if (restaurantName == null) {
			if (other.restaurantName != null)
				return false;
		} else if (!restaurantName.equals(other.restaurantName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LocalFood [localFood=" + localFood + ", locaFoodName=" + locaFoodName + ", restaurantName="
				+ restaurantName + ", bookedDate=" + bookedDate + "]";
	}

}
