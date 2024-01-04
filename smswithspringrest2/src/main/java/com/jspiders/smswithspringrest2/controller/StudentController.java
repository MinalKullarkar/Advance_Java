package com.jspiders.smswithspringrest2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jspiders.smswithspringrest2.pojo.Student;
import com.jspiders.smswithspringrest2.response.StudentResponse;
import com.jspiders.smswithspringrest2.service.StudentService;

@Controller
@ResponseBody
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping(path = "/student",consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> addStudent(@RequestBody Student student) {
		Student addStudent=studentService.addStudent(student);
		StudentResponse studentResponse=new StudentResponse();
		studentResponse.setMessage("Student Added");
		studentResponse.setStudent(addStudent);
		studentResponse.setStudents(null);
		studentResponse.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.FOUND);
	}
	
	@GetMapping(path = "/students",produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> getAllStudents(){
		List<Student> students=studentService.getAllStudents();
		if (students!=null && students.size()>0) {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("Students Fetched");
			studentResponse.setStudent(null);
			studentResponse.setStudents(students);
			studentResponse.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.FOUND);
		}
		else {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("Students Fetched");
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = "/student" ,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> getStudentById(@RequestParam long id){
		Student student=studentService.getStudentById(id);
		StudentResponse studentResponse=new StudentResponse();
		if (student!=null) {
			studentResponse.setMessage("Student Fetched");
			studentResponse.setStudent(student);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.FOUND);
		}
		else {
			studentResponse.setMessage("Student Fetched");
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(path = "/student" ,consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> updateStudent(@RequestBody Student student){
		Student updateStudent = studentService.updateStudent(student);
		
		if (updateStudent!=null) {
			StudentResponse studentResponse= new StudentResponse();
			studentResponse.setMessage("Student updated");
			studentResponse.setStudent(updateStudent);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.CREATED);
		}else {
			StudentResponse studentResponse = new StudentResponse();
			studentResponse.setMessage("Student not found");
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
		
	}
	
		@DeleteMapping(path = "/student/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<StudentResponse> deleteStudent(@PathVariable long id){
			Student deleteStudent = studentService.deleteStudent(id);
			if (deleteStudent!=null) {
				StudentResponse studentResponse=new StudentResponse();
				studentResponse.setMessage("Student deleted");
				studentResponse.setStudent(deleteStudent);
				studentResponse.setStudents(null);
				studentResponse.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.OK);
			}
			else {
				StudentResponse studentResponse=new StudentResponse();
				studentResponse.setMessage("Student deleted");
				studentResponse.setStudent(null);
				studentResponse.setStudents(null);
				studentResponse.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<StudentResponse>(studentResponse,HttpStatus.OK);
			}
			
		}
}

