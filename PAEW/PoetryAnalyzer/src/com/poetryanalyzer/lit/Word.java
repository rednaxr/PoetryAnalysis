package com.poetryanalyzer.lit;

public class Word {
	private String text;
	private String[] sound;
	private String[] vowels;
	private String[] consonants;
	private byte[] stress;
	private int count;
	
	Word(String str){
		text = str;
		//TODO: access word in CMU, with lexical stress
		String cmu = "PLACEHOLDER";
		sound = cmu.split(" ");
		int vowelCount = 0;
		int consonantCount = 0;
		for(int a = 0; a < sound.length; a++) {
			if(sound[a].length() == 3) {
				vowelCount++;
			}
			else {
				consonantCount++;
			}
		}
		stress = new byte[vowelCount];
		vowels = new String[vowelCount];
		consonants = new String[consonantCount];
		vowelCount = 0;
		consonantCount = 0;
		for(int a = 0; a < sound.length; a++) {
			if(sound[a].length() == 3) {
				stress[vowelCount] = (byte)(sound[a].charAt(2) - 48);
				vowels[vowelCount] = sound[a].charAt(0) + sound[a].charAt(1) + "";
				vowelCount++;
			}
			else {
				consonants[consonantCount] = sound[a];
				consonantCount++;
			}
		}
		
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
