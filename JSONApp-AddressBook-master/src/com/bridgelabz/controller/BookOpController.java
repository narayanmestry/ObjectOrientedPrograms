package com.bridgelabz.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bridgelabz.model.Address;
import com.bridgelabz.model.Person;
import com.bridgelabz.utility.Utility;

public class BookOpController {

	static List<Person> personsList;// to perform read write Operation in the form of List object

	// Add New User

	public void addNewPerson(String openFilepath) {

		BookOpController bc = new BookOpController();
		// Read the data from JSON File .
		personsList = Utility.readFromBook(openFilepath);

		Person p = new Person();
		p = bc.getDataOfPerson(p); // get data of New User (New Entry)

		// Add it to Already readed data .and Pss to Write into file
		personsList.add(p);
		System.out.println("New Person is Added.....");

		personsList = Utility.writetoBook(openFilepath, personsList);

	}

	// Get Person Data
	private Person getDataOfPerson(Person p) {
		Address ad = new Address();

		String fname, lname, city, state, mobNo;
		int zip;
		System.out.println("First Name : ");
		fname = Utility.inputString();

		System.out.println("Last name : ");
		lname = Utility.inputString();

		System.out.println("City :");
		city = Utility.inputString();

		System.out.println("State : ");
		state = Utility.inputString();

		System.out.println("Zipcode :");
		zip = Utility.inputNumber();

		System.out.println("Mobile No. : ");
		mobNo = Utility.inputString();

		p.setFname(fname);
		p.setLname(lname);
		p.setMobNo(mobNo);
		p.setZip(zip);
		ad.setCity(city);
		ad.setState(state);
		p.setAddress(ad);

		return p;
	}

	// To Edit the Person
	public void editPerson(String openFilepath) throws IOException {
		Person p = new Person();
		// To show the All Entry , User can Identify index number
		printEntry(openFilepath);

		System.out.println("Enter the Index Number :");
		int index = Utility.inputNumber();

		// Read the Data From JSON File in List
		personsList = Utility.readFromBook(openFilepath);

		p = personsList.get(index - 1);
//		Person temp = p;
		System.out.println("Enter the choice what you want to Edit ...");
		System.out.println("-------------------------------------------------");
		System.out.println("1.First name\n2.Last Name\n3.City\n4.State\n5.Zipcode\n6.Mobile number");
		int ch = Utility.inputNumber();
		switch (ch) {
		case 1:
			System.out.println("Enter the New First Name");
			p.setFname(Utility.inputString());
			break;
		case 2:
			System.out.println("Enter the New Last Name");
			p.setLname(Utility.inputString());
			break;
		case 3:
			System.out.println("Enter the New City");
			p.getAddress().setCity(Utility.inputString());
			break;
		case 4:
			System.out.println("Enter the New State");
			p.getAddress().setState(Utility.inputString());
			break;
		case 5:
			System.out.println("Enter the New Zipcode");
			p.setZip(Utility.inputNumber());
			break;
		case 6:
			System.out.println("Enter the New Mobile Number");
			p.setFname(Utility.inputString());
			break;
		default:
			System.out.println("Enter Valid Choice");
		}
		System.out.println("---------------------------------------------------------");
		personsList.set(index - 1, p);

		System.out.println("Enter the choice : ");
		System.out.println("1. Save \n 2. Save As ");
		int ch1 = Utility.inputNumber();
		switch (ch1) {
		case 1:
			Utility.writetoBook(openFilepath, personsList);
			System.out.println("Person Info Replace SuccessFully");
			break;
		case 2:
			AddressBookController.saveAs(personsList);

		}

	}

	public void deletPerson(String openFilepath) {
		// To show the All Entry , User can Identify index number
		printEntry(openFilepath);

		System.out.println("Enter the Index Number :");
		int index = Utility.inputNumber();

		// Read the Data From JSON File in List
		personsList = Utility.readFromBook(openFilepath);

		personsList.remove(index - 1);

		Utility.writetoBook(openFilepath, personsList);

		System.out.println("Information get Removed");
		printEntry(openFilepath);

	}

	@SuppressWarnings("null")
	public void sortEntryByName(String openFilepath) {
		List<Person> tempSort = new ArrayList<Person>();

		personsList = Utility.readFromBook(openFilepath); // read fisrt

		ArrayList<String> sortedByName = sortAllName(personsList); // We will get Sortd data with name
		for (String s : sortedByName) {
			for (Person p : personsList) {
				if (s.equalsIgnoreCase(p.getFname())) {
					tempSort.add(p);
				}
			}
		}

		// Now All List sort ,so write to JSON File
		Utility.writetoBook(openFilepath, tempSort);
		printEntry(openFilepath);
	}

	// To sort the name in json File Object
	private ArrayList<String> sortAllName(List<Person> personsList) {
		ArrayList<String> sort = new ArrayList<>();
		for (Person p : personsList) {
			sort.add(p.getFname().toLowerCase());
		}
		Collections.sort(sort);
		return sort;
	}

	// To Sort the JSON File Data base on Zipcode
	public void sortEntryByZip(String openFilepath) {
		List<Person> tempSort = new ArrayList<Person>();
		personsList = Utility.readFromBook(openFilepath); // read fisrt
		ArrayList<Integer> sortedByZip = sortAllZip(personsList);
		for (Integer i : sortedByZip) {
			for (Person p : personsList) {
				if (i == p.getZip()) {
					tempSort.add(p); // Add the P object to get sort all data
				}
			}
		}

		Utility.writetoBook(openFilepath, tempSort); // Write Sorted list to JSON File
		printEntry(openFilepath); // Print data

	}

	// To Sort All ZipCode
	private ArrayList<Integer> sortAllZip(List<Person> personsList) {
		ArrayList<Integer> sort = new ArrayList<>();
		for (Person p : personsList) {
			sort.add(p.getZip());
		}
		Collections.sort(sort);
		return sort;
	}

	public void printEntry(String openFilepath) {
		personsList = Utility.readFromBook(openFilepath);

		System.out.println("SR no\tFirst name\tLast name\tcity\t\tstate\t\tzipcode\t\tmobile no.");
		System.out.println(
				"_______________________________________________________________________________________________________");
		int srno = 0;
		for (Person p : personsList) {
			srno++;
			System.out.println(srno + "\t" + p.getFname() + "\t\t" + p.getLname() + "\t\t" + p.getAddress().getCity()
					+ "\t\t" + p.getAddress().getState() + "\t\t" + p.getZip() + "\t\t" + p.getMobNo());
			System.out.println(
					"---------------------------------------------------------------------------------------------------------");
		}
	}

}
