package com.jspiders.manytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoone.dto.Employee;

public class EmployeeDAO4 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
		//Update
		Employee employee = entityManager.find(Employee.class, 1);
		employee.setName("ShinGumHee");
		employee.setEmail("gumhee@gmail.com");
		entityManager.persist(employee);
		
		entityTransaction.commit();
		closeConnection();
		
	}
	public static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("employee");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	public static void closeConnection() {
		if (entityManagerFactory!=null) {
			entityManagerFactory.close();
		}
		if (entityManager!=null) {
			entityManager.close();
		}
		if (entityTransaction!=null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
}
