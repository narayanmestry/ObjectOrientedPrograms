package com.bridgelabz.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgelabz.model.Stock;
import com.bridgelabz.model.User;


public class Utility {

	static Scanner sc = new Scanner(System.in);
	static ObjectMapper mapper = new ObjectMapper();


	// TO Input the Character
	public static char inputChar() {
		char c;
		try {
			c = sc.next().charAt(0);
			return c;
		} catch (Exception e) {
			System.out.println("\t\t*****Enter the Char value Only*****");
			sc.next();
			c = sc.next().charAt(0);
		}
		return c;
	}

// Used to input the String:
	public static String inputString() {
		String str = null;
		try {
			str = sc.next();
			return str;
		} catch (Exception e) {
			System.out.println("\t\t******Enter the Only String******");
			sc.next();
			str = sc.next();
		}
		return str;
	}

// Used to input the Integer:
	public static int inputNumber() {
		int number = 0;
		try {
			number = sc.nextInt();
			return number;
		} catch (Exception e) {
			System.out.println("\t\t******Enter the Only Integer******");
			sc.next();
			number = inputNumber();
		}
		return number;

	}

	public static ArrayList<Stock> readStockData(String filePath, ArrayList<Stock> stockdata) {
		File file = new File(filePath);
		try {
			if(file.length()==0)
			{
				FileWriter fw = new FileWriter(file);
				fw.write("[]");
				fw.flush();
				fw.close();
				
			}
			stockdata = mapper.readValue(file, new TypeReference<ArrayList<Stock>>() { });
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stockdata;
	}

	@SuppressWarnings("deprecation")
	public static void writeStockData(String filePath, ArrayList<Stock> stockdata) {
		
		try {
			mapper.defaultPrettyPrintingWriter().writeValue(new File(filePath), stockdata);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static ArrayList<User> readUserData(String userfilePath, ArrayList<User> userList) {
		
		File file = new File(userfilePath);
		try {
			if(file.length()==0)
			{
				FileWriter fw = new FileWriter(file);
				fw.write("[]");
				fw.flush();
				fw.close();
				
			}
			userList = mapper.readValue(file, new TypeReference<ArrayList<User>>() { });
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	public static void writeUserData(String userfilePath, ArrayList<User> userList) {

		try {
			mapper.defaultPrettyPrintingWriter().writeValue(new File(userfilePath), userList);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
