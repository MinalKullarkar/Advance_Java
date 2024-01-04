package com.jspiders.smswithspringrest2.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.smswithspringrest2.pojo.Admin;

@Repository
public class AdminRepository {
	@Autowired
	EntityManager entityManager;

	public Admin addAdmin(Admin admin) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(admin);
		
		entityTransaction.commit();
		return admin;
	}

	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdmins() {
		Query query=entityManager.createQuery("select admin from Admin as admin");
		List<Admin> admins = query.getResultList();
		return admins;
	}

}
