package com.jspiders.springbootapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springbootapp.pojo.User;
import com.jspiders.springbootapp.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public User addUser(User user) {
		return userRepo.save(user);	
	}


	public User findByNameAndPassword(String name, String password) {
		return userRepo.findByNameAndPassword(name,password);
	}

	
	
	
}
