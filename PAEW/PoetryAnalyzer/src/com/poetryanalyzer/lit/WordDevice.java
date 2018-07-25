package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class WordDevice {
	public int Intensity;
	public String properties;
	// Each item in list is the indices of the words with that device
	public ArrayList<Integer> indices;
	
	public WordDevice(){
	}
	
	public static WordDevice[] checkAlliteration(ArrayList<Word> words) {
		WordDevice[] output = null;
		ArrayList<String> startSounds = new ArrayList<String>();
		ArrayList<Integer> soundCounts = new ArrayList<Integer>();
		String sound;
		for(int a = 0; a < words.size(); a++) {
			sound = words.get(a).getSound()[0];
			if(!startSounds.contains(sound)) {
				startSounds.add(sound);
				soundCounts.add(0);
			}
			else {
				
			}
		}
		return output;
	}
	
	public static WordDevice[] checkAssonance(ArrayList<Word> words) {
		WordDevice[] output = null;
		return output;
	}
	
	public static WordDevice[] checkConsonance(ArrayList<Word> words) {
		WordDevice[] output = null;
		return output;
	}
	
}
