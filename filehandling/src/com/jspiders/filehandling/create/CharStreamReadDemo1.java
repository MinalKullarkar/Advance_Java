package com.jspiders.filehandling.create;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CharStreamReadDemo1 {
	
	//Reading Data Using FileReader Class
	public static void main(String[] args) throws IOException {
		File file =new File("demo.txt");
		if(file.exists())
		{
			FileReader fileReader=new FileReader(file);
			int value=fileReader.read();//return the ASCII value of first character of first letter
			System.out.println(value);
			System.out.println("Data is successfully Fetched from the file");
			fileReader.close();
		}
		else {
			System.out.println("File Does not exist");
		}
	}
}

