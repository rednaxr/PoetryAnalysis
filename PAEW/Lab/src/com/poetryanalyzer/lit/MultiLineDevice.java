package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class MultiLineDevice extends Device {
	
	public MultiLineDevice () {
		
	}
	
	public static ArrayList<MultiLineDevice> checkAnaphora (Line[] lines) {
		
		ArrayList<MultiLineDevice> anaphoraInstances = new ArrayList<MultiLineDevice>();
		ArrayList<String> anaphoricWords = new ArrayList<String>();
		
		for (int i = 0; i < lines.length; i++) {
			String firstWord = lines[i].getWords()[0].getText();
			
			if (!anaphoricWords.contains(firstWord)) {
				anaphoricWords.add(firstWord);
				anaphoraInstances.add(new MultiLineDevice());
				anaphoraInstances.get(anaphoraInstances.size() - 1).setText(firstWord);
				anaphoraInstances.get(anaphoraInstances.size() - 1).getIndices().add(i);;
			} else {
				anaphoraInstances.get(anaphoricWords.indexOf(firstWord)).getIndices().add(i);
			}
		  
		}
		
		for (MultiLineDevice a : anaphoraInstances) {
			System.out.println("Text" + a.getText());
			for (int i : a.getIndices()) {
				System.out.println("Index: " + i);
			}
			System.out.println();
		}
		
		return anaphoraInstances;
	}
}
