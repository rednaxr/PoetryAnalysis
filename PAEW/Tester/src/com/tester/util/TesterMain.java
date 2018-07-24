package com.tester.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TesterMain {
	
	Scanner sysIn = new Scanner(System.in);
	String input;
	String output = "";
	
	public TesterMain() {
		System.out.println("File Name:");
		System.out.print("> ");
		input = sysIn.nextLine();
		PrintWriter printer = null;
		try {
			printer = new PrintWriter(new File(input));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("File Contents:");
		System.out.print("> ");
		input = sysIn.nextLine();
		printer.write(input);
		printer.close();
		System.out.println("Goodbye!");
	}
	
	public static void main(String[] args) {
		new TesterMain();
	}
	
}
