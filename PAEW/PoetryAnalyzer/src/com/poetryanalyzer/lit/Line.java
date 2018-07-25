package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class Line {
	public ArrayList<Word> WordList;
	public String literalText;
	public DevicesImmediate Immediate = new DevicesImmediate();
	
	public Line(ArrayList<Word> wordList) {
		WordList = wordList;
	}
}