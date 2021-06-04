package com.canoetravel.serviceTest;

import java.util.List;

import org.junit.BeforeClass;
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

	}

}
