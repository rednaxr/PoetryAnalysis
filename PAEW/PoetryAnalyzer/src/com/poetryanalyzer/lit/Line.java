package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class Line {
	private Word[] words;
	private String text;
	private Devices devices;
	
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
	
	
	public Line (String line, boolean itsadifferentcontructornow) {
		text = line;
		ArrayList<String> wordStrings = new ArrayList<String>();
		int startIndex = 0;
		boolean startOfWord = true;
		//look at each character.
		for (int endIndex = 0; endIndex < line.length(); endIndex++) {
			char c = line.charAt(endIndex);
			//If it isn't a-z or '
		    if ((c < 'A' || c > 'Z') && (c != '\'')) {
		    	//If it is not the start of a wor, then it must be the end of the word!
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
	

	public Devices getDevices() {
		return devices;
	}

	public void setDevices(Devices devices) {
		this.devices = devices;
	}
	
	//finds the rhyming portion of the last line
	public String getEndRhyme() {
		String endRhyme = "";											//Stores String of sounds for end rhyme
		int startIndex = 0;												//Stores the index of the vowel that begins the rhyme-relevant portion of the word
		Word w = words[words.length-1];									//Stores last word of line
		for(int i = w.getStress().length - 1; i > -1; i--) {			//find and record the index (in vowels[]) of the last stressed vowel sound
			if(w.getStress()[i] != 0) {										//(it starts the last stressed vowel sound of the word)
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
		return endRhyme;
	}

	
}