package com.jspiders.filehandling.create;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamWrite {
	public static void main(String[] args) throws IOException {
		File file=new File("demo.txt");
		if (file.exists()) {
			System.out.println("File already exist");
			FileWriter fileWriter =new FileWriter(file);
			fileWriter.write("Hello Minal!");
			System.out.println("Data is written in the file");
			fileWriter.close();
			
		} else {
			System.out.println("File Does not exist");
			file.createNewFile();
			System.out.println("File is created");
			
			FileWriter fileWriter= new FileWriter(file);
			fileWriter.write("Hello Minal!");
			System.out.println("Data is written to the file");
			fileWriter.close();

		}
	}
}
