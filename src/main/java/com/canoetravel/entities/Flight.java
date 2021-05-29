package com.canoetravel.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "flight_info")
public class Flight {

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.AUTO)
	private FlightId flightId;

	@Column(name = "flight_no")
	private String flightNo;

	@Column(name = "airline_name")
	private String airlineName;

	@Column(name = "depart_airport")
	private String departAirport;

	@Column(name = "depart_date")
	private Date departDate;

	@Column(name = "arrival_airport")
	private String arrivalAirport;

	@Column(name = "arrival_date")
	private Date arrivalDate;

	@Column(name = "flight_price")
	private double flightPrice;

	public Flight() {
	}

	public Flight(FlightId flightId, String flightNo, String airlineName, String departAirport, Date departDate,
			String arrivalAirport, Date arrivalDate, double flightPrice) {
		super();
		this.flightId = flightId;
		this.flightNo = flightNo;
		this.airlineName = airlineName;
		this.departAirport = departAirport;
		this.departDate = departDate;
		this.arrivalAirport = arrivalAirport;
		this.arrivalDate = arrivalDate;
		this.flightPrice = flightPrice;
	}

	public FlightId getFlightId() {
		return flightId;
	}

	public void setFlightId(FlightId flightId) {
		this.flightId = flightId;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getDepartAirport() {
		return departAirport;
	}

	public void setDepartAirport(String departAirport) {
		this.departAirport = departAirport;
	}

	public Date getDepartDate() {
		return departDate;
	}

	public void setDepartDate(Date departDate) {
		this.departDate = departDate;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public double getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(double flightPrice) {
		this.flightPrice = flightPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airlineName == null) ? 0 : airlineName.hashCode());
		result = prime * result + ((arrivalAirport == null) ? 0 : arrivalAirport.hashCode());
		result = prime * result + ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
		result = prime * result + ((departAirport == null) ? 0 : departAirport.hashCode());
		result = prime * result + ((departDate == null) ? 0 : departDate.hashCode());
		result = prime * result + ((flightId == null) ? 0 : flightId.hashCode());
		result = prime * result + ((flightNo == null) ? 0 : flightNo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(flightPrice);
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
		Flight other = (Flight) obj;
		if (airlineName == null) {
			if (other.airlineName != null)
				return false;
		} else if (!airlineName.equals(other.airlineName))
			return false;
		if (arrivalAirport == null) {
			if (other.arrivalAirport != null)
				return false;
		} else if (!arrivalAirport.equals(other.arrivalAirport))
			return false;
		if (arrivalDate == null) {
			if (other.arrivalDate != null)
				return false;
		} else if (!arrivalDate.equals(other.arrivalDate))
			return false;
		if (departAirport == null) {
			if (other.departAirport != null)
				return false;
		} else if (!departAirport.equals(other.departAirport))
			return false;
		if (departDate == null) {
			if (other.departDate != null)
				return false;
		} else if (!departDate.equals(other.departDate))
			return false;
		if (flightId == null) {
			if (other.flightId != null)
				return false;
		} else if (!flightId.equals(other.flightId))
			return false;
		if (flightNo == null) {
			if (other.flightNo != null)
				return false;
		} else if (!flightNo.equals(other.flightNo))
			return false;
		if (Double.doubleToLongBits(flightPrice) != Double.doubleToLongBits(other.flightPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightNo=" + flightNo + ", airlineName=" + airlineName
				+ ", departAirport=" + departAirport + ", departDate=" + departDate + ", arrivalAirport="
				+ arrivalAirport + ", arrivalDate=" + arrivalDate + ", flightPrice=" + flightPrice + "]";
	}

}
