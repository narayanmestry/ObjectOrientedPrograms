package com.bridgelabz.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgelabz.model.Inventory;

public class Utility {
	
	static String filepath = "/home/admin2/eclipse-workspace/JSON-OOPS-InventoryManagement/src/com/bridgelabz/repo/inventory.json";
	static Scanner sc = new Scanner(System.in);
	static File file ;
	static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
	}
	
	
	// To read the Character 
	public static char inputchar() {
		char c = sc.next().charAt(0);
		return c;
	}
	// read String from KeyBoard
	public static String inputString() {
		String str = sc.next();
		return str;
	}

	// read Number from KeyBoard
	public static int inputNumber() {
		int n = sc.nextInt();
		return n;
	}
	
	@SuppressWarnings("deprecation")
	public static void writeInventory(ArrayList<Inventory> allinventory) {
		file = new File(filepath);
		try {
			mapper.defaultPrettyPrintingWriter().writeValue(file, allinventory);
			System.out.println("Data Write successfully in JSON");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static ArrayList<Inventory> ReadInventory(ArrayList<Inventory> allinventory) throws IOException {
		file = new File(filepath);
		FileWriter fw = new FileWriter(file);
		try {
			
			fw.write("[ ]");
			fw.flush();
			allinventory = mapper.readValue(file, new TypeReference<ArrayList<Inventory>>() {} );
			System.out.println("Data Read Successfully from JSON ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			fw.close();
		}
		return allinventory;
	}

}
