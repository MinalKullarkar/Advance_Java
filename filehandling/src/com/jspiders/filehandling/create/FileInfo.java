package com.jspiders.filehandling.create;

import java.io.File;
import java.io.IOException;

public class FileInfo {
	
	public static void main(String[] args) {
		File file=new File("D:/JEE Demo/test.txt");
		
		if(file.exists())
		{
			System.out.println("File already exist.");
			System.out.println("Name:"+file.getName());
			System.out.println("Path:"+file.getPath());
			if(file.canRead())
			{
				System.out.println("File is readable");
			}
			else {
				System.out.println("File is not readable");
			}
			
			if (file.canWrite()) {
				System.out.println("File is Writable");
			} else {
				System.out.println("File is not readable");
			}
			
			if (file.canExecute()) {
				System.out.println("File is Executable");
			} else {
				System.out.println("File is not  executable");
			}
		}
		try {
			file.createNewFile();
			System.out.println("File is created.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
