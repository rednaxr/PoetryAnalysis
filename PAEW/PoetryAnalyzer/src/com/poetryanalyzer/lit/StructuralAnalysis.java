package com.poetryanalyzer.lit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StructuralAnalysis {
    public ArrayList<Word> wordList = new ArrayList<Word> ();
	public StructuralAnalysis(ArrayList<String> poem) {
		for(String line:poem) {
			AnalyzeLine(line);
		}
	}
	public void AnalyzeLine(String line) {
		String currentWord ="";
		ArrayList<Word> lineList = new ArrayList();
		for (int i = 0; i < line.length(); i++){
		    char c = line.charAt(i);        
		    if(c == ' ') {
		    	//TODO: search lexical database
		    	var word = new Word(currentWord);
		    	
		    	wordList.add(word);
		    	currentWord = "";
		    }
		    else {
		    	
		    }
		    //TODO word counts
		}
	}
	
}
