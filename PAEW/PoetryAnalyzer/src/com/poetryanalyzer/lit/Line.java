package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class Line {
	private Word[] words;
	private String text;
	//TODO: Create class SingleLineDevice;
	//public SingleLineDevice Immediate = new SingleLineDevice();
	
	public Line(String text) {
		this.text = text;
		String[] wordStrings = text.split(" ");
		words = new Word[wordStrings.length];
		for(int i = 0; i < words.length; i++) {
			words[i] = new Word(wordStrings[i]);
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
	
	public String getEndRhyme() {
		String output = "";
		
		return output;
	}
	
}