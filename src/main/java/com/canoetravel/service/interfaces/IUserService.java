package com.canoetravel.service.interfaces;

import java.util.List;

import com.canoetravel.entities.User;

public interface IUserService {
	public boolean registerUser(User user);
	public List<User> getAllUsers();
	public User findByLogin(String Login);
	public User findByEmail(String email);
	public User authenticateLogin(String login, String loginPassword);
	public User updateUserInfo(User user);
}
