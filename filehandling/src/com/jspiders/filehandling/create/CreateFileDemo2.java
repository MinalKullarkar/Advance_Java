package com.jspiders.filehandling.create;

import java.io.File;

public class CreateFileDemo2 {

	public static void main(String[] args) {
		File file=new File("demo.txt");
		
		if (file.exists()) {
			System.out.println("File Already Exist.");
		}
		else
		{
			try {
				file.createNewFile();
				System.out.println("File Successfully created");
			} catch (Exception e) {
				System.out.println("File not Created");
				e.printStackTrace();
				
			}
		}
	}
}
