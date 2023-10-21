package com.jspiders.filehandling.create;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharStreamReadDemo2 {
	public static void main(String[] args) throws FileNotFoundException {
		File file=new File("demo.txt");
		
		if(file.exists())
		{
			Scanner scanner=new Scanner(file);
			while(scanner.hasNextLine())
			{
				System.out.println(scanner.nextLine());
				
			}
			System.out.println("Data is succussedfully fetched");
			scanner.close();
		}
		else {
			System.out.println("File does not exist");
		}
	}
}
