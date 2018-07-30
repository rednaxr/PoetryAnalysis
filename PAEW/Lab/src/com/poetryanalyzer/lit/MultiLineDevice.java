package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class MultiLineDevice extends Device {
	
	public MultiLineDevice () {
		
	}
	
	public static ArrayList<MultiLineDevice> checkAnaphora (Line[] lines) {		//looks for anaphora (words/phrases repeated at the beginning of each line for poetic effect)
																																//>for poetic effect)
		ArrayList<MultiLineDevice> anaphoraInstances = new ArrayList<MultiLineDevice>(); //stores instances
		ArrayList<String> anaphoricWords = new ArrayList<String>(); 					 //stores first words of instances
		
		for (int i = 0; i < lines.length; i++) {					//for each line
			String firstWord = lines[i].getWords()[0].getText();	//get the first word
			
			if (!anaphoricWords.contains(firstWord)) {				//is the first word unique?
				anaphoricWords.add(firstWord);						//the word is uniuqe, add it as a potential anaphora
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
		
		for (MultiLineDevice a : anaphoraInstances) {
			int minWords = Integer.MAX_VALUE;
			
			for (int i : a.getIndices())
				if (lines[i].getWords().length < minWords)
					minWords = lines[i].getWords().length;
			
			for (int w = 1; w < minWords; w++) {
				String nextWord = lines[a.getIndices().get(0)].getWords()[w].getText();
				for (int i : a.getIndices()) {
					if (!lines[i].getWords()[w].getText().equals(nextWord)) {
						break;
					}
				}
				a.setText(a.getText() + " " + nextWord);
			}
		}
		
		for (MultiLineDevice a : anaphoraInstances) {
			System.out.println("Text: " + a.getText());
			for (int i : a.getIndices()) {
				System.out.println("Index: " + i);
			}
			System.out.println();
		}
		
		return anaphoraInstances;
	}
}
