package com.jspiders.filehandling.create;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamWrite {
	 public static void main(String[] args) throws IOException {
		File file = new File("Text.txt");
	
		if (file.exists()) {
			System.out.println("File already exist.");
			FileOutputStream fileOutputStream=new FileOutputStream(file);
			fileOutputStream.write(500);
			System.out.println("Data is added to the file");
			fileOutputStream.close();
			
		} else {
			System.out.println("File Does not exist");
			file.createNewFile();
			System.out.println("File is created");
			FileOutputStream fileOutputStream=new FileOutputStream(file);
			fileOutputStream.write(500);
			System.out.println("Data is added to the file");
			fileOutputStream.close();

		}
		
	}
}
