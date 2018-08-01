package com.poetryanalyzer.lit;

import java.util.ArrayList;

public class Scansion {
	
	//ATTRIBUTES / DYNAMIC VARIABLES
	private boolean[][] stress;						//(stores all the stresses in the poem according to this scansion)
	private ArrayList<ArrayList<Integer>> feet;		//(stores the feet of the poem);
	private byte[] meterType;						//(stores the meter type (ex: loose iambic) of each line)
	private int[] footCount;						//(stores the number of feet (ex: 4) in each line)
	private int OverallMeterType;					//(stores type of meter, eg. loose iambic)
	private int OverallFootCount;					//(stores number of feet per line, eg. tetrameter)
	
	//STATIC CONSTANTS
	
	public static final byte AMBIGUOUS = -2;				//could be iambic or trochaic, base decision on charactarization of other lines
	public static final byte OTHER = 0;
	public static final byte STRICT_IAMBIC = 1;
	public static final byte LOOSE_IAMBIC = 2;
	public static final byte STRICT_ANAPESTIC = 3;
	public static final byte STRICT_TROCHAIC = 5;
	public static final byte LOOSE_TROCHAIC = 6;
	public static final byte STRICT_DACTYLIC = 7;
	
	//Foot ID's															  index
	public static final byte UNKNOWN = -1;				//     ?
	public static final byte UNSTRESS = 6;				//     U			0
	public static final byte STRESS = 8;				//     /			1
	
	public static final byte PYRRHUS = 12;				//    U U			2
	public static final byte IAMB = 14;					//    U /			3
	public static final byte TROCHEE = 15;				//    / U			4
	public static final byte SPONDEE = 17;				//    / /			5
	
	public static final byte TRIBRACH = 18;				//   U U U			6
	public static final byte ANAPEST = 20;				//   U U /			7
	//public static final byte AMPHIBRACH = 21;			//   U / U
	public static final byte DACTYL = 22;				//   / U U			8
	//public static final byte BACCHIUS = 23;			//   U / /
	//public static final byte CRETIC = 24;				//   / U /
	//public static final byte ANTIBACCHIUS = 25;		//   / / U
	//public static final byte MOLOSSUS = 27;			//   / / /
	
	//CONSTRUCTOR
	public Scansion(boolean[][] stress) {
		this.stress = stress;
		setFeet(new ArrayList<ArrayList<Integer>>());
		meterType = new byte[stress.length];
	}
	
	//DYNAMIC METHODS---------------------------------------------------
	
	public void buildMeter() {
		ArrayList<Boolean> cFoot = new ArrayList<Boolean>();			//(stores the current foot being built/worked with)
		int cFootID = 0;												//(stores the ID of the current foot being worked with
		
		//ID each foot and characterize scansion of each line
		for(int a = 0; a < stress.length; a++) {					//go through each line
			for(int b = stress[a].length - 1; b > -1; b--) {			//go through all stresses in the line, back to front
				if(cFoot.size() < 2) {										//if the current foot is under two syllables, add the current syllable to it
					cFoot.add(stress[a][b]);
				}
				else {														//if the current foot is two or more syllables
					cFootID = 6*cFoot.size();									//calculate which foot it is
					for (int c = 0; c < cFoot.size(); c++) {
						cFootID += bti(cFoot.get(c))*(c+2);
					}
					if((stress[a][b] && cFootID > 12)							//if it's got a stress and we've hit a stressed syllable
							|| (!stress[a][b] && cFootID > 14)					//...or if it's not an iamb or pyrrhus and we've hit an unstressed syllable
							|| cFoot.size() == 3) {								//...or if the foot is three syllables long
						feet.get(a).add(cFootID);								//add the  current foot to the feet ArrayList
						cFoot.clear();												//and start a new foot with the current syllable
						cFoot.add(stress[a][b]);
					}
					else {														//otherwise, add the current syllable to the foot
						cFoot.add(stress[a][b]);
					}
				}
			}
			if(!cFoot.isEmpty()) {												//if the last foot of the line has not been loaded in
				cFootID = 6*cFoot.size();											//calculate which foot it is
				for (int c = 0; c < cFoot.size(); c++) {
					cFootID += bti(cFoot.get(c))*(c+2);
				}
				feet.get(a).add(cFootID);										//load it in to the feet array and reset current foot
				cFoot.clear();
			}
			
			
			//TODO: use int[] feetCount to find the number of each foot in line, characterize line meter type based on dominant foot type/feet
			
		}
		
		
		//Classify meter type of each line
		for(int a = 0; a < feet.size(); a++) {
			for(int b = 0; b < feet.get(a).size(); b++) {
				
			}
		}
		
		//Determine overall meter pattern of poem
		
			//(If poem has overall Trochaic pattern, switch trochaic/iambic ambiguous (1 ... 1) lines to iambic pattern)
			//(If poem has overall Iambic pattern, switch ambiguous lines to iambic) (**is it possible to need this?)
		
		
		
	}
	
	//returns the likelihood that this scansion is the actual scansion of the poem, as raw number
	public int getScore() {
		int score = 0;
		
		return score;
	}

	public boolean[][] getStress() {
		return stress;
	}

	public void setStress(boolean[][] stress) {
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

	public ArrayList<ArrayList<Integer>> getFeet() {
		return feet;
	}

	public void setFeet(ArrayList<ArrayList<Integer>> feet) {
		this.feet = feet;
	}
	
	//STATIC METHODS---------------------------------------------------
	
	public static byte bti(boolean in) {
		byte out = 0;
		if(in == true) out = 1;
		return out;
	}
	
}
