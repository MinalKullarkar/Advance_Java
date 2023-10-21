package com.jspiders.designpattern.creationalmain;

import com.jspiders.designpattern.creational.SingletonEager;

public class SingletonEagerMain {
	public static void main(String[] args) {
		SingletonEager Object1=SingletonEager.getObject();
		SingletonEager Object2=SingletonEager.getObject();
		SingletonEager Object3=SingletonEager.getObject();
		
		System.out.println(Object1);
		System.out.println(Object2);
		System.out.println(Object3);
		
	}
}
