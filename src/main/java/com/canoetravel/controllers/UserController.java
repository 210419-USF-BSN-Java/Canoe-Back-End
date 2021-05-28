package com.canoetravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canoetravel.entities.User;
import com.canoetravel.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService serv) {
		this.userService = serv;
	}
	
	@PostMapping(value="/signup")
	public boolean registerUser(@RequestBody User user){
		return userService.registerUser(user);
	}

}
