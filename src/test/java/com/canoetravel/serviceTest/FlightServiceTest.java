package com.canoetravel.serviceTest;

import java.util.List;

import org.junit.BeforeClass;
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

	}

}
