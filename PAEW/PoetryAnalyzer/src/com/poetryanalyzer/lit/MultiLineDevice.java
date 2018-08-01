package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class MultiLineDevice extends Device {
	private static final String[] conjuncs = {"and", "or", "but", "nor", "for", "yet", "so"}; //common conjunctions
	
	public MultiLineDevice () {
		
	}
	
	public static ArrayList<MultiLineDevice> checkAnaphora (Line[] lines) {		//looks for anaphora (words/phrases repeated at the
																						     //>beginning of each line for poetic effect)
		ArrayList<MultiLineDevice> anaphoraInstances = new ArrayList<MultiLineDevice>(); //stores instances
		ArrayList<String> anaphoricWords = new ArrayList<String>(); 					 //stores first words of instances

		for (int i = 0; i < lines.length; i++) {					//for each line
			String firstWord = lines[i].getWords()[0].getText();	//get the first word

			if (!anaphoricWords.contains(firstWord)) {		 		//is the first word unique?
				anaphoricWords.add(firstWord);						//the word is uniuqe, add it as a potential anaphora
				anaphoraInstances.add(new MultiLineDevice());						      		 //create an new anaphora instance
				anaphoraInstances.get(anaphoraInstances.size() - 1).setText(firstWord);		 //assign it its text
				anaphoraInstances.get(anaphoraInstances.size() - 1).getIndices().add(i);;	 //assign it its index
			} else {	//the word isn't unique
				anaphoraInstances.get(anaphoricWords.indexOf(firstWord)).getIndices().add(i);//add its index to the list of indices for that word
			}
		}

		for (int i = anaphoraInstances.size() - 1; i >= 0; i--) {	//removes anaphora instances with only one index, i.e., non-anaphoras
			if (anaphoraInstances.get(i).getIndices().size() == 1)	
				anaphoraInstances.remove(i);
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
		
		return anaphoraInstances; //return an ArrayList of MultiLineDevices, where each MultiLineDevice is an anaphora 
	}
	
	public static ArrayList<MultiLineDevice> checkPolysyndeton (Line[] lines) { //looks for polysyndeton (many of the same conjunction
																								//>used in a sentence to create a sense of overwhelming emotion, being overwhelmed, etc.
		ArrayList<MultiLineDevice> polysyndetonInstances = new ArrayList<MultiLineDevice>();
		
		String conjuncBuscar = ""; 	//the conjunction "to look for" (buscar), the word that might turn out to be an instance of polysyndeton
		int    conjuncInstances = 0;//a count of how many times this instance appears
		
		for (int i = 0; i < lines.length; i++) { 								//for each line...
			for (int w = 0; w < lines[i].getWords().length; w++) {				//look at each word...
				String text = lines[i].getWords()[w].getText().toLowerCase();	//stores this word in lowercase...
			    if (conjuncBuscar.equals("")) {								//if there isn't a canidate for a polysyndeton (the starting case)
			    	for (String conjunc : conjuncs) {								//look to see if the current word is a select conjunction
			    		if (text.equals(conjunc)) {									//if so assign it to conjuncBuscar and add one recorded instance
			    			conjuncBuscar = text;
			    			conjuncInstances++;
			    			break;
			    		}
			    	}
			    } else if (text.equals(conjuncBuscar)) {					//if the current word is another instance of the current candidate
			    	conjuncInstances++;										//increment the counter
			    	if (conjuncInstances == 3) {							//3 is the threshold for what is and isn't considered a polysyndeton
			    		polysyndetonInstances.add(new MultiLineDevice());														//]
			    		polysyndetonInstances.get(polysyndetonInstances.size() - 1).setText(conjuncBuscar);						//] - create a polysyndeton ins.
			    		ArrayList<Integer> indices = polysyndetonInstances.get(polysyndetonInstances.size() - 1).getIndices();	
			    		for (int x = 0; x <= w; x++) {
			    			String pastWord = lines[i].getWords()[x].getText();
			    			if (pastWord.equals(conjuncBuscar)) {					//iterate throught the string traversed so far and add indices of the poly.
			    				indices.add(x);
			    			}
			    		}
			    	} else if (conjuncInstances > 3) {	
			    		polysyndetonInstances.get(polysyndetonInstances.size() - 1).getIndices().add(w); //if another instance of the polysyndeton add to the indices again
			        }
			    } else if (!conjuncBuscar.equals("")) {
			    	for (String conjunc : conjuncs) {
			    		if (text.equals(conjunc)) {	//if the word equals a conjunction but not the current conjunction, cancel the current conjunction
			    			conjuncBuscar = "";
			    			conjuncInstances = 0;
			    		}
			    	}
			    }
		    } 
		}
	
		return polysyndetonInstances; //return an ArrayList of MultiLineDevices, where each MultiLineDevice is a polysyndeton
	}
}
