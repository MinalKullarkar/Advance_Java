package com.jspiders.smswithspringrest2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.smswithspringrest2.pojo.Admin;
import com.jspiders.smswithspringrest2.repository.AdminRepository;



@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public Admin addAdmin(Admin admin) {
		return adminRepository.addAdmin(admin);
	}

	public List<Admin> getAllAdmins() {
		return adminRepository.getAllAdmins();
		
	}
	
	
	
	
}
