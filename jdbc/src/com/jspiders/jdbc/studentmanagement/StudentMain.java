package com.jspiders.jdbc.studentmanagement;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		
		StudentJDBC jdbc=new StudentJDBC();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter 1 to add student.\nEnter 2 to get All Student.\nEnter 3 to get student by id.\nEnter 4 to delete student.\nEnter 5 to update student data.");
		
		int choice=scanner.nextInt();
		
		switch (choice) {
		case 1: {
			Student student=new Student();
			jdbc.addStudent(student);
			break;
		}
		case 2:{
			ArrayList<Student> data=jdbc.getAllStudents();
			for (Object student : data) {
				System.out.println(student);
			}
			break;
		}
		case 3:{
			System.out.println("Enter the student id");
			Student data=jdbc.getStudentById(scanner.nextInt());
			System.out.println(data);
			break;
		}
		case 4:{
			System.out.println("Enter studetn id to delete data.");
			jdbc.deleteStudent(scanner.nextInt());
			break;
		}
		case 5:{
			
		}
		default:
			System.out.println("Invalid Choice ");
		}
		scanner.close();
	}
}
