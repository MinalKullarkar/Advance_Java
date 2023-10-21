package com.jspiders.designpattern.creationalmain;

import java.util.Scanner;

import com.jspiders.designpattern.creational.Car;
import com.jspiders.designpattern.creational.Ford;
import com.jspiders.designpattern.creational.MGHector;
import com.jspiders.designpattern.creational.Nexon;
import com.jspiders.designpattern.creational.Seltos;
import com.jspiders.designpattern.creational.Thar;

public class CarMain {

	private static Car car;
	
	public static void main(String[] args) {
		Car object=factory();//factory() return the object of type Car(parent type object)
		object.order();
	}
	
	private static Car factory()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter 1 to oreder Thar.\n"
				+ "Enter 2 to oreder Nexon.\n"
				+ "Enter 3 to oreder Ford.\n"
				+ "Enter 4 to oreder MG Hector.\n"
				+ "Enter 5 to oreder Seltos.\n");
		
		System.out.println("Enter Your order");
		int choice=scanner.nextInt();
		
		switch (choice) {
		case 1: {
			car=new Thar();
			break;
		}
		case 2: {
			car=new Nexon();
			break;
		}
		case 3: {
			car=new Ford();
			break;
		}
		case 4: {
			car=new MGHector();
			break;
		}
		case 5: {
			car=new Seltos();
			break;
		}
		default:
			System.out.println("Invalid Choice");
		}
		scanner.close();
		return car;
	}
}
