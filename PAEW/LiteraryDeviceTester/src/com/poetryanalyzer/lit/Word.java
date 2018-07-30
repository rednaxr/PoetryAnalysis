package com.poetryanalyzer.lit;

public class Word {
	private String text;
	
	public Word (String word) {
		setText(word);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
