package com.poetryanalyzer.lit;

import java.util.ArrayList;

public abstract class Tester {
	
	public Tester (Line[] poemLines) {
		
	}
	
	public static void main (String[] args) {
		ArrayList<String> poem = new ArrayList<String>();
		
		//ANAPHORA_1
		/*poem.add("Two roads diverged in a yellow wood");
		poem.add("And sorry I could not travel both");
		poem.add("And be one traveler long I stood");
		poem.add("And looked down one as far as I could");
		poem.add("To where it bent in the undergrowth");*/
		
		//ANAPHORA_2
		/*poem.add("Out of the cradle endlessly rocking,");
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
		poem.add("From such as now they start the scene revisiting,...");*/
		
		//POLYSYNDETON
		poem.add("And God said, \"Let the earth bring forth the living creature after his kind, cattle, and creeping thing, and beast of the earth after his kind.\"");
		poem.add("And it was so.");
		poem.add("And God made the beast of the earth after his kind and cattle after their kind, and everything that creeps upon the earth to its kind. ");
		poem.add("And God saw that it was good.");
		
		Line[] poemLines = new Line[poem.size()];
		
		for (int x = 0; x < poemLines.length; x++) {
			poemLines[x] = new Line (poem.get(x));
		}
		
		for (Line x : poemLines) { System.out.println(x.getText()); } //TESTING
		System.out.println(); //TESTING
		
		AnaphoraTester anaphoraTester = new AnaphoraTester (poemLines);
	}
	
	public abstract void display ();
		
}
