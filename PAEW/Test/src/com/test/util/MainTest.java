package com.test.util;

import java.util.Scanner;

public class MainTest {

	Scanner sysIn = new Scanner(System.in);
	boolean proceed;
	String input;
	
	public MainTest() {
		while(proceed == true) {
			
			
			String[] QnA = {"Repeat?",
					"y",
					"n"};
			if(question(QnA) == 2) {
				proceed = false;
			}
		}
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
	
	
	
}
