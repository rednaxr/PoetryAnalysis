package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class AnaphoraTester {

	public AnaphoraTester (Line[] poemLines) {
		display(MultiLineDevice.checkAnaphora(poemLines));
	}

	public static void main (String[] args) {
		ArrayList<String> poem = new ArrayList<String>();
		
		/*poem.add("Two roads diverged in a yellow wood");
		poem.add("And sorry I could not travel both");
		poem.add("And be one traveler long I stood");
		poem.add("And looked down one as far as I could");
		poem.add("To where it bent in the undergrowth");*/
		
		poem.add("Out of the cradle endlessly rocking,");
		poem.add("Out of the mock-bird's throat, the musical shuttle,");
		poem.add("Out of the Ninth-month midnight,");
		poem.add("Over the sterile sands, and the fields beyond, where the child, leaving his bed, wander'd alone, bare-headed, barefoot,");
		poem.add("Down from the shower'd halo,");
		poem.add("Up from the mystic play of shadows twining and twisting as if they were alive,");
		poem.add("Out from the patches of briers and blackberries,");
		poem.add("From the memories of the bird that chanted to me,");
		poem.add("From your memories, sad brother, from the fitful risings and fallings I heard,");
		poem.add("From under that yellow half-moon late-risen and swollen as if with tears,");
		poem.add("From those beginning notes of yearning and love, there in the transparent mist,");
		poem.add("From the thousand responses of my heart never to cease,");
		poem.add("From the myriad thence-arous'd words,");
		poem.add("From the word stronger and more delicious than any,");
		poem.add("From such as now they start the scene revisiting,...");
		
		Line[] poemLines = new Line[poem.size()];
		
		for (int x = 0; x < poemLines.length; x++) {
			poemLines[x] = new Line (poem.get(x));
		}
		
		for (Line x : poemLines) { System.out.println(x.getText()); } //TESTING
		System.out.println(); //TESTING
		
		AnaphoraTester anaphoraTester = new AnaphoraTester (poemLines);
	}
	
	public void display (ArrayList<MultiLineDevice> anaphoraInstances) {
		for (MultiLineDevice a : anaphoraInstances) {
			System.out.println("Text: " + a.getText());
			System.out.println("Intensity: " + a.getIntensity());
			System.out.println();
			for (int i : a.getIndices()) {
				System.out.println("Index: " + i);
			}
			System.out.println(); 
		}
	}
	
	//jun seba nujabes
}
