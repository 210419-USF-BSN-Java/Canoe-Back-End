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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer localFood;

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

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "destination_id", updatable = false, insertable = false)
	private Destination destinatioId;

	public LocalFood() {
	}

	public LocalFood(Integer localFood, String locaFoodName, String restaurantName, Date bookedDate, Integer customerId,
			Integer destinationId, Destination destinatioId) {
		super();
		this.localFood = localFood;
		this.locaFoodName = locaFoodName;
		this.restaurantName = restaurantName;
		this.bookedDate = bookedDate;
		this.customerId = customerId;
		this.destinationId = destinationId;
		this.destinatioId = destinatioId;
	}

	public Integer getLocalFood() {
		return localFood;
	}

	public void setLocalFood(Integer localFood) {
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

	public Destination getDestinatioId() {
		return destinatioId;
	}

	public void setDestinatioId(Destination destinatioId) {
		this.destinatioId = destinatioId;
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
		result = prime * result + ((destinatioId == null) ? 0 : destinatioId.hashCode());
		result = prime * result + ((destinationId == null) ? 0 : destinationId.hashCode());
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
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (destinatioId == null) {
			if (other.destinatioId != null)
				return false;
		} else if (!destinatioId.equals(other.destinatioId))
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
				+ restaurantName + ", bookedDate=" + bookedDate + ", customerId=" + customerId + ", destinationId="
				+ destinationId + ", destinatioId=" + destinatioId + "]";
	}

}
