package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class Poem {
	
	static final int ALLITERATION = 1;
	static final int ASSONANCE = 2;
	static final int CONSONANCE = 3;
	static final int INTERNAL_RHYME = 4;
	static final int METAPHOR = 5;
	static final int SIMILE = 6;
	
	private Line[] lines;
	private int[] rhymeScheme;
	private int wordCount;
	
	public Poem(ArrayList<String> text) {
		lines = new Line[text.size()];
		for(int i = 0; i < lines.length; i++) {
			lines[i] = new Line(text.get(i));
		}
	}

	public Line[] getLines() {
		return lines;
	}
	
	public void setLines(Line[] lines) {
		this.lines = lines;
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
