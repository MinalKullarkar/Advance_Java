package com.jspiders.onetooneuni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetooneuni.dto.AadharCard;
import com.jspiders.onetooneuni.dto.Person;

public class PersonDAO2 {

	//Delete 
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		//first we have to delete source entity
		Person person = entityManager.find(Person.class, 3);
		entityManager.remove(person);
		
		//then we have to remove target entiyt(non owning side)
		AadharCard aadharCard = entityManager.find(AadharCard.class, 3);
		entityManager.remove(aadharCard);
		
	
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
