package com.poetryanalyzer.lit;

public class Line {
	private String text;
	private Word[] words;
	
	public Line (String line) {
		text = line;
		String[] wordsTemp = text.split(" ");
		words = new Word[wordsTemp.length];
		for (int w = 0; w < wordsTemp.length; w++) {
			words[w] = new Word (wordsTemp[w]);
		}
	}
	
	public Word[] getWords () {
		return words;
	}
	
	public String getText () {
		return text;
	}
	
	/*public static void main (String[] args) {
		Line line1 = new Line ("Two roads diverged in a yellow wood");
		line1.displayLine();
	}*/
}
