//Class for Alliteration, Assonance, Consonance, and Rhyme
//25 July 2018

package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class SoundDevice extends Device {
	
	//NON-STATIC----------------------------------------------
	
	//Attributes
	private String sound;						//sound(s) being repeated in Sound Device
	private int depth;							//number of vowel and/or consonant sounds repeated
	private ArrayList<Integer> indices;		    //locations of those sounds (which word)
	private int strength;						//strength of the device (1-100)
	
	
	public SoundDevice(String sound){
		this.sound = sound;
		ArrayList<Integer> indices = new ArrayList<Integer>();
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

	public ArrayList<Integer> getIndices() {
		return indices;
	}

	public void setIndecies(ArrayList<Integer> indices) {
		this.indices = indices;
	}
	
	//STATIC---------------------------------------------------------------------------
	
	//finds all instances of alliteration in list of words, reporting  sound, indices, and depth of alliteration
	public static ArrayList<ArrayList<SoundDevice>> checkAlliteration(ArrayList<Word> words) {
		ArrayList<ArrayList<SoundDevice>> output = new ArrayList<ArrayList<SoundDevice>>();
		ArrayList<SoundDevice> alliterations = new ArrayList<SoundDevice>();			//Stores instances of alliteration
		ArrayList<SoundDevice> homophones = new ArrayList<SoundDevice>();				//Stores homophones (sound of entire word is the same)
		ArrayList<SoundDevice> potential = new ArrayList<SoundDevice>();				//Stores potential alliterations longer than first sound
		String sound;																	//Stores sound in question
		boolean contains;																//Stores whether ArrayList contains SoundDevice in question
		
		//**Alliterations of 1st Sound**
		//Record each starting sound and their indices as instances of alliteration (aka alliterations)
		for(int a = 0; a < words.size(); a++) {
			sound = words.get(a).getSound()[0];												//take first sound from each word
			contains = false;
			for(int b = 0; b < alliterations.size(); b++) {									//check if that sound matches any in an existing instance of alliteration
				if(alliterations.get(b).getSound().equals(sound)) {
					alliterations.get(b).getIndices().add(a);								//if so, add the index of the word to the alliteration and record a match
					contains = true;
				}
			}
			if(contains == false){															//if the sound does not match an existing alliteration
				alliterations.add(new SoundDevice(sound));									//add an alliteration with that sound...
				alliterations.get(alliterations.size() - 1).getIndices().add(a);			//...the index of the word
				alliterations.get(alliterations.size() - 1).setDepth(1);					//...and a depth of 1
			}
		}
		
		//Remove each alliteration with only one index
		for(int a = 0; a < alliterations.size(); a++) {
			if(alliterations.get(a).getIndices().size() == 1) {
				alliterations.remove(a);
			}
		}
			
		//**Alliterations of two or more sounds**
		int i = 0;																		//Iterator
		int n = alliterations.size();													//Stores number of alliterations in array (gets updated during while loop)
		int index;																		//Stores index of word in question
		while(i < n) {
			//for an alliteration, create an ArrayList of each sound combo (1 sound longer than the sound of the alliteration) with frequencies
			for(int a = 0; a < alliterations.get(i).getIndices().size(); a++) {				//for each index of the alliterations:
				index = alliterations.get(i).getIndices().get(a);									//find the index of the word in which the alliteration occurs
				if(words.get(index).getSound().length > alliterations.get(i).getDepth()) {			//if we are not at the end of the word
					sound = alliterations.get(i).getSound() + words.get(index).getSound()[alliterations.get(i).getDepth()];  //add in the next sound of the word
					contains = false;
					for(int b = 0; b < potential.size(); b++) {						//if the combined sound is contained among potential new alliterations
						if(potential.get(b).getSound().equals(sound)) {
							potential.get(b).getIndices().add(index);				//add the index of the word in question
							contains = true;
						}
					}
					if(contains == false) {											//if not, add the new sound 
						potential.add(new SoundDevice(sound));
						potential.get(potential.size() - 1).setDepth(alliterations.get(i).getDepth() + 1);	  //with depth 1 greater than the alliteration it extends
						potential.get(potential.size() - 1).getIndices().add(a);							  //and add it's index
					}
				}
			}
			//remove each sound combo with only one occurrence
			for(int a = 0; a < potential.size(); a++) {
				if(potential.get(a).getIndices().size() == 1) {
					potential.remove(a);
				}
				else {
					//check if instance of alliteration is actually merely homophones
					boolean AllHomophones = true;
					for(int b = 0; b < potential.get(a).getIndices().size(); b++) {		//for each index of the word
						String[] wordSounds = words.get(potential.get(a).getIndices().get(b)).getSound();
						sound = "";
						for(int c = 0; c < wordSounds.length; c++) {		//store the sound of the word as a string
							sound += wordSounds[c];
						}
						if(!potential.get(a).getSound().equals(sound)) {	//if the sound of the alliteration and the word are not the same
							AllHomophones = false;							//we're not talking all homophones
						}
					}
					//if not all homophones, add potential alliteration to alliteration list
					if(AllHomophones == false) {
						alliterations.add(potential.get(a));
					}
					//if all homophones, add potential alliteration to the homophones list
					else {
						homophones.add(potential.get(a));
					}
				}
			}
			n = alliterations.size();		//update the size of the ArrayList
			i++;							//proceed to the next alliteration
		}
		output.add(alliterations);
		output.add(homophones);
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
