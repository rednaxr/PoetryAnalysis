package com.poetryanalyzer.lit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StructuralAnalysis {
    public Poem poem;

    public ArrayList<Word> wordList = new ArrayList<Word> ();
	public StructuralAnalysis(ArrayList<String> poem) {
		for(String line:poem) {
			AnalyzeLine(line);
		}
	}
	public void AnalyzeLine(String line) {
		ArrayList<Word> lineList = new ArrayList();
		int startIndex = 0;
		for (int endIndex = 0; endIndex < line.length(); endIndex++){
			
		    char c = line.charAt(i);
		    //TODO find common words, rhymes, alliteration
		    if(c == ' ') {
		    	//TODO: search lexical database
		    	String currentWord ="";
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
