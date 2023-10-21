package com.jspiders.designpattern.creationalmain;

import com.jspiders.designpattern.creational.SingletonLazy;

public class SingletonLazyMain {
	
	public static void main(String[] args) {
		SingletonLazy Object1=SingletonLazy.getObject();
		SingletonLazy Object2=SingletonLazy.getObject();
		SingletonLazy Object3=SingletonLazy.getObject();
		
		System.out.println(Object1);
		System.out.println(Object2);
		System.out.println(Object3);
	}
}
