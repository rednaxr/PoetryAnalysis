package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class Scansion {
	
	//Atributes
	private byte[][] stress;					//(stores all the stresses in the poem according to this scansion)
	private byte[] meterType;					//(stores the meter type (ex: loose iambic) of each line)
	private int[] footCount;					//(stores the number of feet (ex: 4) in each line)
	private int OverallMeterType;				//(stores type of meter, eg. loose iambic)
	private int OverallFootCount;				//(stores number of feet per line, eg. tetrameter)
	
	public static final byte IAMBIC = 1;
	public static final byte LOOSE_IAMBIC = 2;
	public static final byte ANAPESTIC = 3;
	public static final byte TROCHAIC = 4;
	public static final byte LOOSE_TROCHAIC = 5;
	public static final byte DACTYLIC = 6;
	
	public Scansion(byte[][] stress) {
		this.stress = stress;
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
	
}
