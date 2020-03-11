package com.bridgelabz.controller;

import java.util.ArrayList;

import com.bridgelabz.model.*;

public class CalculationControl {
	static ArrayList<Rice> riceoutput = new ArrayList<>();
	static ArrayList<Wheats> wheatoutput = new ArrayList<>();
	static ArrayList<Pulse> pulseoutput = new ArrayList<>();
	
	// Simple Calculation ............
	
	public static void getOutputOfInventory(ArrayList<Inventory> allinventory) {
		
		System.out.println("\n\n********************* Simple Total Calculation **********************");
		// Calculate Rice Inventory ...
		int weight =0 ,totalprice = 0;
		for(Rice r : allinventory.get(0).getRice())
		{
			weight = weight + r.getWeight();
			totalprice = totalprice + (r.getWeight() * r.getPrice());
		}
		System.out.println("Rice :\n\tTotal Weight : "+weight+"Kg\n\tTotalPtice : "+totalprice+"RS");
		
		
		// Calculate Wheats Inventory
		weight =0;
		totalprice = 0;
		for(Wheats w : allinventory.get(0).getWheats())
		{
			weight = weight + w.getWeight();
			totalprice = totalprice + (w.getWeight() * w.getPrice());
		}
		System.out.println("Wheats :\n\tTotal Weight : "+weight+"Kg\n\tTotalPtice : "+totalprice+"RS");
		
		
		// Calculate Pulse Inventory
	    weight =0;
	    totalprice = 0;
		for(Pulse p : allinventory.get(0).getPulse())
		{
			weight = weight + p.getWeight();
			totalprice = totalprice + (p.getWeight() * p.getPrice());
		}
		System.out.println("Pulse :\n\tTotal Weight : "+weight+"Kg\n\tTotalPtice : "+totalprice+"RS");
	}

	
	// Advance Calculation 
	public static void getDetailOutputOfInventory(ArrayList<Inventory> allinventory) {
		
		System.out.println("\n\n********************* Advance Total Calculation **********************");
		// Calculate Rice Inventory ...
		int weight =0 ,totalprice = 0;
		System.out.println("Rice : \n---------------------------------");
		for(Rice r : allinventory.get(0).getRice())
		{
			totalprice = (r.getWeight() * r.getPrice());
			System.out.println("\tName (Type) :"+r.getName()+""
					+ "\n\tTotal Weight : "+r.getWeight()+"Kg"
					+ "\n\tTotalPtice : "+totalprice+"RS\n---------------------------------");
			
		}
		// Calculate Wheats Inventory
		weight =0;
		totalprice = 0;
		System.out.println("Wheats : \n---------------------------------");
		for(Wheats w : allinventory.get(0).getWheats())
		{
			totalprice = (w.getWeight() * w.getPrice());
			System.out.println("\tName (Type) :"+w.getName()+""
					+ "\n\tTotal Weight : "+w.getWeight()+"Kg"
					+ "\n\tTotalPtice : "+totalprice+"RS\n---------------------------------");
		}
		// Calculate Pulse Inventory
	    weight =0;
	    totalprice = 0;
	    System.out.println("Pulse : \n---------------------------------");
		for(Pulse p : allinventory.get(0).getPulse())
		{
			totalprice =(p.getWeight() * p.getPrice());
			System.out.println("\tName (Type) :"+p.getName()+""
					+ "\n\tTotal Weight : "+p.getWeight()+"Kg"
					+ "\n\tTotalPtice : "+totalprice+"RS\n---------------------------------");
		}	
	}

}
