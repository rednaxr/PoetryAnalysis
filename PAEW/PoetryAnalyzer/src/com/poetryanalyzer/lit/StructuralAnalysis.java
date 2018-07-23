package com.poetryanalyzer.lit;

import java.util.ArrayList;
import java.util.Arrays;

public class StructuralAnalysis {

	public StructuralAnalysis(ArrayList<String> poem) {
		var inputWords = new ArrayList<String>(Arrays.asList(str.split(" ")));
		ArrayList<Word> wordList = new ArrayList<Word>();
		for (String item : inputWords) 
		{ 
		    wordList.add(new Word(item));
		}
	}
	
	
}
