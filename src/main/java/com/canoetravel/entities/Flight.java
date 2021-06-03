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
//@IdClass(FlightId.class)
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "flight_info_id", columnDefinition = "serial")
	private Integer flightInfoId;

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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", updatable = false, insertable = false)
	private User customer;

	@Column(name = "user_id")
	private Integer customerId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "travel_destination_id", updatable = false, insertable = false)
	private Destination destination;

	@Column(name = "travel_destination_id")
	private Integer destinationId;

	public Flight() {
	}

	public Flight(Integer flightInfoId, String flightNo, String airlineName, String departAirport, Date departDate,
			String arrivalAirport, Date arrivalDate, double flightPrice, User customer, Integer customerId,
			Destination destination, Integer destinationId) {
		super();
		this.flightInfoId = flightInfoId;
		this.flightNo = flightNo;
		this.airlineName = airlineName;
		this.departAirport = departAirport;
		this.departDate = departDate;
		this.arrivalAirport = arrivalAirport;
		this.arrivalDate = arrivalDate;
		this.flightPrice = flightPrice;
		this.customer = customer;
		this.customerId = customerId;
		this.destination = destination;
		this.destinationId = destinationId;
	}

	public Integer getFlightInfoId() {
		return flightInfoId;
	}

	public void setFlightInfoId(Integer flightInfoId) {
		this.flightInfoId = flightInfoId;
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

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Integer getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airlineName == null) ? 0 : airlineName.hashCode());
		result = prime * result + ((arrivalAirport == null) ? 0 : arrivalAirport.hashCode());
		result = prime * result + ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((departAirport == null) ? 0 : departAirport.hashCode());
		result = prime * result + ((departDate == null) ? 0 : departDate.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((destinationId == null) ? 0 : destinationId.hashCode());
		result = prime * result + ((flightInfoId == null) ? 0 : flightInfoId.hashCode());
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
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
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
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (destinationId == null) {
			if (other.destinationId != null)
				return false;
		} else if (!destinationId.equals(other.destinationId))
			return false;
		if (flightInfoId == null) {
			if (other.flightInfoId != null)
				return false;
		} else if (!flightInfoId.equals(other.flightInfoId))
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
		return "Flight [flightInfoId=" + flightInfoId + ", flightNo=" + flightNo + ", airlineName=" + airlineName
				+ ", departAirport=" + departAirport + ", departDate=" + departDate + ", arrivalAirport="
				+ arrivalAirport + ", arrivalDate=" + arrivalDate + ", flightPrice=" + flightPrice + ", customer="
				+ customer + ", customerId=" + customerId + ", destination=" + destination + ", destinationId="
				+ destinationId + "]";
	}

}
