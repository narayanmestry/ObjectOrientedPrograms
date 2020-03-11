package com.bridgelabz.controller;

import java.util.ArrayList;
import com.bridgelabz.model.*;
import com.bridgelabz.utility.Utility;

public class Controller {

	static ArrayList<Rice> rice = new ArrayList<>();
	static ArrayList<Wheats> wheats = new ArrayList<>();
	static ArrayList<Pulse> pulse = new ArrayList<>();
	

	public static ArrayList<Inventory> getDataOfInventory(ArrayList<Inventory> allinventory) {
		Inventory inventory = new Inventory(); 
		// get data of Rice :
		System.out.println("1. Rice :\n--------------------");
		inventory.setRice(getPropertiesRice(rice));
		
		// get data of Wheat :
		System.out.println("2. Wheats :\n--------------------");
		inventory.setWheats(getPropertiesWheats(wheats));
		
		// get Data of Pulse
		System.out.println("3 . Pulse :\n--------------------");
		inventory.setPulse(getPropertiesPulse(pulse));
		allinventory.add(inventory);
		return allinventory;		
	}
	

	// To get Rice Data
	private static ArrayList<Rice> getPropertiesRice(ArrayList<Rice> rice) {
		
		char c;
		do {
			Rice r = new Rice();
			System.out.println("Enter Name (Type):");
			r.setName(Utility.inputString());
			System.out.println("Enter Weight (Kg):");
			r.setWeight(Utility.inputNumber());
			System.out.println("Enter Price (Rs/kg):");
			r.setPrice(Utility.inputNumber());
			
			rice.add(r);
			
			System.out.println("Do you want to add more...press Y oy y");
			c = Utility.inputchar();
			System.out.println("---------------------------------------------------------");
		} while (c == 'Y' || c == 'y');
		return rice;
	}

	// To get Data Of Wheats
	private static ArrayList<Wheats> getPropertiesWheats(ArrayList<Wheats> wheats) {
		char c;
		do {
			Wheats w = new Wheats();
			System.out.println("Enter Name (Type):");
			w.setName(Utility.inputString());
			System.out.println("Enter Weight (Kg):");
			w.setWeight(Utility.inputNumber());
			System.out.println("Enter Price (Rs/kg):");
			w.setPrice(Utility.inputNumber());
			wheats.add(w);
			System.out.println("Do you want to add more...press Y oy y");
			c = Utility.inputchar();
			System.out.println("---------------------------------------------------------");
		} while (c == 'Y' || c == 'y');
		return wheats;
	}

	private static ArrayList<Pulse> getPropertiesPulse(ArrayList<Pulse> pulse) {
		char c;
		do {
			Pulse p = new Pulse();
			System.out.println("Enter the Name(Type) :");
			p.setName(Utility.inputString());
			System.out.println("Enter the Weight");
			p.setWeight(Utility.inputNumber());
			System.out.println("Enter the Price ");
			p.setPrice(Utility.inputNumber());
			pulse.add(p);
			System.out.println("Do you want to add more...press Y oy y");
			c = Utility.inputchar();
			System.out.println("---------------------------------------------------------");
		} while (c == 'Y' || c == 'y');
		return pulse;
	}



}
