package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class AnaphoraTester {

	public AnaphoraTester (Line[] poemLines) {
		MultiLineDevice.checkAnaphora(poemLines);
	}

	public static void main (String[] args) {
		ArrayList<String> poem = new ArrayList<String>();
		poem.add("Two roads diverged in a yellow wood");
		poem.add("And sorry I could not travel both");
		poem.add("And be one traveler long I stood");
		poem.add("And looked down one as far as I could");
		poem.add("To where it bent in the undergrowth");
		Line[] poemLines = new Line[poem.size()];
		for (int x = 0; x < poemLines.length; x++) {
			poemLines[x] = new Line (poem.get(x));
		}
		
		/*for (Line x : poemLines) {
			x.displayLine();
			System.out.println();
		}*/
		
		
		AnaphoraTester anaphoraTester = new AnaphoraTester (poemLines);
	}
}
