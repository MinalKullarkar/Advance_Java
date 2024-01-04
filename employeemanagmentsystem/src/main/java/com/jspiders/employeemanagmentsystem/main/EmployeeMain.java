package com.jspiders.employeemanagmentsystem.main;

import java.util.Scanner;

import com.jspiders.employeemanagmentsystem.dao.EmployeeDAO;
import com.jspiders.employeemanagmentsystem.dto.Employee;

public class EmployeeMain {

	private static EmployeeDAO employeeDAO=new EmployeeDAO();
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		boolean flag=true;
		while (flag) {
			
		System.out.println("Enter 1 to add Employee.\nEnter 2 to Delete Employee.\nENter 3 to Update Employee.\nEnter 4 t find employee by Id.\nEnter 5 to find all employees.\nEnter 6 to exit.");
		int choice=scanner.nextInt();
		
		switch (choice) {
		case 1:
			Employee employee=new Employee();
			scanner.nextLine();
			System.out.println("Enter the name of employee");
			employee.setName(scanner.nextLine());
			
			System.out.println("Enter the email of employee ");
			employee.setEmail(scanner.nextLine());
			
			System.out.println("Enter the salary of employee");
			employee.setSalary(scanner.nextDouble());
			
			employeeDAO.addEmployee(employee);
			System.out.println("Employee added.");
			
			break;
		case 2:
			employeeDAO.getAllEmployees();
			System.out.println("Enter employee id");
			employeeDAO.deleteEmployee(scanner.nextInt());
			System.out.println("Employee deleted");
			
			break;
			
		case 3:
			employeeDAO.getAllEmployees();
			System.out.println("Enter employee id");
			employeeDAO.updateEmployee(scanner.nextInt(), scanner);
			System.out.println("Employee updated");
			
			break;
		
		case 4:
			System.out.println("Enter employee id");
			Employee employee2= employeeDAO.getEmployeeById(scanner.nextInt());
			if (employee2 !=null) {
				System.out.println(employee2);
			} else {
					System.out.println("EMployee not found");
			}
			
			break;
			
		case 5:
			employeeDAO.getAllEmployees();
			break;
			
		case 6:
			System.out.println("Thank you!");
			flag=false;
		
		default:
			break;
		}
		
	}
		scanner.close();
	}
}
