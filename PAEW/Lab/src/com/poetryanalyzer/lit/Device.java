package com.poetryanalyzer.lit;

import java.util.ArrayList;

public abstract class Device {
	private String text;													//text of the specific literary device instance
	private ArrayList<Integer> indices = new ArrayList<Integer>(); 			//the indices of a specific literary device within the poem
	private int intensity; 													//strength literary device in poem, based on occurrence rate and other factors
	
	public Device () {
		
	}
	
	public int getIntensity() {
		return intensity;
	}

	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}

	public ArrayList<Integer> getIndices() {
		return indices;
	}

	public void setIndices(ArrayList<Integer> indices) {
		this.indices = indices;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
