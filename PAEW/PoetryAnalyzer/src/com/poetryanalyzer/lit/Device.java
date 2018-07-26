package com.poetryanalyzer.lit;

import java.util.ArrayList;

public abstract class Device {
	private ArrayList<Integer> indices; 	//the indices of a specific literary device within the poem
	private int intensity; 					//strength literary device in poem, based on occurrence rate and other factors
	
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
	
}
