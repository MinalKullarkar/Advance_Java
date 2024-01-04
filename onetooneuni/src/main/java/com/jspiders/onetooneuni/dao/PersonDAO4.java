package com.jspiders.onetooneuni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetooneuni.dto.AadharCard;
import com.jspiders.onetooneuni.dto.Person;

public class PersonDAO4 {

	//Update
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		//Update
		Person person = entityManager.find(Person.class, 1);
		person.setEmail("pranaykullarkar@gmail.com");
		entityManager.persist(person);

		
		AadharCard aadharCard = entityManager.find(AadharCard.class, 2);
		aadharCard.setAadharNumber(1234556789);
		entityManager.persist(aadharCard);
		
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
