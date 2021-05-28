package com.canoetravel.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.canoetravel.entities.User;
import com.canoetravel.repository.UserRepository;

public class UserService {
	
	private UserRepository userRepo;

	public UserService() {
		
	}
	
	@Autowired
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public boolean registerUser(User user) {
		try {
			userRepo.save(user);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

}
