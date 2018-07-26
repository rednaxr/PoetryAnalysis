package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class Line {
	private ArrayList<Word> WordList;
	private String text;
	//TODO: Create class SingleLineDevice;
	//public SingleLineDevice Immediate = new SingleLineDevice();
	
	public Line(ArrayList<Word> wordList) {
		WordList = wordList;
	}

	public ArrayList<Word> getWordList() {
		return WordList;
	}

	public void setWordList(ArrayList<Word> wordList) {
		WordList = wordList;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}