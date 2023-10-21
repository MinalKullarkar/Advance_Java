package com.jspiders.designpattern.creationalmain;

import java.util.Scanner;

import com.jspiders.designpattern.creational.Beverage;
import com.jspiders.designpattern.creational.GingerTae;
import com.jspiders.designpattern.creational.GreenTae;
import com.jspiders.designpattern.creational.LemonTae;
import com.jspiders.designpattern.creational.MasalaTae;

public class FactoryMain {

	private static Beverage beverage;
	
	public static void main(String[] args) {
		factory().order();
	}
	
	private static Beverage factory () 
	{
		 Scanner scanner = new Scanner(System.in);
		 
		 System.out.println("Enter 1 to order Masala Tae\n"+ "Enter 2 to order Ginger Tae\n"+
		 "Enter 3 to order Lemon Tae\n"+"Enter 4 to order Green Tae\n");
		 
		 System.out.println("Enter your Choice");
		 int Choice=scanner.nextInt();
		 
		 switch (Choice) 
		 {
		case 1: {
			beverage=new MasalaTae();
			break;
		}
		case 2: {
			beverage=new GingerTae();
			break;
		}
		case 3: {
			beverage=new LemonTae();
			break;
		}
		case 4: {
			beverage=new GreenTae();
			break;
		}
		default:
			System.out.println("Invalid Choice...");
		
		 }
		 scanner.close();
		 return beverage;
	}
	
}
