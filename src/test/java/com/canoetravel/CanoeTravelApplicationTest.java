package com.canoetravel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.canoetravel.entities.User;
import com.canoetravel.entities.UserRole;
import com.canoetravel.repository.UserRepository;
import com.canoetravel.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CanoeTravelApplicationTest {
	
	@Autowired
	private UserService userServ;

	@MockBean
	private UserRepository userRepo;

	@Test
	public void registerUserTest() {
		when(userRepo.findAll()).thenReturn(Stream.of(new User(1, "Dev", "Acharya", "email", "dev.acharya","password",true, new UserRole())).collect(Collectors.toList()));
		assertEquals(1, userServ.getAllUsers().size());
	}
}
