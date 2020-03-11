package com.bridgelabz.model;

import java.util.ArrayList;

public class Doctor {
	private int did;
	private String name ;
	private String specialization;
	private String availability;
	private ArrayList<Patient> appointed ;

	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public ArrayList<Patient> getAppointed() {
		return appointed;
	}
	public void setAppointed(ArrayList<Patient> appointed) {
		this.appointed = appointed;
	}

	
}
