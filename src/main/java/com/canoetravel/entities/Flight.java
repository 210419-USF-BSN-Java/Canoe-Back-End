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
public class Flight {

	@Id
	@Column(name = "flight_info_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flight_info_id;

	@Column(name = "flight_no")
	private String flight_no;

	@Column(name = "airline_name")
	private String airline_name;

	@Column(name = "depart_airport")
	private String depart_airport;

	@Column(name = "depart_date")
	private Date depart_date;

	@Column(name = "arrival_airport")
	private String arrival_airport;

	@Column(name = "arrival_date")
	private Date arrival_date;

	@Column(name = "flight_price")
	private double flight_price;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "travel_destination_id", updatable = true, insertable = true)
	private Destination travel_destination_id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", updatable = true, insertable = true)
	private User user_id;

	public Flight() {
	}

	public Flight(Integer flight_info_id, String flight_no, String airline_name, String depart_airport,
			Date depart_date, String arrival_airport, Date arrival_date, double flight_price,
			Destination travel_destination_id, User user_id) {
		super();
		this.flight_info_id = flight_info_id;
		this.flight_no = flight_no;
		this.airline_name = airline_name;
		this.depart_airport = depart_airport;
		this.depart_date = depart_date;
		this.arrival_airport = arrival_airport;
		this.arrival_date = arrival_date;
		this.flight_price = flight_price;
		this.travel_destination_id = travel_destination_id;
		this.user_id = user_id;
	}

	public Integer getFlight_info_id() {
		return flight_info_id;
	}

	public void setFlight_info_id(Integer flight_info_id) {
		this.flight_info_id = flight_info_id;
	}

	public String getFlight_no() {
		return flight_no;
	}

	public void setFlight_no(String flight_no) {
		this.flight_no = flight_no;
	}

	public String getAirline_name() {
		return airline_name;
	}

	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
	}

	public String getDepart_airport() {
		return depart_airport;
	}

	public void setDepart_airport(String depart_airport) {
		this.depart_airport = depart_airport;
	}

	public Date getDepart_date() {
		return depart_date;
	}

	public void setDepart_date(Date depart_date) {
		this.depart_date = depart_date;
	}

	public String getArrival_airport() {
		return arrival_airport;
	}

	public void setArrival_airport(String arrival_airport) {
		this.arrival_airport = arrival_airport;
	}

	public Date getArrival_date() {
		return arrival_date;
	}

	public void setArrival_date(Date arrival_date) {
		this.arrival_date = arrival_date;
	}

	public double getFlight_price() {
		return flight_price;
	}

	public void setFlight_price(double flight_price) {
		this.flight_price = flight_price;
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
		result = prime * result + ((airline_name == null) ? 0 : airline_name.hashCode());
		result = prime * result + ((arrival_airport == null) ? 0 : arrival_airport.hashCode());
		result = prime * result + ((arrival_date == null) ? 0 : arrival_date.hashCode());
		result = prime * result + ((depart_airport == null) ? 0 : depart_airport.hashCode());
		result = prime * result + ((depart_date == null) ? 0 : depart_date.hashCode());
		result = prime * result + ((flight_info_id == null) ? 0 : flight_info_id.hashCode());
		result = prime * result + ((flight_no == null) ? 0 : flight_no.hashCode());
		long temp;
		temp = Double.doubleToLongBits(flight_price);
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
		Flight other = (Flight) obj;
		if (airline_name == null) {
			if (other.airline_name != null)
				return false;
		} else if (!airline_name.equals(other.airline_name))
			return false;
		if (arrival_airport == null) {
			if (other.arrival_airport != null)
				return false;
		} else if (!arrival_airport.equals(other.arrival_airport))
			return false;
		if (arrival_date == null) {
			if (other.arrival_date != null)
				return false;
		} else if (!arrival_date.equals(other.arrival_date))
			return false;
		if (depart_airport == null) {
			if (other.depart_airport != null)
				return false;
		} else if (!depart_airport.equals(other.depart_airport))
			return false;
		if (depart_date == null) {
			if (other.depart_date != null)
				return false;
		} else if (!depart_date.equals(other.depart_date))
			return false;
		if (flight_info_id == null) {
			if (other.flight_info_id != null)
				return false;
		} else if (!flight_info_id.equals(other.flight_info_id))
			return false;
		if (flight_no == null) {
			if (other.flight_no != null)
				return false;
		} else if (!flight_no.equals(other.flight_no))
			return false;
		if (Double.doubleToLongBits(flight_price) != Double.doubleToLongBits(other.flight_price))
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
		return "Flight [flight_info_id=" + flight_info_id + ", flight_no=" + flight_no + ", airline_name="
				+ airline_name + ", depart_airport=" + depart_airport + ", depart_date=" + depart_date
				+ ", arrival_airport=" + arrival_airport + ", arrival_date=" + arrival_date + ", flight_price="
				+ flight_price + ", travel_destination_id=" + travel_destination_id + ", user_id=" + user_id + "]";
	}

}
