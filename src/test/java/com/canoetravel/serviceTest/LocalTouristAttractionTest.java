package com.canoetravel.serviceTest;

import java.util.List;

import org.junit.BeforeClass;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.canoetravel.entities.LocalTouristAttraction;
import com.canoetravel.services.TouristAttractionService;

public class LocalTouristAttractionTest {
	
	private static LocalTouristAttraction localTouristAttraction1, localTouristAttraction12;
	private static List<LocalTouristAttraction> localTouristAttractionList;

	@Mock
	private static TouristAttractionService localTouristAttractionListServ;

	@BeforeClass
	public static void setup() {
		localTouristAttractionListServ = Mockito.mock(TouristAttractionService.class);

	}

}
