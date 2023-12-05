package com.jspiders.multithreading.resourse;

public class Paratha {
	
	private int  availableParatha;
	
	
	public  synchronized void orderParatha(int numberOfParatha) {
		if(numberOfParatha>availableParatha)
		{
			System.out.println(numberOfParatha+" Paratha's is not available...Please wait for some time...");
		
			try {
				wait();
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		availableParatha-=numberOfParatha;
		System.out.println("Order for "+numberOfParatha+" paratha is successful" );
		
	}
	public synchronized void prepareParatha(int numberOfParatha) {
		System.out.println(numberOfParatha+" Parathas are getting Prepared");
		
		availableParatha+=numberOfParatha;
		
		System.out.println(availableParatha+" Parathas are available");
		
		notify();
	}
}
