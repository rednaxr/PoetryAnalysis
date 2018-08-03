package com.poetryanalyzer.lit;

import java.util.ArrayList;

public abstract class Device {
	private String text;																	//text of the specific literary device instance
	private ArrayList<ArrayList<Integer>> indices = new ArrayList<ArrayList<Integer>>(); 	//(arraylist of lines (arraylist of word indices) )
	private int intensity; 																	//strength literary device in poem, based on occurrence rate and other factors
	
	public Device () {
		
	}
	
	public int getIntensity() {
		return intensity;
	}

	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}

	public ArrayList<ArrayList<Integer>> getIndices() {
		return indices;
	}

	
	
	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
