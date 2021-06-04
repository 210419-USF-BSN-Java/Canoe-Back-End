package com.canoetravel.serviceTest;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.canoetravel.entities.LocalFood;
import com.canoetravel.services.FoodService;

@RunWith(MockitoJUnitRunner.class)
public class FoodServiceTest {
	
	private static LocalFood localFood1, localFood2;
	private static List<LocalFood> localFoodList;

	@Mock
	private static FoodService foodServ;

	@BeforeClass
	public static void setup() {
		foodServ = Mockito.mock(FoodService.class);

	}

}
