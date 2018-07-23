package com.poetryanalyzer.lit;

public class Word {
	private String text;
	private int count;
	
	Word(String str){
		text = str;
	}
	Word(String str, int wordCount){
		text = str;
		count = wordCount;
	}

	public String getText() {
		return text;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
