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
    private Poem poem;
    public ArrayList<Word> wordList = new ArrayList<Word>();
    
	public StructuralAnalysis(ArrayList<String> poemLines) {
		//Initialize poem, parsing it into lines and words and finding pronunciation of each word
		poem = new Poem(poemLines);
		
		//TODO: Calculate Scantion of poem
		for(int a = 0; a < poem.getLines().length; a++) {
			ArrayList<boolean[]> b = new ArrayList<boolean[]>();
		}
		
		
		//find Rhyme Scheme of Poem
		String[] endRhymes = new String[poem.getLines().length];		//stores rhyme relevant part of each line (last stressed vowel onward)
		int[] rhymeScheme = new int[poem.getLines().length];			//stores numbers corresponding to each unique rhyme, in order
		int n = 1;														//Stores number of rhymes found so far (serves as rhyme number to identify rhyming lines)
		boolean match;													//stores whether another rhyme of the same kind has been found
		for(int i = 0; i < poem.getLines().length; i++) {
			if(poem.getLines()[i].getWords().length > 0) {					//(ignoring blank lines)
				endRhymes[i] = poem.getLines()[i].getEndRhyme();		//get the rhyme-relevant sound at the end of each line
				match = false;
				for(int j = 0; j < i; j++) {								//check if it matches any others
					if(endRhymes[i].equals(endRhymes[j])) {
						rhymeScheme[i] = rhymeScheme[j];					//if it does, give it the same rhyme number as the one it matches
						match = true;
						j = i;
					}
				}
				if(match == false) {										//if it doesn't, give it it's own rhyme number
					rhymeScheme[i] = n;											//(and increase the rhyme number for the next one)
					n++;
				}
			}
		}
		poem.setRhymeScheme(rhymeScheme);								//store the acquired rhymescheme in the poem
		
	}
	
	public Poem getPoem() {
		return poem;
	}

	public void setPoem(Poem poem) {
		this.poem = poem;
	}
	
	/*
	public Line AnalyzeLine (String line) {
		
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
	*/
	
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
