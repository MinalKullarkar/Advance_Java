package com.jspiders.jdbc.studentmanagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		
		StudentJDBC jdbc=new StudentJDBC();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter 1 to add student.\nEnter 2 to get All Student.");
		
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
		default:
			System.out.println("Invalid Choice ");
		}
		scanner.close();
	}
}