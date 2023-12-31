package com.jspiders.studentmanagementsystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.studentmanagementsystem.jdbc.StudentJDBC;

@WebServlet("/add_student")
public class AddStudent extends HttpServlet{

	private static final long serialVersionUID = 1L;
	StudentJDBC studentJDBC=new StudentJDBC();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		try {
			studentJDBC.addStudent(id, name,email);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
