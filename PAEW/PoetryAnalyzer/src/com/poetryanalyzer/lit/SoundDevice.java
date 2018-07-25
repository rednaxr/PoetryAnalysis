//Class for Alliteration, Assonance, Consonance, and Rhyme
//25 July 2018

package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class SoundDevice {
	
	//NON-STATIC----------------------------------------------
	
	//Attributes
	private String sound;						//sound(s) being repeated in Sound Device
	private int depth;							//number of sounds repeated
	private ArrayList<Integer> indecies;		//locations of those sounds (which word)
	
	
	public SoundDevice(String sound){
		this.sound = sound;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public ArrayList<Integer> getIndecies() {
		return indecies;
	}

	public void setIndecies(ArrayList<Integer> indecies) {
		this.indecies = indecies;
	}
	
	//STATIC---------------------------------------------------------------------------
	
	//finds all instances of alliteration in list of words, reporting  sound, indecies, and depth of alliteration
	public static ArrayList<SoundDevice> checkAlliteration(ArrayList<Word> words) {
		ArrayList<SoundDevice> alliterations = new ArrayList<SoundDevice>();
		String sound;
		//boolean contains = false;
		for(int a = 0; a < words.size(); a++) {											//Record each starting sound and their indecies in WordDevice Objects
			sound = words.get(a).getSound()[0];
			for(int b = 0; b < alliterations.size(); b++) {
				if(!alliterations.get(b).getSound().equals(sound)){
					alliterations.add(new SoundDevice(sound));
					alliterations.get(alliterations.size() - 1).getIndecies().add(a);
				}
				else {
					alliterations.get(b).getIndecies().add(a);
				}
			}
		}
		for(int a = 0; a < alliterations.size(); a++) {									//Remove each sound/WordDevice with only one index
			if(alliterations.get(a).getIndecies().size() == 1) {
				alliterations.remove(a);
			}
		}
		return alliterations;
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
