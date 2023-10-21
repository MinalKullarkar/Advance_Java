package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resourse.Resourse;

public class MyThread5 extends Thread{
	private Resourse resourse;
	
	public MyThread5(Resourse resourse) {
		this.resourse=resourse;
	}
	public void run() {
		resourse.message();
	}
	
}
