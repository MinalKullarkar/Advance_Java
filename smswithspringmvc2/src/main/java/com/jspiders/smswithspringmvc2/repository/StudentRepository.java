package com.jspiders.smswithspringmvc2.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jspiders.smswithspringmvc2.pojo.StudentPOJO;

@Repository
public class StudentRepository {

	@Autowired
	private EntityManager entityManager;

	public void addStudent(StudentPOJO studentPOJO) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(studentPOJO);
		
		entityTransaction.commit();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<StudentPOJO> getAllStudents(){
		
		
		
		Query query=entityManager.createQuery("select student from StudentPOJO student");
		return  query.getResultList();
			
	}
	public void deleteStudent(StudentPOJO studentPOJO) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.remove(studentPOJO);
		
		entityTransaction.commit();
		
	}

	
	public StudentPOJO getStudentById(long id) {
		return entityManager.find(StudentPOJO.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<StudentPOJO> searchStudentByPattern(String pattern) {
		Query query = entityManager
				.createQuery("SELECT student FROM StudentPOJO student WHERE name LIKE '%" + pattern + "%'");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<StudentPOJO> searchStudentById(int id) {
		Query query=entityManager.createQuery("SELECT student FROM StudentPOJO student WHERE id='"+id+"' ");
		return query.getResultList();
	}
	
}
