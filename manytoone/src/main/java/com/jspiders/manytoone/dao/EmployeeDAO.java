package com.jspiders.manytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoone.dto.Company;
import com.jspiders.manytoone.dto.Employee;

public class EmployeeDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
		Company company=new Company();
		company.setName("Tata");
		company.setAddress("Pune");
		entityManager.persist(company);
		
		Employee employee1=new Employee();
		employee1.setName("Shin");
		employee1.setEmail("shin@gmail.com");
		employee1.setSalary(20000);
		employee1.setCompany(company);
		entityManager.persist(employee1);
		
		Employee employee2=new Employee();
		employee2.setName("MinHoo");
		employee2.setEmail("minhoo@gmail.com");
		employee2.setSalary(30000);
		employee2.setCompany(company);
		entityManager.persist(employee2);
		
		
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
