package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class Line {
	
	//Attributes
	private Word[] words;
	private String text;
	private DeviceList devices;
	
	//CONSTRUCTOR
	public Line (String lineText) {
		text = lineText;														//Store text of line under Line.text
		lineText += " ";															//(adds padding to end of line text to allow iterating 1 char past last word)
		ArrayList<String> wordStrings = new ArrayList<String>();				//(stores String of each word in line)
		int startIndex = 0;														//(stores index at beginning of word)
		boolean startOfWord = true;												//(stores whether at the start of a word)
		char c;																	//(stores the current char being looked at)
		for(int endIndex = 0; endIndex < lineText.length(); endIndex++) {		//go through each character
			c = lineText.charAt(endIndex);
		    if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c != '\'')) {		//if it isn't a letter or apostrophe
			    if(!startOfWord) {														//...and if it's not at the start of the word, we're at the end of a word
			    	wordStrings.add(lineText.substring(startIndex, endIndex));			//add the word before char c to our list of words
			    	startOfWord = true;														//next character will be at start of word, record
			    }
		    	startIndex = endIndex + 1;										//move the index starting the word to the char after
		    }
		    else {																//if it's a letter or apostrophe, we're in the middle of a word, record that
		    	startOfWord = false;
		    }
		}
	    words = new Word[wordStrings.size()];
	    for(int i = 0; i < words.length; i++) {
	    	words[i] = new Word(wordStrings.get(i));
	    }
	}
	
	
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
	

	public DeviceList getDevices() {
		return devices;
	}

	public void setDevices(DeviceList devices) {
		this.devices = devices;
	}
	
	//finds the rhyming portion of the last line
	public String getEndRhyme() {
		String endRhyme = "";											//Stores String of sounds for end rhyme
		int startIndex = 0;												//Stores the index of the vowel that begins the rhyme-relevant portion of the word
		Word w = words[words.length-1];									//Stores last word of line
		if(w.getSound() != null) {
			for(int i = w.getStress().length - 1; i > -1; i--) {			//find and record the index (in vowels[]) of the last stressed vowel sound
				if(w.getStress()[i] != Word.NO_STRESS) {						//(it starts the last stressed vowel sound of the word)
					startIndex = i;
					i = -1;
				}
			}
			String startVowel = w.getVowels()[startIndex];					//store the stressed vowel sound
			for(int i = w.getSound().length - 1; i > -1; i--) {				//find its index in the word array
				if(w.getSound()[i].equals(startVowel)) {
					startIndex = i;
					i = -1;
				}
			}

			for(int i = startIndex; i < w.getSound().length; i++) {			//add that vowel sound and all following sound to the end rhyme
				endRhyme += w.getSound()[i];
			}
		}
		else endRhyme = null;
		
		return endRhyme;
	}

	/*
	 * OLD CONSTRUCTOR
	public Line(String line) {
		text = line;
		ArrayList<Word> wordList = new ArrayList<Word>();
		int startIndex = 0;
		
		var startOfWord = true;
		//look at each character.
		for (int endIndex = 0; endIndex < line.length(); endIndex++) {
			char c = line.charAt(endIndex);
			//If it isn't a-z or '
		    if ((c < 'A' || c > 'Z') && (c != '\'')) {
		    	//If it is not the start of a word, then it must be the end of the word!
			    if(!startOfWord) {
			    	String currentWord = line.substring(startIndex, endIndex);
			    	var word = new Word(currentWord);
			    	wordList.add(word);
			    	startOfWord = true;
			    }
		    	startIndex = endIndex+1;
		    }
		}
		var array = new Word[wordList.size()];
	    words = wordList.toArray(array);
	}
	*/
	
}