package com.jspiders.smswithspringrest2.response;

import java.util.List;

import com.jspiders.smswithspringrest2.pojo.Student;

import lombok.Data;

@Data
public class StudentResponse {

	private String message;
	private Student student;
	private List<Student> students;
	private int status;
}
