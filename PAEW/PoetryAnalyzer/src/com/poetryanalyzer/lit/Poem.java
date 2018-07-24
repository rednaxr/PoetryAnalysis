package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class Poem {
	
	static final int ALLITERATION = 1;
	
	
	private ArrayList<String> text;
	private int[] rhymeScheme;
	private int wordCount;
	
	public Poem(ArrayList<String> text) {
		this.text = text;
	}

	public ArrayList<String> getText() {
		return text;
	}

	public void setText(ArrayList<String> text) {
		this.text = text;
	}

	public int[] getRhymeScheme() {
		return rhymeScheme;
	}

	public void setRhymeScheme(int[] rhymeScheme) {
		this.rhymeScheme = rhymeScheme;
	}	
	
	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}
	
}
