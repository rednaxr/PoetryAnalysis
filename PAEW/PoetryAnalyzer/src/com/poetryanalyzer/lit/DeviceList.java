package com.poetryanalyzer.lit;

import java.util.ArrayList;

//A list of devices within a section
public class DeviceList {
	private ArrayList<Device> AlliterationSound;
	private ArrayList<Device> AlliterationVisual;
	private ArrayList<Device> Rhyme;
	private ArrayList<Device> Homophone;
	private ArrayList<Device> Anaphora;
	private ArrayList<Device> Assonance;
	private ArrayList<Device> Consonance;
	private ArrayList<Device> Polysyndeton;
	private ArrayList<Device> Asyndeton;
	public ArrayList<Device> getAlliterationSound() {
		return AlliterationSound;
	}
	public void setAlliterationSound(ArrayList<Device> alliterationSound) {
		AlliterationSound = alliterationSound;
	}
	public ArrayList<Device> getAlliterationVisual() {
		return AlliterationVisual;
	}
	public void setAlliterationVisual(ArrayList<Device> alliterationVisual) {
		AlliterationVisual = alliterationVisual;
	}
	public ArrayList<Device> getRhyme() {
		return Rhyme;
	}
	public void setRhyme(ArrayList<Device> rhyme) {
		Rhyme = rhyme;
	}
	public ArrayList<Device> getHomophone() {
		return Homophone;
	}
	public void setHomophone(ArrayList<Device> homophone) {
		Homophone = homophone;
	}
	public ArrayList<Device> getAnaphora() {
		return Anaphora;
	}
	public void setAnaphora(ArrayList<Device> anaphora) {
		Anaphora = anaphora;
	}
	public ArrayList<Device> getAssonance() {
		return Assonance;
	}
	public void setAssonance(ArrayList<Device> assonance) {
		Assonance = assonance;
	}
	public ArrayList<Device> getConsonance() {
		return Consonance;
	}
	public void setConsonance(ArrayList<Device> consonance) {
		Consonance = consonance;
	}
	public ArrayList<Device> getPolysyndeton() {
		return Polysyndeton;
	}
	public void setPolysyndeton(ArrayList<Device> polysyndeton) {
		Polysyndeton = polysyndeton;
	}
	public ArrayList<Device> getAsyndeton() {
		return Asyndeton;
	}
	public void setAsyndeton(ArrayList<Device> asyndeton) {
		Asyndeton = asyndeton;
	}
}
