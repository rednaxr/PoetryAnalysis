package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class Scansion {
	
	int meterType;
	int feet;
	byte[][] stress;
	
	public Scansion(ArrayList<ArrayList<Byte>> input) {
		stress = new byte[input.size()][];
		for(int a = 0; a < input.size(); a++) {
			stress[a] = new byte[input.get(a).size()];
			for(int b = 0; b < input.get(a).size(); b++) {
				stress[a][b] = input.get(a).get(b);
			}
		}
	}

	public byte[][] getStress() {
		return stress;
	}
	
	public int getScore() {
		int score = 0;
		return score;
	}
	
	public int getMeterType() {
		return meterType;
	}
	
	public int getFeet() {
		return feet;
	}
	
}
