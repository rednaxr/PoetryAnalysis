package com.poetryanalyzer.lit;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import edu.mit.jwi.*;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;

public class StructuralAnalysis {
    private Poem poem;
    public ArrayList<Word> wordList = new ArrayList<Word>();
    
	public StructuralAnalysis(ArrayList<String> poemLines) {
		//Initialize poem, parsing it into lines and words and finding pronunciation of each word
		poem = new Poem(poemLines);
		
		//Calculate Scansion
		///*
		ArrayList<Scansion> scansion = new ArrayList<Scansion>();							//(stores possible scansions)
		ArrayList<ArrayList<Boolean>> baseList = new ArrayList<ArrayList<Boolean>>();		//(stores known pieces of scansion (from polysyllabic words))
		ArrayList<int[]> holeList = new ArrayList<int[]>();									//(stores the indecies of syllables with unknown scansion)
		int[][] holes;																		//(stores the indecies of syllables with unknown scansion)
		boolean[][] stress;																	//(stores stresses of current scansion being worked with)
		int unknownCount = 0;																//(stores number of syllables with unknown scansion)
		byte[] unknowns;																	//(stores current stress values to be tested)
		for(int a = 0; a < poem.getLines().length; a++) {							//go through each word of each line
			for(int b = 0; b < poem.getLines()[a].getWords().length; b++) {
				if(poem.getLines()[a].getWords()[b].getStress().length > 1) {		//if it's polysyllabic, add it's scansion to that of the line
					for(int c = 0; c < poem.getLines()[a].getWords()[b].getStress().length; c++) {		//(stressed = 1, unstressed = 0)
						baseList.get(a).add(poem.getLines()[a].getWords()[b].getStress()[c] != 0);
					}
				}
				else {																//if it's monosyllabic, mark syllable as unknown scansion (-1)
					baseList.get(a).add(false);
					holeList.add(new int[2]);										//(including storing in the unknown index list)
					holeList.get(holeList.size()-1)[0] = a;
					holeList.get(holeList.size()-1)[1] = baseList.get(a).size() - 1;
					unknownCount++;
				}
			}
		}
		
		stress = new boolean[baseList.size()][];										//convert base and hole ArrayLists to arrays
		for(int a = 0; a < baseList.size(); a++) {
			stress[a] = new boolean[baseList.get(a).size()];
			for(int b = 0; b < baseList.get(a).size(); b++) {
				stress[a][b] = baseList.get(a).get(b);
			}
		}
		holes = new int[holeList.size()][2];
		for(int i = 0; i < holeList.size(); i++) {
			holes[i][0] = holeList.get(i)[0];
			holes[i][1] = holeList.get(i)[1];
		}
		
		scansion.add(new Scansion(stress));											//save base as a scansion at the beginning of the list
		
		for(int a = 0; a < (int) Math.pow(2, holes.length); a++) {					//create a scansion for every possible combo of stresses on monosyllabic words
			int n = a;
			for(int b = 0; b < holes.length; b++) {									//go through each hole (monosyllabic word)
				stress[holes[b][0]][holes[b][1]] = (n%2 == 1);						//assign it a digit of the binary form of the number of the scantion we're on
				n /= 2;
			}
			scansion.add(new Scansion(stress));										//add the scansion to the list and reset the stress array
			scansion.get(scansion.size() - 1).buildMeter();
			stress = scansion.get(0).getStress();
		}
		//*/
		
		//TODO: Evaluate and Rank Scansions
		
		//find Rhyme Scheme of Poem
		String[] endRhymes = new String[poem.getLines().length];		//stores rhyme relevant part of each line (last stressed vowel onward)
		int[] rhymeScheme = new int[poem.getLines().length];			//stores numbers corresponding to each unique rhyme, in order
		int n = 1;														//Stores number of rhymes found so far (serves as rhyme number to identify rhyming lines)
		boolean match;													//stores whether another rhyme of the same kind has been found
		for(int i = 0; i < poem.getLines().length; i++) {
			if(poem.getLines()[i].getWords().length > 0) {					//(ignoring blank lines)
				endRhymes[i] = poem.getLines()[i].getEndRhyme();			//get the rhyme-relevant sound at the end of each line
				if(endRhymes[i] != null) {
					match = false;
					for(int j = 0; j < i; j++) {								//check if it matches any others
						if(endRhymes[i].equals(endRhymes[j])) {
							rhymeScheme[i] = rhymeScheme[j];					//if it does, give it the same rhyme number as the one it matches
							match = true;
							j = i;
						}
					}
					if(match == false) {										//if it doesn't, give it it's own rhyme number
						rhymeScheme[i] = n;											//(and increase the rhyme number for the next one)
						n++;
					}
				}
				else rhymeScheme[i] = 0;
			}
		}
		poem.setRhymeScheme(rhymeScheme);								//store the acquired rhymescheme in the poem
		
	}
	
	public Poem getPoem() {
		return poem;
	}

	public void setPoem(Poem poem) {
		this.poem = poem;
	}
	
	/*
	public Line AnalyzeLine (String line) {
		
		ArrayList<Word> lineList = new ArrayList<Word>();
		int startIndex = 0;
		var startOfWord = true;
		var alliterating = true;
		ArrayList<SoundDevice> alliterationLocations = new ArrayList<SoundDevice>();
		for (int endIndex = 0; endIndex < line.length(); endIndex++){
			
		    char c = line.charAt(endIndex);
		    //TODO find common words, rhymes, alliteration
		    if(c == ' ') {

			    if(!startOfWord) {
			    	//TODO: search lexical database
			    	String currentWord = line.substring(startIndex, endIndex);
			    	var word = new Word(currentWord);
			    	wordList.add(word);
			    }
		    	startIndex = endIndex+1;
		    }
		    else {
		    	//This checks for alliteration. It ain't pretty but it's efficient.
		    	 if(alliterating) {
	    			 var currentText = line.substring(startIndex, endIndex);
	    			 var foundMatch = false;
		    		 for(Word word:lineList ) {
		    			 var wordText = word.getText().substring(startIndex, endIndex);
		    			 if(wordText.equals(currentText)) {
		    				 foundMatch = true;
		    			 }
		    		 }
		    		 alliterating = foundMatch;
		    		 //alliterationEnd = endIndex;
		    	 }
		    }
		    //TODO word counts
		}
		var ProcessedLine = new Line(lineList);
		//ProcessedLine.Immediate.Alliteration = alliteration;
		return ProcessedLine;
	}
	*/
	
	public void runExample(){
		// construct the URL to the Wordnet dictionary directory
		String wnhome = System.getenv("WNHOME");
		String path = wnhome + File.separator + "dict";
		URL url = null;
	    try{ url = new URL("file", null, path); } 
	    catch(MalformedURLException e){ e.printStackTrace(); }
	    if(url == null) return;
		    
	    // construct the dictionary object and open it
		IDictionary dict = new Dictionary(url);
		try {
				dict.open();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		    // look up first sense of the word "dog"
		    IIndexWord idxWord = dict.getIndexWord("dog", POS.NOUN);
		    IWordID wordID = idxWord.getWordIDs().get(0);
		    IWord word = dict.getWord(wordID);
		    System.out.println("Id = " + wordID);
		    System.out.println("Lemma = " + word.getLemma());
		    System.out.println("Gloss = " + word.getSynset().getGloss());
		
		  }


}
