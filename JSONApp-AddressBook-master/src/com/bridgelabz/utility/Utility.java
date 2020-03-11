package com.bridgelabz.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import com.bridgelabz.model.Person;

public class Utility {
	static Scanner sc = new Scanner(System.in);
	static String path = "/home/admin2/eclipse-workspace/JSON-OOPS-AddressBookApp/src/com/bridgelabz/repo/";

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

	// To get Existing path where file get Store
	public static String getExistFilePath() {

		return path;
	}

	// To get Current filepath of your newly created file
	public static String getCurrentFile(String newFile) {
		String mypath = Utility.getExistFilePath();
		String a = mypath + newFile + ".json";
		return a;
	}

	// To read the JSON Object data from file in the list
	public static ArrayList<Person> readFromBook(String openFilepath) {
		
		// list to store all person list :
	
		ArrayList<Person> personslist;
	
		try {
			
			personslist = mapper.readValue(new File(openFilepath), new TypeReference<ArrayList<Person>>() {
			});
			
			// Read the data from JSON file in the form of List of JSON object and Retun list
			return personslist;
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return null;
	}

	@SuppressWarnings("deprecation")
	public static List<Person> writetoBook(String openFilepath, List<Person> personData) {
		File file = new File(openFilepath);
		try {
			
			// Write the data to JSON file in the form of List of JSON object and Retun list
			mapper.defaultPrettyPrintingWriter().writeValue(file, personData);
			
			System.out.println("New data Write SuccessFully");
			
			return personData;
		
		} catch (IOException e) {
			e.printStackTrace();
	
		}
		return null;
	}

	
	

}
