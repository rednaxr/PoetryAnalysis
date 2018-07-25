package com.poetryanalyzer.lit;

public class Word {
	
	//Word Attributes
	private String text;
	private int count;
	private String[] sound, vowels, consonants;
	private byte[] stress;
	
	//Word Static Variables
	public static final byte NO_STRESS = 0;
	public static final byte PRIMARY_STRESS = 1;
	public static final byte SECONDARY_STRESS = 2;
	
	Word (String str) {
		text = str;
		//TODO: access word in CMU, with lexical stress
		String cmu = "PLACEHOLDER";
		sound = cmu.split(" ");						//Split string from CMU into vowel and consonant sounds
		int vowelCount = 0;
		int consonantCount = 0;
		for(int a = 0; a < sound.length; a++) {		//Count number of vowel and consonant sounds in word
			if(sound[a].length() == 3) {
				vowelCount++;
			}
			else {
				consonantCount++;
			}
		}
		stress = new byte[vowelCount];				//initialize arrays of stresses, vowels, and consonants
		vowels = new String[vowelCount];
		consonants = new String[consonantCount];
		vowelCount = 0;
		consonantCount = 0;
		for(int a = 0; a < sound.length; a++) {		//populate arrays with relevant parts of CMU output
			if(sound[a].length() == 3) {
				stress[vowelCount] = (byte)(sound[a].charAt(2) - 48);
				vowels[vowelCount] = sound[a].charAt(0) + sound[a].charAt(1) + "";
				sound[a] = vowels[vowelCount];
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

	public String[] getSound() {
		return sound;
	}

	public void setSound(String[] sound) {
		this.sound = sound;
	}

	public String[] getVowels() {
		return vowels;
	}

	public void setVowels(String[] vowels) {
		this.vowels = vowels;
	}

	public String[] getConsonants() {
		return consonants;
	}

	public void setConsonants(String[] consonants) {
		this.consonants = consonants;
	}

	public byte[] getStress() {
		return stress;
	}

	public void setStress(byte[] stress) {
		this.stress = stress;
	}
	
}
