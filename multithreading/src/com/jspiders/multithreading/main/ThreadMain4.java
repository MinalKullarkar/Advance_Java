package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resourse.Resourse;
import com.jspiders.multithreading.thread.MyThread5;
import com.jspiders.multithreading.thread.MyThread6;

public class ThreadMain4 {

	public static void main(String[] args) {
		Resourse resourse= new Resourse();
		
		MyThread5 myThread5=new MyThread5(resourse);
		myThread5.setName("Thread5");
		
		MyThread6 myThread6= new MyThread6(resourse);
		myThread6.setName("Thread6");
		
		myThread5.start();
		myThread6.start();
	}
}
