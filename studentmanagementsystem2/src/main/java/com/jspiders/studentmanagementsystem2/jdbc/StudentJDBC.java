package com.jspiders.studentmanagementsystem2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspiders.studentmanagementsystem2.object.Student;

public class StudentJDBC {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String query;
	
	private void openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagment", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void closeConnection() {
		try {
			if (preparedStatement!=null) {
				preparedStatement.close();
			}
			if (resultSet!=null) {
				resultSet.close();
			}
			if (connection!=null) {
				connection.close();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addStudent(int id,String name,String email,long mobile) {
		try {
		openConnection();
		query="INSERT INTO student VALUES(?,?,?,?)";
		
		preparedStatement=connection.prepareStatement(query);			
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setLong(4, mobile);
			
			int rows = preparedStatement.executeUpdate();
			System.out.println(rows+ " row(s) affected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			closeConnection();
	}
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		openConnection();
		query = "SELECT * FROM student";
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setEmail(resultSet.getString(3));
				student.setMobile(resultSet.getLong(4));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return students;
	}

	public void deleteStudent(int id) {
		openConnection();
		query = "DELETE FROM student WHERE id = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int res = preparedStatement.executeUpdate();
			System.out.println(res + " row(s) affected.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public Student getStudentById(int id) {
		Student student = null;
		openConnection();
		query = "SELECT * FROM student WHERE id = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				student = new Student();
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setEmail(resultSet.getString(3));
				student.setMobile(resultSet.getLong(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return student;
	}

	public void updateStudent(int id, String name, String email, long mobile) {
		openConnection();
		query = "UPDATE student SET name = ?, email = ?, mobile = ? WHERE id = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setLong(3, mobile);
			preparedStatement.setInt(4, id);
			int res = preparedStatement.executeUpdate();
			System.out.println(res + " row(s) affected.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
}
