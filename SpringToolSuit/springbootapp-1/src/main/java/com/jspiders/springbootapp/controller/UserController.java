package com.jspiders.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.jspiders.springbootapp.pojo.User;
import com.jspiders.springbootapp.response.UserResponse;
import com.jspiders.springbootapp.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/user")
	public ResponseEntity<UserResponse> addUser(@RequestBody User user){
		User addUser = userService.addUser(user);
		UserResponse userResponse=new UserResponse();
		if (addUser!=null) {
			userResponse.setMessage("User SignUp");
			userResponse.setUser(addUser);
			userResponse.setUsers(null);
			userResponse.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
		}
		else {
			userResponse.setMessage("Error");
			userResponse.setUser(null);
			userResponse.setUsers(null);
			userResponse.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
		}
	}
	
	@GetMapping(path = "/user_in")
	public ResponseEntity<UserResponse> logIn(@RequestParam String name, @RequestParam String password){
		User user=userService.findByNameAndPassword(name,password);
		UserResponse userResponse=new UserResponse();
		if (user!=null) {
			userResponse.setMessage("User Logged In");
			userResponse.setUser(user);
			userResponse.setUsers(null);
			userResponse.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<UserResponse>(userResponse, HttpStatus.FOUND);
		}
		else {
			userResponse.setMessage("Invalid credentials");
			userResponse.setUser(null);
			userResponse.setUsers(null);
			userResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<UserResponse>(userResponse, HttpStatus.NOT_FOUND);
		}
		
		
	}
}
