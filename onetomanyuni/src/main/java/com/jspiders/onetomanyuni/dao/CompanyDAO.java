package com.jspiders.onetomanyuni.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomanyuni.dto.Company;
import com.jspiders.onetomanyuni.dto.Employee;

public class CompanyDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
		Employee employee1=new Employee();
		employee1.setName("Aarya");
		employee1.setEmail("aarya@gmail.com");
		employee1.setSalary(50000);
		//if we use mapping attribute as @OnetoMany(cascade=CascadeType.PERSIST)
		//we need not to persist every employee each time.
		//entityManager.persist(employee1);
		
		Employee employee2=new Employee();
		employee2.setName("Pranay");
		employee2.setEmail("pranay@gmail.com");
		employee2.setSalary(40000);
		//entityManager.persist(employee2);
		
		Company company=new Company();
		company.setName("Tata");
		company.setAddress("Pune");
		company.setEmployees(Arrays.asList(employee1,employee2));
		entityManager.persist(company);
		
		entityTransaction.commit();
		closeConnection();
	}
	
	public static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("company");
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
