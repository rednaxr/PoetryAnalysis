package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class Line {
	private Word[] words;
	private String text;
	//TODO: Create class SingleLineDevice;
	//public SingleLineDevice Immediate = new SingleLineDevice();
	
	public Line(String line) {
		text = line;
		ArrayList<Word> wordList = new ArrayList<Word>();
		int startIndex = 0;
		var startOfWord = true;
		for (int endIndex = 0; endIndex < line.length(); endIndex++){
			char c = line.charAt(endIndex);
			//Just as easy as a regex and faster
		    if( (c >= 'A' && c <= 'Z') || (c == '\'')) {

			    if(!startOfWord) {
			    	String currentWord = line.substring(startIndex, endIndex);
			    	var word = new Word(currentWord);
			    	wordList.add(word);
			    }
		    	startIndex = endIndex+1;
		    }
		}
		var array = new Word[wordList.size()];
	    words = wordList.toArray(array);
	}
	
	/*
	public Line(String line, boolean itsadifferentcontructornow) {
		text = line;
		ArrayList<String> wordStrings = new ArrayList<String>();
		int startIndex;
		boolean startOfWord = true;
		for (int endIndex = 0; endIndex < line.length(); endIndex++){
			char c = line.charAt(endIndex);
			//Just as easy as a regex and faster
		    if( (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c == '\'')) {
			    if(!startOfWord) {
			    	String currentWord = line.substring(startIndex, endIndex);
			    	var word = new Word(currentWord);
			    	wordList.add(word);
			    }
		    	startIndex = endIndex+1;
		    }
		}
		var array = new Word[wordList.size()];
	    words = wordList.toArray(array);
	}
	*/
	public Word[] getWords() {
		return words;
	}

	public void setWords(Word[] words) {
		this.words = words;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getEndRhyme() {
		String output = "";
		Word w = words[words.length-1];
		for(int i = w.getStress().length; i > -1; i++) {
			
		}
		return output;
	}
	
}