package com.jspiders.jdbc.opreation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCInsert3 {

	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static String query;
	
	public static void main(String[] args)  {
		//Dynamically inserting queries with the help of scanner class.
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the Id");
		
		int id=scanner.nextInt();
		
		scanner.nextLine();
		
		System.out.println("Enter the name");
		String name=scanner.nextLine();
		
		System.out.println("Enter email");
		String email=scanner.nextLine();
		
		System.out.println("Enter Age");
		int age=scanner.nextInt();
		
		System.out.println("Enter Fees");
		double fees=scanner.nextDouble();
		scanner.close();
		
		
		try {
			connection=openConnection();
			statement=connection.createStatement();
			//Dynamic query
			query="insert into student values("+id+",'"+name+"','"+email+"',"+age+","+fees+")";
			int row=statement.executeUpdate(query);
			System.out.println(row+" row(s) affected");
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}
		
		
	private static Connection openConnection() throws SQLException
	{
		driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3", "root", "root");
		
		
	}
	private static void closeConnection() throws SQLException
	{
		if (statement!=null) {
			statement.close();
		} 
		if (connection!=null) {
			connection.close();
		}
		DriverManager.deregisterDriver(driver);
	}
}
