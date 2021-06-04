package com.canoetravel.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "travel_destination")
public class Destination implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "destination_id", columnDefinition = "serial")
	private Integer destinationId;

	@Column(name = "destination_country")
	private String destinationCountry;

	@Column(name = "destination_city")
	private String destinationCity;

	@Column(name = "dest_to_user_id")
	private Integer customerId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dest_to_user_id", updatable = false, insertable = false)
	private User customer;

	@Column(name = "flight_id")
	private Integer flightId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "flight_id", updatable = false, insertable = false)
	private Flight flight;

	@Column(name = "lodging_id")
	private Integer lodgingId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "lodging_id", updatable = false, insertable = false)
	private Lodging lodging;

	@OneToMany(mappedBy = "destinationId", fetch = FetchType.LAZY)
	private List<LocalFood> localFood;

	@OneToMany(mappedBy = "destinationId", fetch = FetchType.LAZY)
	private List<LocalTouristAttraction> localTouristAttraction;

	public Destination() {
	}

	public Destination(Integer destinationId, String destinationCountry, String destinationCity, Integer customerId,
			User customer, Integer flightId, Flight flight, Integer lodgingId, Lodging lodging,
			List<LocalFood> localFood, List<LocalTouristAttraction> localTouristAttraction) {
		super();
		this.destinationId = destinationId;
		this.destinationCountry = destinationCountry;
		this.destinationCity = destinationCity;
		this.customerId = customerId;
		this.customer = customer;
		this.flightId = flightId;
		this.flight = flight;
		this.lodgingId = lodgingId;
		this.lodging = lodging;
		this.localFood = localFood;
		this.localTouristAttraction = localTouristAttraction;
	}

	public Integer getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}

	public String getDestinationCountry() {
		return destinationCountry;
	}

	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Integer getLodgingId() {
		return lodgingId;
	}

	public void setLodgingId(Integer lodgingId) {
		this.lodgingId = lodgingId;
	}

	public Lodging getLodging() {
		return lodging;
	}

	public void setLodging(Lodging lodging) {
		this.lodging = lodging;
	}

	public List<LocalFood> getLocalFood() {
		return localFood;
	}

	public void setLocalFood(List<LocalFood> localFood) {
		this.localFood = localFood;
	}

	public List<LocalTouristAttraction> getLocalTouristAttraction() {
		return localTouristAttraction;
	}

	public void setLocalTouristAttraction(List<LocalTouristAttraction> localTouristAttraction) {
		this.localTouristAttraction = localTouristAttraction;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((destinationCity == null) ? 0 : destinationCity.hashCode());
		result = prime * result + ((destinationCountry == null) ? 0 : destinationCountry.hashCode());
		result = prime * result + ((destinationId == null) ? 0 : destinationId.hashCode());
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + ((flightId == null) ? 0 : flightId.hashCode());
		result = prime * result + ((localFood == null) ? 0 : localFood.hashCode());
		result = prime * result + ((localTouristAttraction == null) ? 0 : localTouristAttraction.hashCode());
		result = prime * result + ((lodging == null) ? 0 : lodging.hashCode());
		result = prime * result + ((lodgingId == null) ? 0 : lodgingId.hashCode());
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
		Destination other = (Destination) obj;
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
		if (destinationCity == null) {
			if (other.destinationCity != null)
				return false;
		} else if (!destinationCity.equals(other.destinationCity))
			return false;
		if (destinationCountry == null) {
			if (other.destinationCountry != null)
				return false;
		} else if (!destinationCountry.equals(other.destinationCountry))
			return false;
		if (destinationId == null) {
			if (other.destinationId != null)
				return false;
		} else if (!destinationId.equals(other.destinationId))
			return false;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (flightId == null) {
			if (other.flightId != null)
				return false;
		} else if (!flightId.equals(other.flightId))
			return false;
		if (localFood == null) {
			if (other.localFood != null)
				return false;
		} else if (!localFood.equals(other.localFood))
			return false;
		if (localTouristAttraction == null) {
			if (other.localTouristAttraction != null)
				return false;
		} else if (!localTouristAttraction.equals(other.localTouristAttraction))
			return false;
		if (lodging == null) {
			if (other.lodging != null)
				return false;
		} else if (!lodging.equals(other.lodging))
			return false;
		if (lodgingId == null) {
			if (other.lodgingId != null)
				return false;
		} else if (!lodgingId.equals(other.lodgingId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Destination [destinationId=" + destinationId + ", destinationCountry=" + destinationCountry
				+ ", destinationCity=" + destinationCity + ", customerId=" + customerId + ", customer=" + customer
				+ ", flightId=" + flightId + ", flight=" + flight + ", lodgingId=" + lodgingId + ", lodging=" + lodging
				+ ", localFood=" + localFood + ", localTouristAttraction=" + localTouristAttraction + "]";
	}

}
