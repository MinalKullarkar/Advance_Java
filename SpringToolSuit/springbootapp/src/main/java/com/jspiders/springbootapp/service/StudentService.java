package com.jspiders.springbootapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springbootapp.pojo.Student;
import com.jspiders.springbootapp.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;

	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}

	public Student findStudentById(long id) {
		 Optional<Student> optional = studentRepo.findById(id);
		 if (optional.isPresent()) {
			return optional.get();
		}
		 else {
			 return null;
		 }
		
	}

	public Student deleteStudentById(long id) {
		Student student = findStudentById(id);
		studentRepo.deleteById(id);
		return student;
	}

	public Student updateStudent(Student student) {
		studentRepo.save(student);
		return student;
	}

	public Student findStudentByMobile(long mobile) {
		return studentRepo.findByMobile(mobile);
		
	}

	public List<Student> getAllStudents() {
		List<Student> allStudents = studentRepo.findAll();
		return allStudents;
	}

	public Student getStudentByEmailAndName(String email, String name) {
		return  studentRepo.findByEmailAndName(email,name);
		
	}
	
	
	

}
