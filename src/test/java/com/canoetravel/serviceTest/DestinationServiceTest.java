package com.canoetravel.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.canoetravel.entities.Destination;
import com.canoetravel.entities.Flight;
import com.canoetravel.entities.Lodging;
import com.canoetravel.entities.User;
import com.canoetravel.services.DestinationService;

@RunWith(MockitoJUnitRunner.class)
public class DestinationServiceTest {

	private static Destination dest1, dest2;
	private static List<Destination> destList;

	@Mock
	private static DestinationService destServ;

	@BeforeClass
	public static void setup() {
		destServ = Mockito.mock(DestinationService.class);
		
		destList = new ArrayList<>();
		dest1 = new Destination(null, "testCountry", 1,  new User(), 1, new Flight(), 1, new Lodging(), null, null);
		dest2 = new Destination(null, "testCountry1",  1, new User(), 1, new Flight(), 1, new Lodging(), null, null);
		destList.add(dest1);
		destList.add(dest2);
	}
	
	@Test
	public void saveDestinationTest() {
		Mockito.when(destServ.saveDestination(dest1)).thenReturn(dest1);
		assertEquals(dest1, destServ.saveDestination(dest1));
	}
	
	@Test
	public void getAllDestinationTest() {
		Mockito.when(destServ.getAllDestination()).thenReturn(destList);
		assertEquals(2, destServ.getAllDestination().size());
	}
	
	@Test
	public void updateDestioantionTest() {
		dest1.setDestination("updatedDestination");
		Mockito.when(destServ.updateDestination(dest1)).thenReturn(dest1);
		assertEquals("updatedDestination", destServ.updateDestination(dest1).getDestination());
	}
}
