package com.jspiders.onetooneuni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetooneuni.dto.AadharCard;
import com.jspiders.onetooneuni.dto.Person;

public class PersonDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		//Insert
		openConnection();
		entityTransaction.begin();
		
		AadharCard aadharCard=new AadharCard();
		aadharCard.setAadharNumber(789654897);
		entityManager.persist(aadharCard);
		
		Person person=new Person();
		person.setName("Minal");
		person.setEmail("minal@gmail.com");
		person.setAadharCard(aadharCard);
		entityManager.persist(person);
		
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
