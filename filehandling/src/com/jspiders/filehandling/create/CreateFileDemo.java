package com.jspiders.filehandling.create;

import java.io.File;
import java.io.IOException;

public class CreateFileDemo {

	public static void main(String[] args) {
		File file= new File("demo.txt");
		File file1=new File("minal.java");
		File file2=new File("minal.class");
		File file3=new File("minal.png");
		File file4=new File("minal.jpg");
		File file5=new File("minal.pdf");
		File file6=new File("minal.xml");
		File file7=new File("minal.html");
		File file8=new File("minal.pptx");
		File file9=new File("minal.exe");
		File file10=new File("minal.py");
		File file11=new File("minal.mp3");
		File file12=new File("minal.csv");
		File file13=new File("minal.zip");
		File file14=new File("minal.avi");
		
		
		try {
			file.createNewFile();
			file1.createNewFile();
			file2.createNewFile();
			file3.createNewFile();
			file4.createNewFile();
			file5.createNewFile();
			file6.createNewFile();
			file7.createNewFile();
			file8.createNewFile();
			file9.createNewFile();
			file10.createNewFile();
			file11.createNewFile();
			file12.createNewFile();
			file13.createNewFile();
			file14.createNewFile();
			
			
			
			System.out.println("File Sucessfully Created");
			System.out.println(file11.canExecute());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
