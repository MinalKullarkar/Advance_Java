package com.jspiders.jdbc.studentmanagement;

public class Student {

	private static int id;
	private static String name;
	private static String email;
	private static int age;
	private static double fees;
	
	
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Student.id = id;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Student.name = name;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		Student.email = email;
	}
	public static int getAge() {
		return age;
	}
	public static void setAge(int age) {
		Student.age = age;
	}
	public static double getFees() {
		return fees;
	}
	public static void setFees(double fees) {
		Student.fees = fees;
	}
	
	
	
}
