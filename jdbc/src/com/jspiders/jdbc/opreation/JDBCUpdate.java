package com.jspiders.jdbc.opreation;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUpdate {
//	UPDATE table_name
//	SET column1 = value1, column2 = value2, ...
//	WHERE condition;
	private static Connection connection;
	private static Statement statement;
	private static String query;
	
	public static void main(String[] args) {
		try {
			connection=openConnection();
			statement=connection.createStatement();
			//delete
			query="UPDATE student SET name ='Swinal' where id=1";
			int rows= statement.executeUpdate(query);
			System.out.println(rows+" row(s) are affected.");
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static Connection openConnection() throws ClassNotFoundException, IOException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		File file=new File("D:/db_info.txt");
		FileReader fileReader =new FileReader(file); 
		Properties properties=new Properties();
		properties.load(fileReader);
		return DriverManager.getConnection(properties.getProperty("url"), properties);
		
	}
	private static void closeConnection() throws SQLException {
		if (statement!=null) {
			statement.close();
		}
		if (connection!=null) {
			connection.close();
		}
	}
		
		
		
}
