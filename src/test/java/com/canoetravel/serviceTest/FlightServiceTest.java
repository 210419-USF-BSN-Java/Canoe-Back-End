package com.canoetravel.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.canoetravel.entities.Flight;
import com.canoetravel.services.FlightService;

@RunWith(MockitoJUnitRunner.class)
public class FlightServiceTest {
	
	private static Flight flight1, flight2;
	private static List<Flight> flightList;

	@Mock
	private static FlightService flightServ;

	@BeforeClass
	public static void setup() {
		flightServ = Mockito.mock(FlightService.class);
		
		flightList = new ArrayList<>();
		
		flight1 = new Flight(null, "1234", "testAirline", "testDepart", new Date(0), "testArrivalAirport", new Date(0),  123, 1, 1);
		flight2 = new Flight(null, "123", "testAirline1", "testDepart1", new Date(0), "testArrivalAirport", new Date(0),  123, 2, 2);
		flightList.add(flight1);
		flightList.add(flight2);
	}
	
	@Test
	public void saveFlightTest() {
		Mockito.when(flightServ.saveFlight(flight1)).thenReturn(flight1);
		assertEquals(flight1, flightServ.saveFlight(flight1));
	}
	
	@Test
	public void saveFlightTest1() {
		Mockito.when(flightServ.saveFlight(flight2)).thenReturn(flight2);
		assertEquals(flight2, flightServ.saveFlight(flight2));
	}
	
	@Test
	public void getAllFlightTest() {
		Mockito.when(flightServ.getAllFlight()).thenReturn(flightList);
		assertEquals(2, flightServ.getAllFlight().size());
	}

}
