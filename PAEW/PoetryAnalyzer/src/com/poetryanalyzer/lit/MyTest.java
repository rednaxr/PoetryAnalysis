package com.poetryanalyzer.lit;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;

class MyTest {

	@BeforeAll
	static void setUpBeforeClass() {
	}

	@Test
	void test() {
		Assert.assertEquals(true, true);
		runExample();
	}
	public void runExample(){
		// construct the URL to the Wordnet dictionary directory
		String path = ""+File.separator;
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
