package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resourse.Paratha;
import com.jspiders.multithreading.thread.Customer;
import com.jspiders.multithreading.thread.Restro;

public class ParathaMain {

	public static void main(String[] args) {
		Paratha paratha =new Paratha();
		
		Customer customer=new Customer(paratha);
		
		Restro restro = new Restro(paratha);
		
		customer.start();
		restro.start();
	}
}
 