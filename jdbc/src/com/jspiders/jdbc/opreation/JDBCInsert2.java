package com.jspiders.jdbc.opreation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert2 {

	
	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static String Query;
	
	public static void main(String[] args)  {
	
		try {
			connection=openConnection();
			statement=connection.createStatement();
			//Static query
			Query="insert into student values(6,'pranay','pranay@gmail.com',22,30000)";
			int row=statement.executeUpdate(Query);
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
