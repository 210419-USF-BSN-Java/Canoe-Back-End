package com.canoetravel.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.canoetravel.entities.User;
import com.canoetravel.entities.UserRole;
import com.canoetravel.repository.UserRepository;
import com.canoetravel.services.UserService;


public class UserServiceTest {
	
	@Autowired
	private UserService userServ;

	@MockBean
	private UserRepository userRepo;

	@Test
	public void getAllUsersUserTest() {
		when(userRepo.findAll()).thenReturn(Stream.of(new User(1, "Dev", "Acharya", "email", "dev.acharya","password",true, new UserRole())).collect(Collectors.toList()));
		assertEquals(1, userServ.getAllUsers().size());
	}

}
