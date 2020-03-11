package com.bridgelabz.model;

import java.util.ArrayList;

public class Clinique {
	private ArrayList<Doctor> doctor;
	private ArrayList<Patient>	patient;
	public ArrayList<Doctor> getDoctor() {
		return doctor;
	}
	public void setDoctor(ArrayList<Doctor> doctor) {
		this.doctor = doctor;
	}
	public ArrayList<Patient> getPatient() {
		return patient;
	}
	public void setPatient(ArrayList<Patient> patient) {
		this.patient = patient;
	}

	
}
