//Class for Alliteration, Assonance, Consonance, and Rhyme
//25 July 2018

package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class SoundDevice extends Device {
	
	//NON-STATIC----------------------------------------------
	
	//Attributes
	private String sound;						//sound(s) being repeated in Sound Device
	private int depth;							//number of vowel and/or consonant sounds repeated
	
	public SoundDevice(String sound){
		super();
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
	
	//STATIC---------------------------------------------------------------------------
	
	//finds all instances of alliteration in list of words, reporting  sound, indices, and depth of alliteration
	public static ArrayList<SoundDevice> checkAlliteration(Word[] words) {
		ArrayList<SoundDevice> alliterations = new ArrayList<SoundDevice>();			//Stores instances of alliteration
		//ArrayList<SoundDevice> homophones = new ArrayList<SoundDevice>();				//Stores homophones (sound of entire word is the same)
		ArrayList<SoundDevice> potential = new ArrayList<SoundDevice>();				//Stores potential alliterations longer than first sound
		String sound;																	//Stores sound in question
		boolean contains;																//Stores whether ArrayList contains SoundDevice in question
		
		//**Alliterations of 1st Sound**
		//Record the starting sound of each word and their indices as instances of alliteration (aka alliterations)
		for(int a = 0; a < words.length; a++) {
			sound = words[a].getSound()[0];													//take first sound from each word
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
		
		//Remove each alliteration that only occurs once (b/c its not really alliteration)
		for(int a = alliterations.size() - 1; a > -1; a--) {
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
				if(words[index].getSound().length > alliterations.get(i).getDepth()) {			//if we are not at the end of the word
					sound = alliterations.get(i).getSound() + words[index].getSound()[alliterations.get(i).getDepth()];  //add in the next sound of the word
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
						String[] wordSounds = words[potential.get(a).getIndices().get(b)].getSound();
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
						//homophones.add(potential.get(a));
					}
				}
			}
			n = alliterations.size();		//update the size of the ArrayList
			i++;							//proceed to the next alliteration
		}
		//output.add(alliterations);
		//output.add(homophones);
		return alliterations;
		
	}
	
	//finds instances of assonance in a Word[]
	public static SoundDevice[] checkAssonance(Word[] words) {
		SoundDevice[] output = null;														//(stores final output: Array of SoundDevices)
		ArrayList<String> vowelSounds = new ArrayList<String>();							//(stores vowel sounds found in Word[])
		ArrayList<ArrayList<Integer>> indices = new ArrayList<ArrayList<Integer>>();		//(stores indecies of vowel sounds found)
		for(int a = 0; a < words.length; a++) {												//go through each vowel sound in Word[]
			for(int b = 0; b < words[a].getVowels().length; b++) {
				if(!vowelSounds.contains(words[a].getVowels()[b])) {						//If it's not yet in the list of vowel sounds...
					vowelSounds.add(words[a].getVowels()[b]);								//...add it to the list and record its index
					indices.add(new ArrayList<Integer>());
					indices.get(indices.size()-1).add(a);
				}
				else {																		//If it is already in the list...
					indices.get(vowelSounds.indexOf(words[a].getVowels()[b])).add(a);		//...record another index for the vowel sound
				}
			}
		}
		for(int a = vowelSounds.size() - 1; a > -1; a++) {									//remove all vowel sounds that only occur once
			if(indices.get(a).size() < 2) {														//(remaining vowel sounds are cases of assonance)
				indices.remove(a);
				vowelSounds.remove(a);
			}
		}
		output = new SoundDevice[vowelSounds.size()];										//create a SoundDevice[] of te assonance cases...
		for(int a = 0; a < output.length; a++) {
			output[a] = new SoundDevice(vowelSounds.get(a));								//...by feeding in the sound and indecies of each repeated vowel sound
			output[a].setIndices(indices.get(a));
		}
		return output;
	}
	
	//finds instances of consonance in a given Word[]
	public static SoundDevice[] checkConsonance(Word[] words) {
		SoundDevice[] output = null;														//(stores final output: Array of SoundDevices)
		ArrayList<String> consonantSounds = new ArrayList<String>();						//(stores consonant sounds found in Word[])
		ArrayList<ArrayList<Integer>> indices = new ArrayList<ArrayList<Integer>>();		//(stores indices of consonant sounds found)
		for(int a = 0; a < words.length; a++) {												//go through each consonant sound in Word[]
			for(int b = 0; b < words[a].getConsonants().length; b++) {
				if(!consonantSounds.contains(words[a].getConsonants()[b])) {						//If it's not yet in the list of vowel sounds...
					consonantSounds.add(words[a].getConsonants()[b]);								//...add it to the list and record its index
					indices.add(new ArrayList<Integer>());
					indices.get(indices.size()-1).add(a);
				}
				else {																				//If it is already in the list...
					indices.get(consonantSounds.indexOf(words[a].getConsonants()[b])).add(a);		//...record another index for the vowel sound
				}
			}
		}
		for(int a = consonantSounds.size() - 1; a > -1; a++) {									//remove all consonant sounds that only occur once
			if(indices.get(a).size() < 2) {														//(remaining consonant sounds are cases of assonance)
				indices.remove(a);
				consonantSounds.remove(a);
			}
		}
		output = new SoundDevice[consonantSounds.size()];										//create a SoundDevice[] of te assonance cases...
		for(int a = 0; a < output.length; a++) {
			output[a] = new SoundDevice(consonantSounds.get(a));								//...by feeding in the sound and indices of each repeated vowel sound
			output[a].setIndices(indices.get(a));
		}
		return output;
	}
	
}
