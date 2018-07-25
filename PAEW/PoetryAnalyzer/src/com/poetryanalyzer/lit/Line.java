package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class Line {
	public ArrayList<Word> WordList;
	public String literalText;
	public SingleLineDevice Immediate = new SingleLineDevice();
	
	public Line(ArrayList<Word> wordList) {
		WordList = wordList;
	}
}