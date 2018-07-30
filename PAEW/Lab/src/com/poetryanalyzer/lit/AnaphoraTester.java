package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class AnaphoraTester {

	public AnaphoraTester (Line[] poemLines) {
		MultiLineDevice.checkAnaphora(poemLines);
	}

	public static void main (String[] args) {
		ArrayList<String> poem = new ArrayList<String>();
		
		/*poem.add("Two roads diverged in a yellow wood");
		poem.add("And sorry I could not travel both");
		poem.add("And be one traveler long I stood");
		poem.add("And looked down one as far as I could");
		poem.add("To where it bent in the undergrowth");*/
		
		poem.add("For want of a nail the shoe was lost.");
		poem.add("For want of a shoe the horse was lost.");
		poem.add("For want of a horse the rider was lost.");
		poem.add("For want of a rider the message was lost.");
		poem.add("For want of a message the battle was lost.");
		poem.add("For want of a battle the kingdom was lost.");
		poem.add("And all for the want of a horseshoe nail");
		
		Line[] poemLines = new Line[poem.size()];
		
		for (int x = 0; x < poemLines.length; x++) {
			poemLines[x] = new Line (poem.get(x));
		}
		
		for (Line x : poemLines) { System.out.println(x.getText()); } //TESTING
		System.out.println(); //TESTING
		
		AnaphoraTester anaphoraTester = new AnaphoraTester (poemLines);
	}
}
