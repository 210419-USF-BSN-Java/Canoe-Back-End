package com.canoetravel.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canoetravel.entities.User;
import com.canoetravel.services.UserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService serv) {
		this.userService = serv;
	}

	@PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> registerUser(@RequestBody User user) {

		if (userService.findByLogin(user.getUserLogin()) != null) {
			return new ResponseEntity<String>("{\"message\":  \" Username already exists\"}", HttpStatus.BAD_REQUEST);
		} else if (userService.findByEmail(user.getUserEmail()) != null) {
			return new ResponseEntity<String>("{\"message\":  \" Email already exists\"}", HttpStatus.BAD_REQUEST);
		} else {
			userService.registerUser(user);
			return new ResponseEntity<String>("{\"message\":  \" User has been created\"}", HttpStatus.OK);
		}
	}

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> authenticateLogin(@RequestBody User user, HttpServletRequest req) {

		User authUser = userService.authenticateLogin(user.getUserLogin(), user.getUserLoginPassword());

		if (authUser != null && authUser.isActive() == true) {
			HttpSession userSession = req.getSession();
			userSession.setAttribute("authUser", authUser);
			return new ResponseEntity<User>(authUser, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@DeleteMapping (value="/logout")
	public ResponseEntity<Void> invalidateSession(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping
	public ResponseEntity<User> checkLogin(HttpSession session) {
		User authUser = (User) session.getAttribute("authUser");
		if (authUser == null) {
			return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
		} 
		return new ResponseEntity<User>(authUser, HttpStatus.OK);
	}
	
	// TODO below code is Just for testing purpose need to delete or secured for employee/admin user only
	@GetMapping(value = "/allusers")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
	}
	
	@PostMapping(value = "/updateuser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateUserInfo(@RequestBody User user, HttpServletRequest req) {
		System.out.println(user);
		User authUser = userService.updateUserInfo(user);
		System.out.println("authUser is " + authUser);
		if(authUser != null) {
		return new ResponseEntity<String>("user updated succesfully", HttpStatus.OK);
		} else {
		return new ResponseEntity<String>("unable to update the user", HttpStatus.BAD_REQUEST);
		}
	

//		if (authUser != null && authUser.isActive() == true) {
//			HttpSession userSession = req.getSession();
//			userSession.setAttribute("authUser", authUser);
//			return new ResponseEntity<User>(authUser, HttpStatus.ACCEPTED);
//		} else {
//			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
//		}
	}

}
