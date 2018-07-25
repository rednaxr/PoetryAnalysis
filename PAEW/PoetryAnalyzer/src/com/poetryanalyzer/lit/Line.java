package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class Line {
	ArrayList<Word> WordList;
	public DevicesImmediate Immediate = new DevicesImmediate();
	
	public Line(ArrayList<Word> wordList) {
		WordList = wordList;
	}
}