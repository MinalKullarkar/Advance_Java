package com.jspiders.designpattern.structural;

public class TeacherAdapter extends Teacher implements Game {

	@Override
	public void football() {
		setId(1);
		setName("Minal");
		setEmail("minal@gmail.com");
		System.out.println(getName()+" is a Coach of Football team.");
	}

	@Override
	public void hockey() {
		setId(2);
		setName("Aarya");
		setEmail("aarya@gmail.com");
		System.out.println(getName()+" is a Coach of Football team.");
	}

	
}
