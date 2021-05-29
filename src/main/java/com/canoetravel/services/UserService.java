package com.canoetravel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canoetravel.entities.User;
import com.canoetravel.entities.UserRole;
import com.canoetravel.repository.UserRepository;
import com.canoetravel.repository.UserRoleRepository;

@Service
public class UserService {
	
	private UserRepository userRepo;
	private UserRoleRepository uRoleRepo;

	public UserService() {
		
	}
	
	@Autowired
	public UserService(UserRepository userRepo, UserRoleRepository uRoleRepo) {
		this.userRepo = userRepo;
		this.uRoleRepo = uRoleRepo;
	}
	
	public boolean registerUser(User user) {
		try {
			UserRole userRole = uRoleRepo.findByUserRole("user");
			user.setUserRoleId(userRole);
			user.setActive(true);
			userRepo.save(user);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public List<User> getAllUsers(){
		try {
			System.out.println("==============================================");
			System.out.println(userRepo.findAll());
			return userRepo.findAll();
		}catch(Exception e) {
			return null;
		}
	}

}
