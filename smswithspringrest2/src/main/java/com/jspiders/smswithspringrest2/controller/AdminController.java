package com.jspiders.smswithspringrest2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jspiders.smswithspringrest2.pojo.Admin;
import com.jspiders.smswithspringrest2.response.AdminResponse;
import com.jspiders.smswithspringrest2.service.AdminService;


@Controller
@ResponseBody
public class AdminController {

	@Autowired
	private AdminService adminService;	
	
	@PostMapping(path="admin",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse> addAdmin(@RequestBody Admin admin){
		Admin addAdmin = adminService.addAdmin(admin);
		AdminResponse adminResponse=new AdminResponse();
		adminResponse.setMessage("Sign Up");
		adminResponse.setAdmin(addAdmin);
		adminResponse.setStatus(HttpStatus.CREATED.value());
		
		return new ResponseEntity<AdminResponse>(adminResponse,HttpStatus.CREATED);
	}
	
	@PostMapping(path="login",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse> logIn(@RequestBody Admin admin){
	 Admin	adminToBeLoggedInWithPassEmail=adminService.logIn(admin);
		if (adminToBeLoggedInWithPassEmail!=null) {
			AdminResponse adminResponse=new AdminResponse();
			adminResponse.setMessage("Logged In");
			adminResponse.setAdmin(adminToBeLoggedInWithPassEmail);
			adminResponse.setStatus(HttpStatus.FOUND.value());
			
			return new  ResponseEntity<AdminResponse>(adminResponse,HttpStatus.FOUND);
		}
		else {
			AdminResponse adminResponse=new AdminResponse();
			adminResponse.setMessage("Envalid email or password");
			adminResponse.setAdmin(null);
			adminResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<AdminResponse>(adminResponse,HttpStatus.NOT_FOUND);
		}
		
	}
	
}
