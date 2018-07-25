//Class for Alliteration, Assonance, Consonance, and Rhyme
//25 July 2018

package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class SoundDevice {
	
	private String sound;
	private int depth;
	private int[] indecies;
	
	
	public SoundDevice(){
	}
	
	public static SoundDevice[] checkAlliteration(ArrayList<Word> words) {
		SoundDevice[] output = null;
		
		ArrayList<String> startSounds = new ArrayList<String>();
		ArrayList<Integer> soundCounts = new ArrayList<Integer>();
		String sound;
		int numberOfSounds = 0;
		for(int a = 0; a < words.size(); a++) {
			sound = words.get(a).getSound()[0];
			if(!startSounds.contains(sound)) {
				startSounds.add(sound);
				soundCounts.add(0);
				numberOfSounds++;
			}
			else {
				soundCounts.set(numberOfSounds, soundCounts.get(numberOfSounds) + 1);
			}
		}
		ArrayList<String> alliterativeSounds = new ArrayList<String>();
		return output;
	}
	
	public static SoundDevice[] checkAssonance(ArrayList<Word> words) {
		SoundDevice[] output = null;
		return output;
	}
	
	public static SoundDevice[] checkConsonance(ArrayList<Word> words) {
		SoundDevice[] output = null;
		return output;
	}
	
}
