package com.canoetravel.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.canoetravel.entities.User;
import com.canoetravel.services.UserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://canoe-front.s3-website.us-east-2.amazonaws.com/")
@SessionAttributes("authUser")
public class UserController {

	private static Logger log = LogManager.getLogger(UserController.class);
	private UserService userService;
	private HttpSession session=null;
	public static User loginUser;


	@Autowired
	public UserController(UserService serv) {
		this.userService = serv;
	}

	@PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> registerUser(@RequestBody User user) {

		if (userService.findByUserLogin(user.getUserLogin()) != null) {
			log.warn("Username already exitst");
			return new ResponseEntity<String>("{\"message\":  \" Username already exists\"}", HttpStatus.BAD_REQUEST);
		} else if (userService.findByEmail(user.getUserEmail()) != null) {
			log.warn("Email already exitst");
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
			log.info("login success");
			loginUser = authUser;
			req.getSession().setAttribute("authUser", authUser);
			return new ResponseEntity<User>(authUser, HttpStatus.ACCEPTED);
		} else {
			log.warn("unauthorized login");
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
	}

	@DeleteMapping(value = "/logout")
	public ResponseEntity<Void> invalidateSession(HttpSession session) {
		log.warn("User information invalidated");
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/allusers")
	public ResponseEntity<List<User>> getAllUsers() {
		log.warn("returning all users data");
		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
	}

	@PutMapping(value = "/updateuser")
	public ResponseEntity<String> updateUserInfo(@RequestBody User user, HttpServletRequest req) {
		
// 			User sessionUser = (User) session.getAttribute("authUser");
		User sessionUser= loginUser;
		if (sessionUser != null) {

			if (!user.getUserFname().equalsIgnoreCase(null) && !user.getUserFname().isEmpty()) {
				sessionUser.setUserFname(user.getUserFname());
			}
			if (!user.getUserLname().equalsIgnoreCase(null) && !user.getUserLname().isEmpty()) {
				sessionUser.setUserLname(user.getUserLname());
			}
			if (!user.getUserEmail().equalsIgnoreCase(null) && !user.getUserEmail().isEmpty()) {
				sessionUser.setUserEmail(user.getUserEmail());
			}

			User updatedUser = userService.updateUserInfo(sessionUser);
			if (!updatedUser.equals(null)) {
				session.setAttribute("authUser", updatedUser);
				return new ResponseEntity<String>("user updated succesfully", HttpStatus.OK);
			} else {
				log.warn("Unable to update user information");
				return new ResponseEntity<String>("unable to update the user", HttpStatus.BAD_REQUEST);
			}
		} else {
			log.warn("Unable to find user session informationm");
			return new ResponseEntity<String>("Please Login or SignUp for account", HttpStatus.UNAUTHORIZED);

		}
	}
	
	@GetMapping(value = "/getUserByEmail/{email}", produces = "application/json")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
		User user = userService.findByEmail(email);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}else {
			log.warn("Unable to get user");
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
	}
	
	
	@GetMapping(value = "/getUser/{UserLogin}", produces = "application/json")
    public ResponseEntity<User> getUserByLogin(@PathVariable String UserLogin) {
		User user = userService.findByUserLogin(UserLogin);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}else {
			log.warn("Unable to get user");
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
	}
}
