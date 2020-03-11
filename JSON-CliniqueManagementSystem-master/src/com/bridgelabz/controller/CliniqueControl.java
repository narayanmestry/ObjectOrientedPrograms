package com.bridgelabz.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.bridgelabz.Driver.CliniqueManagementApp;
import com.bridgelabz.model.Clinique;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.utility.Utility;

public class CliniqueControl {
	static ArrayList<Doctor> doctorlist = new ArrayList<>();
	static ArrayList<Patient> patientlist = new ArrayList<>();
	static ArrayList<Patient> appointedPatientList = new ArrayList<>();
	static ArrayList<Clinique> cliniqData = new ArrayList<>();

//	static String clinique_filepath = "/home/admin2/eclipse-workspace/JSON-OOPS-CliniqueManagementSystem/src/com/bridgelabz/repo/Dactor-Patient.json";
	static String doctor_filepath = "/home/admin2/eclipse-workspace/JSON-OOPS-CliniqueManagementSystem/src/com/bridgelabz/repo/DoctorList.json";
	static String patient_filepath = "/home/admin2/eclipse-workspace/JSON-OOPS-CliniqueManagementSystem/src/com/bridgelabz/repo/PatientList.json";
	static final String patient = "PATIENT";
	static final String admin = "ADMIN";

	// Perform The Admin Operation .
	public static ArrayList<Clinique> adminOperation() throws IOException {
		int ch;
		char c;
		Clinique clinique = new Clinique();
		// Read the Doctor Data From JSON
		doctorlist = Utility.readListFromJSON(doctor_filepath, doctorlist);

		do {
			System.out.println(
					"Select Your Choice : \n\t1.Add the Doctor with all details" + "\n\t2.See all Doctor details"
							+ "\n\t3.Search the Doctor" + "\n\t4.Remove the Doctor From Job"
									+ "\n\t5.See All Patient "
									+ "\n\t6.Back");
			ch = Utility.inputNumber();

			switch (ch) {
			case 1: // Add The Doctor
				doctorlist = addDoctorData(doctorlist);
				System.out.println("After add :" + doctorlist.size());
				// Write the Doctor Details in JSON
				Utility.WriteToJSON(doctor_filepath, doctorlist);

				break;
			case 2:
				displayAllDoctorsDetails();
				break;
			case 3:
				patient_Admin_Operation(admin);
				break;
			case 4:
				removeDoctor(doctorlist);
				break;
			case 5:
				diaplayAllPatient(patientlist);
				
				break;	
			case 6:
				CliniqueManagementApp.start();
				break;

			default:
				System.out.println("Enter the Valid Choice : ");
			}
			System.out.println("Do you want to add more......?\nPress Y or y ");
			c = Utility.inputchar();
		} while (c == 'Y' || c == 'y');

		// Add The All Details of Doctor to Clinique Object
		clinique.setDoctor(doctorlist);
		cliniqData.add(clinique);

		return cliniqData;
	}

	
	// To diaplay all Patirnt : 
	private static void diaplayAllPatient(ArrayList<Patient> patientlist) {
		patientlist = Utility.readListFromJSONPatient(patient_filepath, patientlist);
		System.out.println("P ID\tName\t\t\tAge\tMobile no.\t\tAppointed Doctor\t\tDate\t"
				+ "\n------------------------------------------------------------------------------------------------");
		for(Patient p :patientlist)
		{
			System.out.println(p.getPid()+"\t"+p.getName()+"\t\t\t"+p.getAge()+"\t"+p.getMobileNo()+""
					+ "\t\t"+p.getAppontedDrName()+"\t\t"+p.getDate()+""
					+ "\n------------------------------------------------------------------------------------------------");
		}
		
	}

	// Remove the Doctor
	private static void removeDoctor(ArrayList<Doctor> doctorlist) throws IOException {
		displayAllDoctorsDetails();
		System.out.println("\n\nEnter the ID Which Doctor want to Remove From Job");
		int index = Utility.inputNumber();
		for (Doctor dr : doctorlist) {
			if (index == dr.getDid()) {
				doctorlist.remove(dr);
				break;
			}
		}
		Utility.WriteToJSON(doctor_filepath, doctorlist);
	}

	// To Add the Detalis Of Doctor
	private static ArrayList<Doctor> addDoctorData(ArrayList<Doctor> doctorlist) {
		char c;
		do {

			Doctor doctor = new Doctor();
			System.out.println("Enter the Doctor ID : ");
			doctor.setDid(Utility.inputNumber());

			System.out.println("Enter the Name of Doctor :");
			doctor.setName("DR. " + Utility.inputString());

			System.out.println("Enter the Specialization :");
			doctor.setSpecialization(getSpecialization());
//			System.out.println(getSpecialization());
			System.out.println("Enter the Availability :");
			doctor.setAvailability(getAvailability());
//			System.out.println(getAvailability());
			doctorlist.add(doctor);
//			doctor.setAppontedPatient(appontedPatient);
			System.out.println("Do you want to add more......?\nPress Y or y ");
			c = Utility.inputchar();
		} while (c == 'Y' || c == 'y');

		return doctorlist;
	}

	// To Set Doctor availability
	private static String getAvailability() {
		int ch = 0;
		String availabilbity = null;

		System.out.println("\t\tSelect the Availability :" + "\n\t\t   1.Monday     : 9AM - 2PM ( Pediatrician )"
				+ "\n\t\t   2.Monday     : 2PM String- 6PM ( Surgeon )" + ""
				+ "\n\t\t   3.Tuesday    : 2PM - 6PM ( Cardiologist )"
				+ "\n\t\t   4.Tuesday    : 9AM - 2PM ( Psychiatrist )"
				+ "\n\t\t   5.Wednesday  : 9AM - 2PM ( Skin-Specialist  )"
				+ "\n\t\t   6.Wednesday  : 2PM - 6PM ( Infectious Disease Physician )"
				+ "\n\t\t   7.Thursday   : 9AM - 2PM ( Eye Disease Physician )"
				+ "\n\t\t   8.Thursday   : 2PM - 6PM ( Pediatrician )" + ""
				+ "\n\t\t   9.Friday     : 9AM - 2PM ( Surgeon )" + ""
				+ "\n\t\t  10.Saturday   : 9AM - 2PM ( Cardiologist )"
				+ "\n\t\t  11.Friday     : 2PM - 6PM ( Psychiatrist )"
				+ "\n\t\t  12.Saturday   : 2PM - 6PM ( Skin-Specialist  )"
				+ "\n\t\t  13.Sunday     : 9AM - 2PM ( Infectious Disease Physician )"
				+ "\n\t\t  14.Sunday     : 2PM - 6PM ( Eye Disease Physician )");
		ch = Utility.inputNumber();
		switch (ch) {
		case 1:
			availabilbity = "Monday(9AM - 2PM)";
			break;
		case 2:
			availabilbity = "Monday(2PM - 6PM)";
			break;
		case 3:
			availabilbity = "Tuesday:(9AM - 2PM)";
			break;
		case 4:
			availabilbity = "Tuesday:2PM - 6PM)";
			break;
		case 5:
			availabilbity = "Wednesday:(9AM - 2PM)";
			break;
		case 6:
			availabilbity = "Wednesday:(2PM - 6PM)";
			break;
		case 7:
			availabilbity = "Thursday:(9AM - 2PM)";
			break;
		case 8:
			availabilbity = "Thursday:(2PM - 6PM)";
			break;
		case 9:
			availabilbity = "Friday:(9AM - 2PM)";
			break;
		case 10:
			availabilbity = "Friday:(2PM - 6PM)";
			break;
		case 11:
			availabilbity = "Saturday:(9AM - 2PM)";
			break;
		case 12:
			availabilbity = "Saturday:(2PM - 6PM)";
			break;
		case 13:
			availabilbity = "Sunday:(9AM - 2PM)";
			break;
		case 14:
			availabilbity = "Sunday:(2PM - 6PM)";
			break;
		default:
			System.out.println("Select the Valid Choice :");
		}
		return availabilbity;
	}

	/**
	 * @param specialization : Select the Specialization of Doctor
	 * @return Specialization
	 */
	private static String getSpecialization() {
		int ch;
		String specialization = " ";
		System.out.println("\t\tSelect Specialization ...." + "\n\t\t\t1.Pediatrician (बालरोग तज्ञ)"
				+ "\n\t\t\t2.Surgeon (सर्जन)" + "\n\t\t\t3.Cardiologist(हृदयरोगतज्ज्ञ)"
				+ "\n\t\t\t4.Psychiatrist (मानसशास्त्रज्ञ)" + "\n\t\t\t5.Skin-Specialist (त्वचाविज्ञानी)"
				+ "\n\t\t\t6.Infectious Disease Physician (संसर्गजन्य रोग चिकित्सक)"
				+ "\n\t\t\t7.Eye Disease Physician(नेत्र रोग चिकित्सक)");
		ch = Utility.inputNumber();
		switch (ch) {

		case 1:
			specialization = "Pediatrician(बालरोग तज्ञ)";
			break;

		case 2:
			specialization = "Surgeon(सर्जन)";
			break;

		case 3:
			specialization = "Psychiatrist(मानसशास्त्रज्ञ)";
			break;

		case 4:
			specialization = "Cardiologist(हृदयरोगतज्ज्ञ)";
			break;
		case 5:
			specialization = "Skin-Specialist(त्वचाविज्ञानी)";
			break;

		case 6:
			specialization = "Infectious Disease Physician(संसर्गजन्य रोग चिकित्सक)";
			break;

		case 7:
			specialization = "Eye Disease Physician(नेत्र रोग चिकित्सक)";
			break;

		default:
			System.out.println("Select the Valid Specialization ");
		}
		return specialization;
	}

	// Perform the UserOperation Doctor and Patient .
	public static ArrayList<Clinique> UserOperation() throws IOException {
		int ch;
		char c;
		do {
			System.out.println("Select the User : \n\t1.Patient\n\t2.Doctor\n\t3.Back");
			ch = Utility.inputNumber();
			switch (ch) {
			case 1:
				patient_Admin_Operation(patient);
				break;
			case 2:
				doctorOperation();
				break;
			case 3:
				CliniqueManagementApp.start();
				break;

			default:
				System.out.println("Enter the Valid Choice :");
			}
			System.out.println("Do you want to Continue : ............Press Y or y");
			c = Utility.inputchar();
		} while (c == 'Y' || c == 'y');

		return cliniqData;
	}

	// To Perform the Doctor Operation
	private static void doctorOperation() throws IOException {
		int ch;
		char c;
		patientlist = Utility.readListFromJSONPatient(patient_filepath, patientlist);
		do {
			System.out.println("Select the choice  : \n\t1.Search the Patient By ID :"
					+ "\n\t2.Search the Patient By Name" + "\n\t3.Back");
			ch = Utility.inputNumber();

			switch (ch) {
			case 1:
				searchPatientId(patientlist);

				break;
			case 2:
				searchPatientName(patientlist);
				break;
			case 3:
				CliniqueControl.UserOperation();
				break;

			default:
				System.out.println("Enter the Valid Choice :");
			}
			System.out.println("Do you want to Continue : ............Press Y or y");
			c = Utility.inputchar();
		} while (c == 'Y' || c == 'y');

	}

	// Search the PAtient By Name
	private static void searchPatientName(ArrayList<Patient> patientlist2) {
		System.out.println("Enter the NAme OF the Patient");
		String p_name = Utility.inputString();
		System.out.println("PID\tName\t\tAge\tMobile no.\tAppointed Doctor Name\tTime"
				+ "\n----------------------------------------------------------------------------------------------------------");
		for (Patient p : patientlist) {

			if (p.getName().toLowerCase().contains(p_name.toLowerCase())) {
				System.out.println(p.getPid() + "\t" + p.getName() + "\t\t" + p.getAge() + "\t" + p.getMobileNo() + ""
						+ "\t\t" + p.getAppontedDrName() + "\t\t" + p.getDate() + ""
						+ "\n----------------------------------------------------------------------------------------------------------");
			}

		}

	}

	// search The Patient by ID
	private static void searchPatientId(ArrayList<Patient> patientlist) {
		System.out.println("Enter the ID of Patient :");
		int id = Utility.inputNumber();
		System.out.println("PID\tName\t\tAge\tMobile no.\tAppointed Doctor Name\tTime"
				+ "\n----------------------------------------------------------------------------------------------------------");
		for (Patient p : patientlist) {
			if (id == p.getPid()) {
				System.out.println(p.getPid() + "\t" + p.getName() + "\t\t" + p.getAge() + "\t" + p.getMobileNo() + ""
						+ "\t\t" + p.getAppontedDrName() + "\t\t" + p.getDate() + ""
						+ "\n----------------------------------------------------------------------------------------------------------");
			}
		}

	}

	// Perform the Patient Operation
	private static void patient_Admin_Operation(String userType) throws IOException {
		int ch;
		char c;
		do {
			System.out.println("Enter your choice :\n\t1.Search the Doctor by name :"
					+ "\n\t2.Search the Doctor by Specialization:" + "" + "\n\t3.Search the Doctor by availability:"
					+ "\n\t4.Back"
					+ "\n---------------------------------------------------------------------------------------");
			ch = Utility.inputNumber();

			switch (ch) {
			case 1:
				searchDoctorByName(userType);
				break;
			case 2:
				searchDoctorBySpecialization(userType);
				break;
			case 3:
				searchDoctorByavailability(userType);
				break;

			case 4:
				if (userType.equals("ADMIN")) {
					CliniqueControl.adminOperation();
				} else {
					CliniqueControl.UserOperation();
				}
				break;

			default:
				System.out.println("Enter the Valid choice :");
			}
			System.out.println("Do you want to Continue : ............Press Y or y");
			c = Utility.inputchar();
		} while (c == 'Y' || c == 'y');

	}

	// Search Doctor by name :
	private static void searchDoctorByName(String userType) {
		int count = 0;
		System.out.println("Enter the Name of Doctor : ");
		String dr_name = Utility.inputString();

		try {
			doctorlist = Utility.readListFromJSON(doctor_filepath, doctorlist);
			System.out.println("List Of Doctors are :\n___________________________________________");
			System.out.println("ID\t\tName\t\t\tSpecilization\t\t\t\tAvailability"
					+ "\n---------------------------------------------------------------------------------------------------");
			for (Doctor dr : doctorlist) {

				if (dr.getName().toLowerCase().contains(dr_name.toLowerCase())) {
					System.out.println(dr.getDid() + "\t\t" + dr.getName() + "\t\t" + dr.getSpecialization() + "\t\t"
							+ dr.getAvailability() + ""
							+ "\n----------------------------------------------------------------------------------------------------");
					count++;
				}
			}
			System.out.print("**" + count + " Doctors are Available ===========>");
			if (userType.equalsIgnoreCase("PATIENT")) {
				takeAppointment();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Search the Doctor by Specialization
	private static void searchDoctorBySpecialization(String userType) {
		try {
			int count = 0;
			String specialization = getSpecialization();
			doctorlist = Utility.readListFromJSON(doctor_filepath, doctorlist);
			System.out.println("List Of Doctors are :\n___________________________________________");
			System.out.println("ID\t\tName\t\t\tSpecilization\t\t\t\tAvailability"
					+ "\n---------------------------------------------------------------------------------------------------");
			for (Doctor dr : doctorlist) {
				if (dr.getSpecialization().contains(specialization)) {
					System.out.println(dr.getDid() + "\t\t" + dr.getName() + "\t\t" + dr.getSpecialization() + "\t\t"
							+ dr.getAvailability() + ""
							+ "\n----------------------------------------------------------------------------------------------------");
					count++;
				}
			}

			System.out.print("**" + count + " Doctors are Available ===========>");
			if (userType.equalsIgnoreCase("PATIENT")) {
				takeAppointment(); // UserType is PATIENT then Only it ask for appointment
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Search the Doctor by Availability
	private static void searchDoctorByavailability(String userType) {
		try {
			doctorlist = Utility.readListFromJSON(doctor_filepath, doctorlist);
			int ch;
			char c;
			do {
				System.out.println("Enter your choice :\n\t1.Search By Day:"
						+ "\n\t2.Search By Time:\n---------------------------------------------------------------------------------------");
				ch = Utility.inputNumber();

				switch (ch) {
				case 1:
					searchDoctorByDay(doctorlist, userType);
					break;
				case 2:
					searchDoctorByTime(doctorlist, userType);
					break;
				default:
					System.out.println("Enter the Valid choice :");
				}
				System.out.println("Do you want to Continue : ............Press Y or y");
				c = Utility.inputchar();
			} while (c == 'Y' || c == 'y');

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Search Doctor by Day
	private static void searchDoctorByDay(ArrayList<Doctor> doctorlist, String userType) {
		int count = 0;
		String Day = getDay();
		System.out.println("List Of Doctors are :\n___________________________________________");
		System.out.println("ID\t\tName\t\t\tSpecilization\t\t\t\tAvailability"
				+ "\n---------------------------------------------------------------------------------------------------");

		for (Doctor dr : doctorlist) {
			if (dr.getAvailability().toLowerCase().contains(Day.toLowerCase())) {
				System.out.println(dr.getDid() + "\t\t" + dr.getName() + "\t\t" + dr.getSpecialization() + "\t\t"
						+ dr.getAvailability() + ""
						+ "\n----------------------------------------------------------------------------------------------------");
				count++;
			}
		}
		System.out.print("**" + count + " Doctors are Available ===========>");
		if (userType.equalsIgnoreCase("PATIENT")) {
			takeAppointment();
		}
	}

	// Select Day of the Week :
	private static String getDay() {
		String s = null;
		int ch;
		System.out.println(
				"Select Day :\n\t1.Monday\n\t2.Tuesday\n\t3.Wednesday\n\t4.Thursday\n\t5.Friday\n\t6.Saturday\n\t7.Sunday");
		ch = Utility.inputNumber();
		switch (ch) {
		case 1:
			s = "Monday";
			break;
		case 2:
			s = "Tuesday";
			break;
		case 3:
			s = "Wednesday";
			break;
		case 4:
			s = "Thursday";
			break;
		case 5:
			s = "Friday";
			break;
		case 6:
			s = "Saturday";
			break;
		case 7:
			s = "Sunday";
			break;
		default:
			System.out.println("Select valid day ");
		}
		return s;
	}

	// Search the Doctor by Time
	private static void searchDoctorByTime(ArrayList<Doctor> doctorlist, String userType) {
		int count = 0;
		String Time = getTime();
		System.out.println("List Of Doctors are :\n___________________________________________");
		System.out.println("ID\t\tName\t\t\tSpecilization\t\t\t\tAvailability"
				+ "\n---------------------------------------------------------------------------------------------------");
		for (Doctor dr : doctorlist) {
			if (dr.getAvailability().toLowerCase().contains(Time.toLowerCase())) {
				System.out.println(dr.getDid() + "\t\t" + dr.getName() + "\t\t" + dr.getSpecialization() + "\t\t"
						+ dr.getAvailability() + ""
						+ "\n----------------------------------------------------------------------------------------------------");
				count++;
			}
		}

		System.out.print("**" + count + " Doctors are Available ===========>");
		if (userType.equalsIgnoreCase("PATIENT")) {
			takeAppointment();
		}
	}

	// To get the Time Slot
	private static String getTime() {
		String s = null;
		int ch;
		System.out.println("Enter Time Slot\n\t1.9AM - 2PM:\n\t2.2PM - 6PM");
		ch = Utility.inputNumber();
		switch (ch) {
		case 1:
			s = "9AM - 2PM";
		case 2:
			s = "2PM - 6PM";
		default:
			System.out.println("Select available Time Slot ");
		}
		return s;
	}

	// To Take Appointment Of Doctor
	private static void takeAppointment() {
		int id;
		try {
			System.out.println(" Enter the ID to take Appointment:");
			id = Utility.inputNumber();
			// First Read the Doctorlist Data
			doctorlist = Utility.readListFromJSON(doctor_filepath, doctorlist);
			// here we get periticular doctor object to take appint and we add
			// details of patient in that perticular doctor object as appointed Patient list
			for (Doctor dr : doctorlist) {
				if (dr.getDid() == id) {
					System.out.println("ID\t\tName\t\t\tSpecilization\t\t\t\tAvailability"
							+ "\n---------------------------------------------------------------------------------------------------");
					System.out.println(dr.getDid() + "\t\t" + dr.getName() + "\t\t" + dr.getSpecialization() + "\t\t"
							+ dr.getAvailability() + ""
							+ "\n----------------------------------------------------------------------------------------------------");
					// Read First Appointed List of Patient and also all Patient list data
					appointedPatientList = dr.getAppointed();
					patientlist = Utility.readListFromJSONPatient(patient_filepath, patientlist);

//					Condition :
//					1. A doctor at  any availability time can see only 5 patients.
//					2. If exceeded the user can take appointm__ent for patient at different date or availability time
					if (appointedPatientList.size() < 5) {
						// Here, we take all details of Patient
						Patient p = getAllPatientDetails(patientlist, dr);

						// Add The patient details to Appointed patient list
						appointedPatientList.add(p);

						// Add the Patient to Patient List where all Patient record are stored
						patientlist.add(p);

						dr.setAppointed(appointedPatientList);
//						doctorlist.add(dr);
						// after taking appintment patient data add to the doctor list
						// so doctorList Write to JSON File
						Utility.WriteToJSON(doctor_filepath, doctorlist);

						// To maintain the all details of Patient we Write Patient to JSon File
						Utility.WriteToJSONPatient(patient_filepath, patientlist);
					} else {
						System.out.println("No appointment is Available ,please try for next Appointment");
					}
					break;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// To Get all Patient Details :
	private static Patient getAllPatientDetails(ArrayList<Patient> patientlist, Doctor dr) {
		Patient p = new Patient();
		System.out.println("Enter the Patient ID");
		p.setPid(Utility.inputNumber());
		System.out.println("Enter the Patient Name : ");
		p.setName(Utility.inputString());
		System.out.println("Enter the Patient Age :");
		p.setAge(Utility.inputNumber());
		System.out.println("Enter the Patient Mobile Number :");
		p.setMobileNo(Utility.inputString());

		p.setAppontedDrName(dr.getName()); // appointed Doctor
		p.setDate(new Date().toString());
		return p;
	}

	// Display all details of Doctors :
	public static void displayAllDoctorsDetails() {
		try {
			doctorlist = Utility.readListFromJSON(doctor_filepath, doctorlist);
			System.out.println("ID\t\tName\t\t\tSpecilization\t\t\t\tAvailability"
					+ "\n---------------------------------------------------------------------------------------------------");
			for (Doctor dr : doctorlist) {
				System.out.println(dr.getDid() + "\t\t" + dr.getName() + "\t\t" + dr.getSpecialization() + "\t\t"
						+ dr.getAvailability() + ""
						+ "\n----------------------------------------------------------------------------------------------------");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
