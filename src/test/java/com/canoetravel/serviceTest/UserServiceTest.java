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

import com.canoetravel.entities.User;
import com.canoetravel.entities.UserRole;
import com.canoetravel.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	private static User user1, user2;
	private static List<User> userList;
	
	@Mock
	private static UserService userServ;
	
	
	@BeforeClass
	public static void setup() {
		userServ = Mockito.mock(UserService.class);
		userList = new ArrayList<>();
		user1 = new User(1, "testfname", "testlname", "testemail", "testlogin","testloginpassword",true, new UserRole());
		user2 = new User(2, "testfname1", "testlname1", "testemail1", "testlogin1","testloginpassword1",true, new UserRole());
		userList.add(user1);
		userList.add(user2);	
	}

	@Test
	public void registerUserTest() {
		Mockito.when(userServ.registerUser(user1)).thenReturn(true);
		assertEquals(true, userServ.registerUser(user1));
	}
	
	@Test
	public void registerUserTest1() {
		Mockito.when(userServ.registerUser(null)).thenReturn(false);
		assertEquals(false, userServ.registerUser(null));
	}
	
	@Test
	public void getAllUser() {
		Mockito.when(userServ.getAllUsers()).thenReturn(userList);
		assertEquals(2, userServ.getAllUsers().size());
	}
	
	@Test
	public void authenticateLoginTest() {
		Mockito.when(userServ.authenticateLogin(user1.getUserLogin(), user1.getUserLoginPassword())).thenReturn(user1);
		assertEquals(user1, userServ.authenticateLogin(user1.getUserLogin(), user1.getUserLoginPassword()));
	}
	
	@Test
	public void authenticateLoginTest1() {
		Mockito.when(userServ.authenticateLogin(user2.getUserLogin(), user2.getUserLoginPassword())).thenReturn(user2);
		assertEquals(user2, userServ.authenticateLogin(user2.getUserLogin(), user2.getUserLoginPassword()));
	}
	
	@Test
	public void authenticateLoginTest2() {
		Mockito.when(userServ.authenticateLogin("wronglogin", "wrongpassword")).thenReturn(null);
		assertEquals(null, userServ.authenticateLogin("wronglogin", "wrongpassword"));
	}
	
	@Test
	public void updateUserInfoTest() {
		user1.setUserEmail("updatetest@emai.com");
		Mockito.when(userServ.updateUserInfo(user1)).thenReturn(user1);
		assertEquals("updatetest@emai.com", userServ.updateUserInfo(user1).getUserEmail());
	}
	
	@Test
	public void updateUserInfoTest1() {
		user2.setUserFname("updateUserFnameTest");
		Mockito.when(userServ.updateUserInfo(user2)).thenReturn(user2);
		assertEquals("updateUserFnameTest", userServ.updateUserInfo(user2).getUserFname());
	}
	
	@Test
	public void findByEmailTest() {
		Mockito.when(userServ.findByEmail(user2.getUserEmail())).thenReturn(user2);
		assertEquals(user2, userServ.findByEmail("testemail1"));
	}
	
	@Test
	public void findByEmailTest1() {
		Mockito.when(userServ.findByEmail("wrongEmail")).thenReturn(null);
		assertEquals(null, userServ.findByEmail("wrongEmail"));
	}

}
