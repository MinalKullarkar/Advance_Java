package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resourse.Paratha;

public class Restro extends Thread{
	private Paratha paratha;

	public Restro(Paratha paratha) {
		this.paratha = paratha;
	}
	
	@Override
	public void run() {
		paratha.prepareParatha(10);
	}
}
