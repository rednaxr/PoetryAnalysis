package com.tester.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import edu.mit.jwi.*;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;

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
		runExample();
	}
	public static void runExample(){
		// construct the URL to the Wordnet dictionary directory
		String wnhome = System.getenv("WNHOME");
		String path = wnhome + File.separator + "dict";
				URL url = null;
				     try{ url = new URL("file", null, path); } 
				     catch(MalformedURLException e){ e.printStackTrace(); }
				     if(url == null) return;
				    
				    // construct the dictionary object and open it
				    IDictionary dict = new Dictionary(url);
				    try {
						dict.open();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				    // look up first sense of the word "dog"
				    IIndexWord idxWord = dict.getIndexWord("dog", POS.NOUN);
				    IWordID wordID = idxWord.getWordIDs().get(0);
				    IWord word = dict.getWord(wordID);
				    System.out.println("Id = " + wordID);
				    System.out.println("Lemma = " + word.getLemma());
				    System.out.println("Gloss = " + word.getSynset().getGloss());
				
				  }
}
