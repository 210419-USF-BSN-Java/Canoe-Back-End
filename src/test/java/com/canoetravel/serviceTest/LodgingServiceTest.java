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

import com.canoetravel.entities.Lodging;
import com.canoetravel.services.LodgingService;

@RunWith(MockitoJUnitRunner.class)
public class LodgingServiceTest {
	
	private static Lodging lodging1, lodging2;
	private static List<Lodging> lodgingList;

	@Mock
	private static LodgingService lodgingServ;

	@BeforeClass
	public static void setup() {
		lodgingServ = Mockito.mock(LodgingService.class);
		
		lodgingList = new ArrayList<>();
		
		lodging1 = new Lodging(null, "testhotle1", "testAddress1", new Date(0), new Date(0), 100, "rating", 1, 1);
		lodging2 = new Lodging(null, "testhotle2", "testAddress1", new Date(0), new Date(0), 100, "rating", 1, 1);
		lodgingList.add(lodging1);
		lodgingList.add(lodging2);
	}
	
	@Test
	public void saveLodgingTest() {
		Mockito.when(lodgingServ.saveLodging(lodging1)).thenReturn(lodging1);
		assertEquals(lodging1, lodgingServ.saveLodging(lodging1));
	}
	
	@Test
	public void saveLodgingTest1() {
		Mockito.when(lodgingServ.saveLodging(lodging2)).thenReturn(lodging2);
		assertEquals(lodging2, lodgingServ.saveLodging(lodging2));
	}
	
	@Test
	public void getAllLodgingInfo() {
		Mockito.when(lodgingServ.getAllLodgingInfo()).thenReturn(lodgingList);
		assertEquals(2, lodgingServ.getAllLodgingInfo().size());
	}
	
	

}
