package com.bridgelabz.model;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Rice> rice;
	private ArrayList<Wheats> wheats;
	private ArrayList<Pulse> pulse;

	public ArrayList<Rice> getRice() {
		return rice;
	}

	public void setRice(ArrayList<Rice> rice) {
		this.rice = rice;
	}

	public ArrayList<Wheats> getWheats() {
		return wheats;
	}

	public void setWheats(ArrayList<Wheats> wheats) {
		this.wheats = wheats;
	}

	public ArrayList<Pulse> getPulse() {
		return pulse;
	}

	public void setPulse(ArrayList<Pulse> pulse) {
		this.pulse = pulse;
	}

}