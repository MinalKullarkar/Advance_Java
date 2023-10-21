package com.jspiders.multithreading.resourse;

public class Resourse {

	public void message() {
		System.out.println("Hello from "+Thread.currentThread().getName());
	}
}
