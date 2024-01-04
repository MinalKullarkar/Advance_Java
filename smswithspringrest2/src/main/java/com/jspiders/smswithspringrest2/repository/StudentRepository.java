package com.jspiders.smswithspringrest2.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.border.EtchedBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.smswithspringrest2.pojo.Student;

@Repository
public class StudentRepository {

	
	@Autowired
	private EntityManager entityManager;
	
	
	public Student addStudent(Student student) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(student);
		
		entityTransaction.commit();
		return student;
	}
	
	public List<Student> getAllStudents() {
		Query query=entityManager.createQuery("Select student from Student student");
		@SuppressWarnings("unchecked")
		List<Student> students = query.getResultList();
		return students;
	}


	public Student getStudentById(long id) {
		
	  return entityManager.find(Student.class, id);
	}


	public Student deleteStudent(long id) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
		Student student = getStudentById(id);
		entityManager.remove(student);
		
		entityTransaction.commit();
		
		return student;
	}


}
