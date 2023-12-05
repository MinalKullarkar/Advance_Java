package com.jspiders.onetooneuni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetooneuni.dto.AadharCard;
import com.jspiders.onetooneuni.dto.Person;

public class PersonDAO3 {

	//fetching data
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		//Eager Fetch it will retrive the data of non owning side i.e.AadharCard also
		Person person = entityManager.find(Person.class, 1);
		System.out.println(person);
		
		AadharCard aadharCard = entityManager.find(AadharCard.class, 2);
		System.out.println(aadharCard);
		
		entityTransaction.commit();
		closeConnection();
	}
	public static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("person");
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
