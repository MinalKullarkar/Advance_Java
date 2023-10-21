package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resourse.Resourse;

public class MyThread6 extends Thread{

	private Resourse resourse;
	
	
	public MyThread6(Resourse resourse) {
		
		this.resourse = resourse;
	}


	@Override
	public void run() {
		resourse.message();
	}
}
