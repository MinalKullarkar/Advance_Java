package com.jspiders.cardekho_case_study.main;
import java.util.Scanner;

import com.jspiders.cardekho_case_study.entity.Car;
import com.jspiders.cardekho_case_study.operation.CarOperation;

public class CarDekhoMenu {
	
	private static CarOperation operation=new CarOperation();
	private static boolean loop=true;
	
	
	  public  static void  carDekhoMenu() {
		
		System.out.println("========MENU========\n");
		System.out.println("1.Add/Remove Car Details");
		System.out.println("2.Search Car Details");
		System.out.println("3.Edit Car Details");
		System.out.println("4.Exit");
		
		System.out.print("Enter a Number:");
		Scanner sc =new Scanner(System.in);
		int choice =sc.nextInt();

		
		switch (choice)
		{
		case 1:{
					System.out.println("How many cars do you want to Add?");
					System.out.print("Enter a Number:");
					Scanner sc1 =new Scanner(System.in);
					int choice1 =sc.nextInt();
					Car car=new Car();
					switch (choice1) {
					case 1:
					{
						System.out.print("Enter Car_id:"+car.getCar_id());
						break;
					}
					case 2:
					{
						System.out.println("Enter Car_name:"+car.getName());
						break;
					}
					case 3:
					{
						System.out.println("Enter Fuel_type :"+car.getFuel_type());
						break;
					}
					case 4:
					{
						System.out.println("Enter Car_id:");
						break;
					}
					case 5:
					{
						System.out.println("Enter Car_id:");
						break;
					}
					
					default:
						break;
					}
					break;
				 }
		case 2:{
					System.out.println("Search Car By");
					break;
				 }
		case 3:{
					System.out.println("CarId Name");
					break;
				 }
		case 4:{
					System.out.println("Delete Car Detail");
					break;
				 }
		case 5:{
					System.out.println("Exit");
					break;
				 }
		
		}
		

		
		
		}

	  public static void main(String[] args) {
		  carDekhoMenu();
			while(loop){
				//carDekhoMenu();
			}
		}
	  
		
	
	}
