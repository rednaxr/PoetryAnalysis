package com.poetryanalyzer.lit;

import java.util.ArrayList;

public abstract class Device {
	private ArrayList<Integer> indices; //the indices of a specific literary device within the poem
	private int intensity; //rate of occurrence of literary device in poem
	
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
