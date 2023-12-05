package com.jspiders.onetooneuni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.onetooneuni.dto.Person;

public class PersonDAO5 {

	//fetching multiple objects using JPQL
		private static EntityManagerFactory entityManagerFactory;
		private static EntityManager entityManager;
		private static EntityTransaction entityTransaction;
		
		public static void main(String[] args) {
			
			openConnection();
			entityTransaction.begin();
			
			Query query = entityManager.createQuery("SELECT person FROM Person person");
			
			@SuppressWarnings("unchecked")
			List<Person> persons=query.getResultList();
			for (Person person : persons) {
				System.out.println(person);
			}
			
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
