package com.bridgelabz.Driver;

import java.io.IOException;
import java.util.ArrayList;

import com.bridgelabz.controller.CalculationControl;
import com.bridgelabz.controller.Controller;
import com.bridgelabz.model.Inventory;
import com.bridgelabz.utility.Utility;

public class InventoryManagement {
	static ArrayList<Inventory> allinventory = new ArrayList<>();
	static ArrayList<Inventory> outputinventory = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		char c;
		int ch;
		allinventory = Utility.ReadInventory(allinventory); // Read JSON Data First

		allinventory = Controller.getDataOfInventory(allinventory); // get details of inventory in the form of List

		Utility.writeInventory(allinventory); // Write data To inventory file

		do {

			System.out.println("Enter choice :\n1.Simple Inventory Calculation\n2.Advance Inventory Calculation ");
			ch = Utility.inputNumber();
			switch (ch) {
			case 1:
				CalculationControl.getOutputOfInventory(allinventory);
				break;
			case 2:
				CalculationControl.getDetailOutputOfInventory(allinventory);
				break;
			default:
				System.out.println("Enter the Valid Choice : ");
			}
			System.out.println("Do you want continiue .....Press Y or y");
			c = Utility.inputchar();
		} while (c == 'Y' || c == 'y');

	}
}
