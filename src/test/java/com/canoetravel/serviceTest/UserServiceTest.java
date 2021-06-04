package com.canoetravel.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.canoetravel.entities.User;
import com.canoetravel.entities.UserRole;
import com.canoetravel.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@Mock
	private UserService userServ;

	@Test
	public void getAllUsersUserTest() {
		userServ = Mockito.mock(UserService.class);
		List<User> userList = new ArrayList<>();
		User user1 = new User(1, "Dev", "Acharya", "email", "dev.acharya","password",true, new UserRole());
		userList.add(user1);
		Mockito.when(userServ.registerUser(user1)).thenReturn(true);
		assertEquals(true, userServ.registerUser(user1));
	}

}
