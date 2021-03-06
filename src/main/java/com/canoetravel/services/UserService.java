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

	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public boolean registerUser(User user) {
		if (user != null) {
			UserRole userRole = uRoleRepo.findByUserRole("user");
			user.setUserRoleId(userRole);
			user.setActive(true);
			User isSaved = userRepo.save(user);
			if (isSaved != null) {

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public List<User> getAllUsers() {
		return userRepo.findAll();

	}

	public User findByLogin(String Login) {
		return userRepo.findByUserLogin(Login);
	}

	public User findByEmail(String email) {
		return userRepo.findByUserEmail(email);
	}

	public User authenticateLogin(String login, String loginPassword) {
		return userRepo.findByUserLoginAndUserLoginPassword(login, loginPassword);
	}

	public User updateUserInfo(User user) {
		return userRepo.save(user);
	}

}
