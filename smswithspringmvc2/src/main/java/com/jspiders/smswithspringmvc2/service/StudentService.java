package com.jspiders.smswithspringmvc2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.smswithspringmvc2.pojo.StudentPOJO;
import com.jspiders.smswithspringmvc2.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public void addStudent(String name, String email, long mobile, byte age) {
		StudentPOJO studentPOJO=new StudentPOJO();
		studentPOJO.setName(name);
		studentPOJO.setEmail(email);
		studentPOJO.setMoblie(mobile);
		studentPOJO.setAge(age);
		
		studentRepository.addStudent(studentPOJO);
	}

	public List<StudentPOJO> getAllStudents() {
		
		List<StudentPOJO> students = studentRepository.getAllStudents();
		return students;	
	}

	public String deleteStudent(long id) {
		StudentPOJO studentToBeDeleted=null;
		List<StudentPOJO> students = studentRepository.getAllStudents();
		for (StudentPOJO student : students) {
			if (student.getId()==id) {
				studentToBeDeleted=student;
				break;
			}	
		}
		if (studentToBeDeleted==null) {
			return "student not found";
		}
		else {
			studentRepository.deleteStudent(studentToBeDeleted);
			return "Student Deleted";
		}
	}
	public StudentPOJO editStudent(long id) {
		StudentPOJO studentToBeUpdated = null;
		List<StudentPOJO> students = studentRepository.getAllStudents();
		for (StudentPOJO student : students) {
			if (student.getId() == id) {
				studentToBeUpdated = student;
				break;
			}
		}
		return studentToBeUpdated;
	}
	

	public void updateStudent(long id, String name, String email, long mobile, byte age) {
		StudentPOJO studentPOJO = studentRepository.getStudentById(id);
		studentPOJO.setName(name);
		studentPOJO.setEmail(email);
		studentPOJO.setMoblie(mobile);;
		studentPOJO.setAge(age);
		studentRepository.addStudent(studentPOJO);
		
	}

	public List<StudentPOJO> searchStudentByPattern(String pattern) {
		return studentRepository.searchStudentByPattern(pattern);
	}

	public List<StudentPOJO> searchStudentById(int id) {
		return studentRepository.searchStudentById(id);
	}
	

}
