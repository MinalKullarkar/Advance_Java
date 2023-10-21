package com.jspiders.designpattern.structural;

public class StudentAdaptor extends Student implements Game{

	@Override
	public void football() {
		
		setId(1);
		setName("Sunil Chetri");
		setEmail("sunil@gmail.com");
		System.out.println(getName()+" is a Captain of Football team.");
	}

	@Override
	public void hockey() {
		setId(2);
		setName("Ishan");
		setEmail("Ishan@gmail.com");
		System.out.println(getName()+" is a Captain of Hockey team.");
		
	}

	
}
