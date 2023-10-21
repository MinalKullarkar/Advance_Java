package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resourse.Paratha;

public class Customer extends Thread {

	private Paratha paratha=new Paratha();
	public Customer(Paratha paratha) {
		this.paratha=paratha;
	}
	@Override
	public void run() {
		paratha.orderParatha(10);
	}
}
