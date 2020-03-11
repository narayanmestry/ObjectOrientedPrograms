package com.bridgelabz.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;

public class Utility {


	static Scanner sc = new Scanner(System.in);
	static ObjectMapper mapper = new ObjectMapper();

	static File file;

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

	// Write to JSON  
	@SuppressWarnings("deprecation")
	public static void WriteToJSON(String doctor_filepath, ArrayList<Doctor> doctorlist) throws IOException {
		try {
			System.out.println(doctorlist);
			mapper.defaultPrettyPrintingWriter().writeValue(new File(doctor_filepath), doctorlist);
			System.out.println("Data Write SccusFully In Dactor List.........");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ArrayList<Doctor> readListFromJSON(String doctor_filepath, ArrayList<Doctor> doctorlist) throws IOException {
		file = new File(doctor_filepath);

		try {
			// JSON Do not read Empty file without [] , so when JSON File is empty it add [ ] and the
			// read the Data in ArrayList Object
			if (file.length() == 0) {
				FileWriter fw = new FileWriter(file);
				fw.write("[ ]");
				fw.flush();
				fw.close();
			}
			doctorlist = mapper.readValue(file, new TypeReference<ArrayList<Doctor>>() {
			});
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doctorlist; 
	}

	public static ArrayList<Patient> readListFromJSONPatient(String patient_filepath, ArrayList<Patient> patientlist) {
		file = new File(patient_filepath);

		try {
			// JSON Do not read Empty file without [] , so when JSON File is empty it add [ ] and the
			// read the Data in ArrayList Object
			if (file.length() == 0) {
				FileWriter fw = new FileWriter(file);
				fw.write("[ ]");
				fw.flush();
				fw.close();
			}
			patientlist = mapper.readValue(file, new TypeReference<ArrayList<Patient>>() {
			});
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patientlist; 
	}

	@SuppressWarnings("deprecation")
	public static void WriteToJSONPatient(String patient_filepath, ArrayList<Patient> patientlist) {
		try {
			System.out.println(patient_filepath);
			mapper.defaultPrettyPrintingWriter().writeValue(new File(patient_filepath), patientlist);
			System.out.println("Data Write SccusFully In Dactor List.........");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
