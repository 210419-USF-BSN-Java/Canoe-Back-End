package com.canoetravel.entities;

import java.io.Serializable;
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
public class LocalFood implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer localFoodId;

	@Column(name = "local_food_name")
	private String locaFoodName;

	@Column(name = "restaurant_name")
	private String restaurantName;

	@Column(name = "booked_date")
	private Date bookedDate;

	@Column(name = "user_id")
	private Integer customerId;

	@Column(name = "travel_destination_id")
	private Integer destinationId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "travel_destination_id", updatable = false, insertable = false)
	private Destination destination;

	public LocalFood() {
	}

	public LocalFood(Integer localFoodId, String locaFoodName, String restaurantName, Date bookedDate,
			Integer customerId, Integer destinationId) {
		super();
		this.localFoodId = localFoodId;
		this.locaFoodName = locaFoodName;
		this.restaurantName = restaurantName;
		this.bookedDate = bookedDate;
		this.customerId = customerId;
		this.destinationId = destinationId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookedDate == null) ? 0 : bookedDate.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((destinationId == null) ? 0 : destinationId.hashCode());
		result = prime * result + ((locaFoodName == null) ? 0 : locaFoodName.hashCode());
		result = prime * result + ((localFoodId == null) ? 0 : localFoodId.hashCode());
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
		return true;
	}

	@Override
	public String toString() {
		return "LocalFood [localFoodId=" + localFoodId + ", locaFoodName=" + locaFoodName + ", restaurantName="
				+ restaurantName + ", bookedDate=" + bookedDate + ", customerId=" + customerId + ", destinationId="
				+ destinationId + "]";
	}

}
