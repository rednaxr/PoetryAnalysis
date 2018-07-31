package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class Scansion {
	
	//Atributes
	private byte[][] stress;						//(stores all the stresses in the poem according to this scansion)
	private ArrayList<ArrayList<Byte>> feet;		//(stores the feet of the poem);
	private byte[] meterType;						//(stores the meter type (ex: loose iambic) of each line)
	private int[] footCount;						//(stores the number of feet (ex: 4) in each line)
	private int OverallMeterType;					//(stores type of meter, eg. loose iambic)
	private int OverallFootCount;					//(stores number of feet per line, eg. tetrameter)
	
	//Feet
	public static final byte IAMB = 1;				//   U /
	public static final byte TROCHEE = 2;			//   / U
	public static final byte PYRRHUS = 3;			//   U U
	public static final byte SPONDEE = 4;			//   / /
	public static final byte ANAPEST = 5;			//   U U /
	public static final byte DACTYL = 6;			//   / U U
	public static final byte AMPHIBRACH = 7;		//   U / U
	public static final byte BACCHIUS = 8;			//   U / / 
	public static final byte ANTIBACCHIUS = 9;		//   / / U
	public static final byte CRETIC = 10;			//   / U /
	public static final byte MOLOSSUS = 11;			//   / / / 
	
	//Static Integers
	public static final byte UNKNOWN = -1;
	public static final byte OTHER = 0;
	public static final byte IAMBIC = 1;
	public static final byte LOOSE_IAMBIC = 2;
	public static final byte ANAPESTIC = 3;
	public static final byte TROCHAIC = 4;
	public static final byte LOOSE_TROCHAIC = 5;
	public static final byte DACTYLIC = 6;
	
	//CONSTRUCTOR
	public Scansion(byte[][] stress) {
		this.stress = stress;
		setFeet(new ArrayList<ArrayList<Byte>>());
		meterType = new byte[stress.length];
		for(int a = 0; a < stress.length; a++) {
			for(int b = 0; b < stress[a].length; b++) {
				
				if(stress[a][b] == 1) {
				}
			}
		}
	}
	
	public int getScore() {
		int score = 0;
		
		return score;
	}

	public byte[][] getStress() {
		return stress;
	}

	public void setStress(byte[][] stress) {
		this.stress = stress;
	}

	public byte[] getMeterType() {
		return meterType;
	}

	public void setMeterType(byte[] meterType) {
		this.meterType = meterType;
	}

	public int[] getFootCount() {
		return footCount;
	}

	public void setFootCount(int[] footCount) {
		this.footCount = footCount;
	}

	public int getOverallMeterType() {
		return OverallMeterType;
	}

	public void setOverallMeterType(int overallMeterType) {
		OverallMeterType = overallMeterType;
	}

	public int getOverallFootCount() {
		return OverallFootCount;
	}

	public void setOverallFootCount(int overallFootCount) {
		OverallFootCount = overallFootCount;
	}

	public ArrayList<ArrayList<Byte>> getFeet() {
		return feet;
	}

	public void setFeet(ArrayList<ArrayList<Byte>> feet) {
		this.feet = feet;
	}
	
}
