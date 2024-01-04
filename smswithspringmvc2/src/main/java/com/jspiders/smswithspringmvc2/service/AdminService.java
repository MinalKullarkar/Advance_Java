package com.jspiders.smswithspringmvc2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.smswithspringmvc2.pojo.AdminPOJO;
import com.jspiders.smswithspringmvc2.repository.AdminRepository;


@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	public void addAdmin(String userName, String email, String password) {
		AdminPOJO adminPOJO=new AdminPOJO();
		adminPOJO.setUserName(userName);
		adminPOJO.setEmail(email);
		adminPOJO.setPassword(password);
		adminRepository.addAdmin(adminPOJO);
		
	}
	public AdminPOJO logIn(String email, String password) {
		AdminPOJO adminToBeLoggedIn=null;
		List<AdminPOJO> admins=adminRepository.getAllAdmins();
		for(AdminPOJO admin:admins) {
			if(admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
				adminToBeLoggedIn=admin;
				break;
			}
		}
		return adminToBeLoggedIn;
	}
	public List<AdminPOJO> getAllAdmin(){
		return adminRepository.getAllAdmins();
	}
	public void deleteAdmin(String email) {
		AdminPOJO adminToBeDeleted = null;
		List<AdminPOJO> admins = adminRepository.getAllAdmins();
		for (AdminPOJO admin : admins) {
			if (admin.getEmail().equals(email)) {
				adminToBeDeleted = admin;
			}
		}
		adminRepository.deleteAdmin(adminToBeDeleted);
	}
	
	
}
