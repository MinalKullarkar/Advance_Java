package com.jspiders.jdbc.opreation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class JDBCInsetDymanically {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;

	public static void main(String[] args) {
		
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the id");
		int id=scanner.nextInt();
		
		scanner.nextLine();
		
		System.out.println("Enetr the name");
		String name=scanner.nextLine();
		
		System.out.println("Enetr the email");
		String email=scanner.nextLine();
		
		System.out.println("Enetr the age");
		int age=scanner.nextInt();
		
		System.out.println("Enetr the fees");
		int fees=scanner.nextInt();
		
		scanner.close();
		try {
			connection=openConnection();
			query="INSERT INTO student VALUES(?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setInt(4, age);
			preparedStatement.setInt(5, fees);
			
			int row=preparedStatement.executeUpdate();
			System.out.println(row+"row(s) affected.");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3", "root", "root");
		
	}
	private static void closeConnection() throws SQLException {
		if (preparedStatement!=null) {
			preparedStatement.close();
		}
		if (connection!=null) {
			connection.close();
		}
	}
}
