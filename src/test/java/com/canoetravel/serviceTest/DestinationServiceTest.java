package com.canoetravel.serviceTest;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.canoetravel.entities.Destination;
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

	}
}
