package com.poetryanalyzer.lit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StructuralAnalysis {
    public Poem poem;

    public ArrayList<Word> wordList = new ArrayList<Word>();
    
	public StructuralAnalysis(ArrayList<String> poem) {
		for(String rawLine : poem) {
			AnalyzeLine(rawLine);
		}
	}
	public void AnalyzeLine(String line) {
		ArrayList<Word> lineList = new ArrayList();
		int startIndex = 0;
		var startOfWord = true;
		var alliterating = true;
		int alliterationEnd;
		for (int endIndex = 0; endIndex < line.length(); endIndex++){
			
		    char c = line.charAt(endIndex);
		    //TODO find common words, rhymes, alliteration
		    if(c == ' ') {

			    if(!startOfWord) {
			    	//TODO: search lexical database
			    	String currentWord = line.substring(startIndex, endIndex);
			    	var word = new Word(currentWord);
			    	wordList.add(word);
			    }
		    	startIndex = endIndex+1;
		    }
		    else {
		    	 if(alliterating) {
		    		 if (line.al)
		    	 }
		    }
		    //TODO word counts
		}
		return new Line(Words);
	}
}
