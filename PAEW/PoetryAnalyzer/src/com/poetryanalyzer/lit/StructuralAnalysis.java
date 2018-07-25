package com.poetryanalyzer.lit;

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

public class StructuralAnalysis {
    public Poem poem;

    public ArrayList<Word> wordList = new ArrayList<Word>();
    
	public StructuralAnalysis(ArrayList<String> poem) {
		for(String line : poem) {
			AnalyzeLine(line);
		}
	}
	public Line AnalyzeLine(String line) {
		ArrayList<Word> lineList = new ArrayList<Word>();
		int startIndex = 0;
		var startOfWord = true;
		var alliterating = true;
		ArrayList<SoundDevice> alliterationLocations = new ArrayList<SoundDevice>();
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
		    	//This checks for alliteration. It ain't pretty but it's efficient.
		    	 if(alliterating) {
	    			 var currentText = line.substring(startIndex, endIndex);
	    			 var foundMatch = false;
		    		 for(Word word:lineList ) {
		    			 var wordText = word.getText().substring(startIndex, endIndex);
		    			 if(wordText.equals(currentText)) {
		    				 foundMatch = true;
		    			 }
		    		 }
		    		 alliterating = foundMatch;
		    		 //alliterationEnd = endIndex;
		    	 }
		    }
		    //TODO word counts
		}
		var ProcessedLine = new Line(lineList);
		//ProcessedLine.Immediate.Alliteration = alliteration;
		return ProcessedLine;
	}
	
	
	
	public void runExample(){
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
