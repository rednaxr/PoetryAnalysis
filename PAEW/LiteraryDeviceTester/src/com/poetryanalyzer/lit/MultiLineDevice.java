package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class MultiLineDevice extends Device {
	private static final String[] conjuncs = {"and", "or", "but", "nor", "for", "yet", "so"}; //common conjunctions
	
	public MultiLineDevice () {
		
	}
	
    public static ArrayList<MultiLineDevice> checkAnaphora (Line[] lines) {		//looks for anaphora (words/phrases repeated at the beginning of each line for poetic effect)
																																//>for poetic effect)
		ArrayList<MultiLineDevice> anaphoraInstances = new ArrayList<MultiLineDevice>(); //stores instances
		ArrayList<String> anaphoricWords = new ArrayList<String>(); 					 //stores first words of instances
		
		for (int i = 0; i < lines.length; i++) {					//for each line
			String firstWord = lines[i].getWords()[0].getText();	//get the first word
			
			if (!anaphoricWords.contains(firstWord)) {				//is the first word unique?
				anaphoricWords.add(firstWord);						//the word is unique, add it as a potential anaphora
				anaphoraInstances.add(new MultiLineDevice());						      		 //create an new anaphora instance
				anaphoraInstances.get(anaphoraInstances.size() - 1).setText(firstWord);		 //assign it its text
				anaphoraInstances.get(anaphoraInstances.size() - 1).getIndices().add(i);;	 //assign it its index
			} else {	//the word isn't unique
				anaphoraInstances.get(anaphoricWords.indexOf(firstWord)).getIndices().add(i);//add its index to the list of indices for that word
			}
		}
		
		for (int p = anaphoraInstances.size() - 1; p >= 0; p--) {	//removes anaphora instances with only one index, i.e., non-anaphoras
			if (anaphoraInstances.get(p).getIndices().size() == 1)	
				anaphoraInstances.remove(p);
		}
		
		for (MultiLineDevice a : anaphoraInstances) { //for each instance of anaphora
			int minWords = Integer.MAX_VALUE;				//iterates through each line that contains an instance of this anaphora and
															//-finds the shortest line by words, and stores that number
			for (int i : a.getIndices())					//
				if (lines[i].getWords().length < minWords)	//
					minWords = lines[i].getWords().length;	//
			
			for (int w = 1; w < minWords; w++) {			//checks word by word "deeper", or to the right in the poem
				boolean escape = false;														//-until there is no longer an identical 
				String nextWord = lines[a.getIndices().get(0)].getWords()[w].getText();		//-anaphora on all indices
				for (int i : a.getIndices()) {
					if (!lines[i].getWords()[w].getText().equals(nextWord)) {	//if the words on the ith word column do not match, break
						escape = true;
						break;
					}
				}
				if (escape)
					break;
				else
					a.setText(a.getText() + " " + nextWord); //if the words on the ith word column do match, continue checking to the right
			}																								
		}
		
		return anaphoraInstances; //return an ArrayList of MultiLineDevices, where each MultiLineDevice is a unique anaphora or word phrase
	}																								//with its stored indices

	/*public static ArrayList<MultiLineDevice> checkAnaphora (Line[] lines) {
			
		ArrayList<MultiLineDevice> anaphoraInstances = new ArrayList<MultiLineDevice>();
		ArrayList<String> anaphoricWords = new ArrayList<String>();
		
		for (int i = 0; i < lines.length; i++) {
			String firstWord = lines[i].getWords()[0].getText();
			
			if (!anaphoricWords.contains(firstWord)) {	
				anaphoricWords.add(firstWord);
			}
			
		}
		
		
		return anaphoraInstances; 
	}*/
	
	public static ArrayList<MultiLineDevice> checkPolysyndeton (Line[] lines) {
		
		ArrayList<MultiLineDevice> polysyndetonInstances = new ArrayList<MultiLineDevice>();
		
		String conjuncBuscar = "";
		int    conjuncInstances = 0;
		
		for (int i = 0; i < lines.length; i++) {
			for (int w = 0; w < lines[i].getWords().length; w++) {
				String text = lines[i].getWords()[w].getText().toLowerCase();
			    if (conjuncBuscar.equals("")) {
			    	for (String conjunc : conjuncs) {
			    		if (text.equals(conjunc)) {
			    			conjuncBuscar = text;
			    			conjuncInstances++;
			    			break;
			    		}
			    	}
			    } else if (text.equals(conjuncBuscar)) {
			    	conjuncInstances++;
			    	if (conjuncInstances == 2) {
			    		polysyndetonInstances.add(new MultiLineDevice());
			    		polysyndetonInstances.get(polysyndetonInstances.size() - 1).setText(conjuncBuscar);
			    		ArrayList<Integer> indices = polysyndetonInstances.get;
			    		for (int x = 0; x <= w; x++) {
			    			String pastWord = lines[i].getWords()[x].getText();
			    			if (pastWord.equals(conjuncBuscar)) {
			    				indices.add(x);
			    			}
			    		}
			    	} else if (conjuncInstances > 2) {
			    		polysyndetonInstances.get(polysyndetonInstances.size() - 1).getIndices().add(w);
			        }
			    } else if (!conjuncBuscar.equals("")) {
			    	for (String conjunc : conjuncs) {
			    		if (text.equals(conjunc)) {
			    			conjuncBuscar = "";
			    			conjuncInstances = 0;
			    		}
			    	}
			    }
		    } 
		}
	
		return polysyndetonInstances;
	}
	
	public static ArrayList<MultiLineDevice> checkAsyndeton (Line[] lines) {
		
		ArrayList<MultiLineDevice> asyndetonInstances = new ArrayList<MultiLineDevice>();
		
		boolean comma = false;
		
		for (int i = 0; i < lines.length; i++) {
			for (String s : lines[i].getText().split(" ")) {
				
				
				if (s.contains(",")) {
					
				} else {
					for (String c : conjuncs)
						if (s.equals(c)) {
							
						}
							
				}
			}
		}
		
		return asyndetonInstances;
	}
}
