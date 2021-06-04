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
		
		localFoodList = new ArrayList<>();
		localFood1 = new LocalFood(null, "testLocalFood", "testResturant", new Date(0), 1, 1);
		localFood2 = new LocalFood(null, "testLocalFood", "testResturant", new Date(0), 1, 1);
		localFoodList.add(localFood1);
		localFoodList.add(localFood2);
	}
	
	@Test
	public void saveLocalFood() {
		Mockito.when(foodServ.saveLocalFood(localFood1)).thenReturn(localFood1);
		assertEquals(localFood1, foodServ.saveLocalFood(localFood1));
	}
	
	@Test
	public void saveLocalFood1() {
		Mockito.when(foodServ.saveLocalFood(localFood2)).thenReturn(localFood2);
		assertEquals(localFood2, foodServ.saveLocalFood(localFood2));
	}
	
	@Test
	public void getAllLocalFood() {
		Mockito.when(foodServ.getAllLocalFood()).thenReturn(localFoodList);
		assertEquals(2, foodServ.getAllLocalFood().size());
	}

}
