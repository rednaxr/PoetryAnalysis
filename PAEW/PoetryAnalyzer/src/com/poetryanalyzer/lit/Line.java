package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class Line {
	public ArrayList<Word> WordList;
	public String literalText;
	//TODO: Create class SingleLineDevice;
	//public SingleLineDevice Immediate = new SingleLineDevice();
	
	public Line(ArrayList<Word> wordList) {
		WordList = wordList;
	}
}