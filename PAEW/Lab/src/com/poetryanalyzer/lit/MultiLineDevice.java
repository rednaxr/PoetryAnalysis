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
		
		for (int p = anaphoraInstances.size() - 1; p >= 0; p--) {	//removes anaphora instances with only 
			if (anaphoraInstances.get(p).getIndices().size() == 1)	//_one index, i.e., non-anaphoras
				anaphoraInstances.remove(p);
		}
		
		for (int u = 0; u < anaphoraInstances.size(); u++) {
			
		}
		
		/*for (MultiLineDevice a : anaphoraInstances) {
			System.out.println("Text" + a.getText());
			for (int i : a.getIndices()) {
				System.out.println("Index: " + i);
			}
			System.out.println();
		}*/
		
		return anaphoraInstances;
	}
}
