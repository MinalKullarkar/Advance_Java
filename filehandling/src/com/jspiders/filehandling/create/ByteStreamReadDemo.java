package com.jspiders.filehandling.create;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ByteStreamReadDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("Text.txt");
		
		if(file.exists())
		{
			FileInputStream fileInputStream=new FileInputStream(file);
			int value=fileInputStream.read();
			System.out.println(value);
			System.out.println("Data is successfully fetched.");
			fileInputStream.close();
		}
		else {
			System.out.println("File does Not exist");
		}
	}
}
