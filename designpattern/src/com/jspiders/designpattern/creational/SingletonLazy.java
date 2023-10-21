package com.jspiders.designpattern.creational;

public class SingletonLazy {
	
	private static SingletonLazy singletonLazy;//late instantiation
	
	private SingletonLazy()
	{
		
	}
	
	public static SingletonLazy getObject()
	{
		if(singletonLazy==null)
		{
			singletonLazy=new SingletonLazy();
		}
		return singletonLazy;
	}
}
