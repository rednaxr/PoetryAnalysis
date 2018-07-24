package com.test.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {

	Scanner sysIn = new Scanner(System.in);
	Scanner fileIn = null;
	boolean proceed;
	String input;
	String output;
	ArrayList<String> lines;
	
	public MainTest() {
		proceed = true;
		while(proceed == true) {
			System.out.println("Input File:");
			System.out.print("> ");
			input = sysIn.nextLine();
			lines = readFile(input);
			lines.add("kinoushita");
			output = "";
			for(int i = 0; i < lines.size(); i++) {
				output += lines.get(i) + "\n";
			}
			System.out.println(output);
			writeFile("output.txt", output);
			String[] QnA = {"Repeat?",
					"y",
					"n"};
			if(question(QnA) == 2) {
				proceed = false;
			}
		}
		System.out.println("Goodbye!");
	}
	
	public static void main(String[] args) {
		new MainTest();
	}

	//Asks a question based on an inputted array of a question (at index 0) and answers (indexes 1+)
	private int question(String[] QnA) {
		int reint = 0;
		String answer;
		String output = QnA[0] + " (";			//Print out question QnA[0] w/ valid answers following in parenthesis
		for(int i = 1; i < QnA.length - 1; i++) {
			output += QnA[i] + ", ";
		}
		output += QnA[QnA.length-1] + ")";
		System.out.println(output);
		boolean cont = false;						//Until a valid answer is given...
		while(cont == false) {
			System.out.print("> ");					//print prompt and read input
			answer = sysIn.nextLine();
			for(int i = 1; i < QnA.length; i++) {	//if the input equals any of the answers, return the index of that answer
				if(QnA[i].equals(answer)) {
					reint = i;
					cont = true;
				}
			}
			if(cont == false) {						//if input was not one of the answers, report and print out valid answers:
				output = "Invalid Input. Valid Answers: ";
				for(int i = 1; i < QnA.length-1; i++) {
					output += QnA[i] + ", ";
				}
				output += QnA[QnA.length-1];
				System.out.println(output);
			}
		}
		return reint;
		}
	
	//reads in text from a file
	public ArrayList<String> readFile (String filePath) {
		ArrayList<String> input = new ArrayList<String>();
		Scanner fileReader = null;
		try {
			fileReader = new Scanner(new File(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (fileReader.hasNextLine()) {
			input.add(fileReader.nextLine());
		}
		fileReader.close();
		return input;
	}
	
	
	//writes output to a string
	public void writeFile(String filePath, String output) {
		PrintWriter printer = null;
		try {
			printer = new PrintWriter(new FileWriter(new File(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		printer.write(output);
		printer.close();
	}

	
}
