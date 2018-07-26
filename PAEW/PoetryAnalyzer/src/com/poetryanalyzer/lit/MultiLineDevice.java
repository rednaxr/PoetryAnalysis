package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class MultiLineDevice extends Device {
	
	public MultiLineDevice () {
		
	}
	
	public static ArrayList<MultiLineDevice> checkAnaphora (Line[] lines) {
		
		ArrayList<MultiLineDevice> AnaphoraInstances = new ArrayList<MultiLineDevice>();
		int anaInsIterator = 0; //AnaphoraInstanceIterator
		
		String lastWord = lines[0].getText();
		
		for (int n = 1; n < lines.length; n++) {
			if (lines[n].getWords()[0].getText().equals(lastWord)) {
				AnaphoraInstances.add(new MultiLineDevice());
				AnaphoraInstances.get(anaInsIterator).setText(lastWord);
				AnaphoraInstances.get(anaInsIterator).getIndices().add(n);
			}
		}
		
		
		
		return AnaphoraInstances;
	}
}
