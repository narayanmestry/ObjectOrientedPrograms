package com.bridgelabz.Driver;

import java.util.ArrayList;

import com.bridgelabz.Controller.StockManageControl;
import com.bridgelabz.model.Stock;
import com.bridgelabz.utility.Utility;

public class StockManagementApp {

	static ArrayList<Stock> stockdata = new ArrayList<>();
	static String filePath = "/home/admin2/eclipse-workspace/JSON-OOPS-StockManagementApp/src/com/bridgelabz/repo/StockReport.json";
	static Stock stock = new Stock();

	public static void main(String[] args) {
		start();	
	}

	public static void start() {
		int ch;
		char c;
		stockdata = Utility.readStockData(filePath, stockdata);
		
		do {
			System.out.println("Enter the Choice :\n1. Add the Stock informantion" + "\n2. Calculate Report(Simple Stock Management :)"
					+ "\n3. Commercial Data Processing :");
			ch = Utility.inputNumber();
		switch (ch) {
		case 1:
			stockdata = StockManageControl.getStockData(stockdata);
			Utility.writeStockData(filePath, stockdata);
			break;
		case 2:
			System.out.println("");
			StockManageControl.calculatedStockReport(stockdata);
			break;
		case 3 : 
			StockManageControl.CommecialDataProcessing(filePath,stockdata);
		default :
			System.out.println("Enter the Valid choice :");
		
		}
		System.out.println("Do you want to Continue .......press Y || y");
		c = Utility.inputChar();
		}while(c=='Y'||c=='y');
	
		
	}

}
