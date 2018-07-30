package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class Scantion {
	
	byte[][] stress;

	public Scantion(ArrayList<ArrayList<Byte>> input) {
		stress = new byte[input.size()][];
		for(int a = 0; a < input.size(); a++) {
			stress[a] = new byte[input.get(a).size()];
			for(int b = 0; b < input.get(a).size(); b++) {
				stress[a][b] = input.get(a).get(b);
			}
		}
	}

	public int getScore() {
		int score = 0;
		return score;
	}
	
}
