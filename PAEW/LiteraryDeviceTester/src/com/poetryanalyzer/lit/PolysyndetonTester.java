package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class PolysyndetonTester {

	public PolysyndetonTester (Line[] poemLines) {
		
	}
	
	public void main (String[] args) {
		ArrayList<String> poem = new ArrayList<String>();
		
		poem.add("");
		poem.add("");
		poem.add("");
		poem.add("");
		
		Line[] poemLines = new Line[poem.size()];
		
		for (int x = 0; x < poemLines.length; x++) {
			poemLines[x] = new Line (poem.get(x));
		}
		
		for (Line x : poemLines) { System.out.println(x.getText()); } //TESTING
		System.out.println(); //TESTING
		
		PolysyndetonTester polysyndetonTester = new PolysyndetonTester (poemLines);
	}
	
	public void display (ArrayList<MultiLineDevice> polysyndetonInstances) {
		for (MultiLineDevice a : polysyndetonInstances) {
			System.out.println("Text: " + a.getText());
			System.out.println("Intensity: " + a.getIntensity());
			System.out.println();
			for (int i : a.getIndices()) {
				System.out.println("Index: " + i);
			}
			System.out.println(); 
		}
	}
}
