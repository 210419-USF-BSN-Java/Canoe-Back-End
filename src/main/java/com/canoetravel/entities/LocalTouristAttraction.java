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
@Table(name = "local_tourist_attraction")
public class LocalTouristAttraction {

	@Id
	@Column(name = "local_tourist_attraction_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer local_tourist_attraction_id;

	@Column(name = "local_tourist_attraction_place")
	private String local_tourist_attraction_place;

	@Column(name = "booked_date")
	private Date booked_date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "travel_destination_id", updatable = true, insertable = true)
	private Destination travel_destination_id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", updatable = true, insertable = true)
	private User user_id;

	public LocalTouristAttraction() {
	}

	public LocalTouristAttraction(Integer local_tourist_attraction_id, String local_tourist_attraction_place,
			Date booked_date, Destination travel_destination_id, User user_id) {
		super();
		this.local_tourist_attraction_id = local_tourist_attraction_id;
		this.local_tourist_attraction_place = local_tourist_attraction_place;
		this.booked_date = booked_date;
		this.travel_destination_id = travel_destination_id;
		this.user_id = user_id;
	}

	public Integer getLocal_tourist_attraction_id() {
		return local_tourist_attraction_id;
	}

	public void setLocal_tourist_attraction_id(Integer local_tourist_attraction_id) {
		this.local_tourist_attraction_id = local_tourist_attraction_id;
	}

	public String getLocal_tourist_attraction_place() {
		return local_tourist_attraction_place;
	}

	public void setLocal_tourist_attraction_place(String local_tourist_attraction_place) {
		this.local_tourist_attraction_place = local_tourist_attraction_place;
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
		result = prime * result + ((local_tourist_attraction_id == null) ? 0 : local_tourist_attraction_id.hashCode());
		result = prime * result
				+ ((local_tourist_attraction_place == null) ? 0 : local_tourist_attraction_place.hashCode());
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
		LocalTouristAttraction other = (LocalTouristAttraction) obj;
		if (booked_date == null) {
			if (other.booked_date != null)
				return false;
		} else if (!booked_date.equals(other.booked_date))
			return false;
		if (local_tourist_attraction_id == null) {
			if (other.local_tourist_attraction_id != null)
				return false;
		} else if (!local_tourist_attraction_id.equals(other.local_tourist_attraction_id))
			return false;
		if (local_tourist_attraction_place == null) {
			if (other.local_tourist_attraction_place != null)
				return false;
		} else if (!local_tourist_attraction_place.equals(other.local_tourist_attraction_place))
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
		return "LocalTouristAttraction [local_tourist_attraction_id=" + local_tourist_attraction_id
				+ ", local_tourist_attraction_place=" + local_tourist_attraction_place + ", booked_date=" + booked_date
				+ ", travel_destination_id=" + travel_destination_id + ", user_id=" + user_id + "]";
	}

}
