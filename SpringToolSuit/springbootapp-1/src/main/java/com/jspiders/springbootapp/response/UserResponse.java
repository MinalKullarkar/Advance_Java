package com.jspiders.springbootapp.response;

import java.util.List;

import com.jspiders.springbootapp.pojo.User;

import lombok.Data;

@Data
public class UserResponse {

	private String message;
	private User user;
	private List<User> users;
	private int status;
}
