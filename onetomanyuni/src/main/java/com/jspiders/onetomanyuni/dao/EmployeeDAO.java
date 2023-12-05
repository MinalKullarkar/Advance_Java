package com.jspiders.onetomanyuni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomanyuni.dto.Company;
import com.jspiders.onetomanyuni.dto.Employee;

public class EmployeeDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
		Company company = entityManager.find(Company.class, 1);
		List<Employee> employees=company.getEmployees();
		//If we get the concurrentModification exception then use this extra 
		//variable.
		Employee deleteEmployee=null;
		for (Employee employee : employees) {
			if (employee.getId()==2) {
				deleteEmployee=employee;
			}
		}
		employees.remove(deleteEmployee);
		
		company.setEmployees(employees);
		entityManager.persist(company);
		
		Employee employee = entityManager.find(Employee.class, 2);
		entityManager.remove(employee);
		
		
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
