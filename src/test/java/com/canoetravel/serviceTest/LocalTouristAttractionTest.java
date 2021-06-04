package com.canoetravel.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.canoetravel.entities.LocalTouristAttraction;
import com.canoetravel.services.TouristAttractionService;

public class LocalTouristAttractionTest {
	
	private static LocalTouristAttraction localTouristAttraction1, localTouristAttraction2;
	private static List<LocalTouristAttraction> localTouristAttractionList;

	@Mock
	private static TouristAttractionService localTouristAttractionListServ;

	@BeforeClass
	public static void setup() {
		localTouristAttractionListServ = Mockito.mock(TouristAttractionService.class);
		
		localTouristAttractionList = new ArrayList<>();
		
		localTouristAttraction1 = new LocalTouristAttraction(null, "testLocalAttraction", new Date(0), 1, 1);
		localTouristAttraction2 = new LocalTouristAttraction(null, "testLocalAttraction1", new Date(0), 1, 1);
		localTouristAttractionList.add(localTouristAttraction1);
		localTouristAttractionList.add(localTouristAttraction2);
	}
	
	@Test
	public void saveLocalAttraction() {
		Mockito.when(localTouristAttractionListServ.saveLocalTouristAttraction(localTouristAttraction1)).thenReturn(localTouristAttraction1);
		assertEquals(localTouristAttraction1, localTouristAttractionListServ.saveLocalTouristAttraction(localTouristAttraction1));
	}
	
	@Test
	public void saveLocalAttraction1() {
		Mockito.when(localTouristAttractionListServ.saveLocalTouristAttraction(localTouristAttraction2)).thenReturn(localTouristAttraction2);
		assertEquals(localTouristAttraction2, localTouristAttractionListServ.saveLocalTouristAttraction(localTouristAttraction2));
	}
	
	@Test
	public void getAllTouristAttractionsTest() {
		Mockito.when(localTouristAttractionListServ.getAllTouristAttractions()).thenReturn(localTouristAttractionList);
		assertEquals(2, localTouristAttractionListServ.getAllTouristAttractions().size());
	}

}
