package com.jspiders.jdbc.opreation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCInsert {
	
	public static void main(String[] args) throws SQLException {
		//Register Driver
		Driver driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		//Open Connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3?user=root&&password=root");
		
		//Create Statement
		Statement statement=connection.createStatement();
		
		
		//Execute statement
		statement.execute("INSERT INTO student VALUES(2,'Aarya','arya@gamil.com',23,16000),(3,'Shital','shital@gmail.com',24,20000)");
		System.out.println("Data is inserted into the table");
		
		
		//close connection 
		statement.close();
		connection.close();
		
		//deregister the Driver
		DriverManager.deregisterDriver(driver);
	}
}
