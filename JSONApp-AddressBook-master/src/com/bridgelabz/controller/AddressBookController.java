package com.bridgelabz.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.Driver.BookFileOp;
import com.bridgelabz.model.Person;
import com.bridgelabz.utility.Utility;

public class AddressBookController {
	static String currentFile;
	static FileWriter fw;

	public static void createNewAddressBook() throws IOException {

		System.out.println("Enter the File Name : ");
		String newFile = Utility.inputString();

		currentFile = Utility.getCurrentFile(newFile);

//		System.out.println(currentFile);
		boolean createNew = createNewaddressBook(currentFile);
//		System.out.println(createNew);
		if (createNew) {
			System.out.println("Address Book is Created");
		} else {
			System.out.println("Address Book is Alresdy Exist");
		}
	}

	// To Create the File
	private static boolean createNewaddressBook(String currentFile) throws IOException {
		File file = new File(currentFile);

		int flag = 0;
		boolean b1 = file.exists();
		if (b1) {
//			System.out.println("File is Already Exist...please Enter another name");
			flag = 0;
		} else {
			boolean b2 = file.createNewFile();
			if (b2) {
				fw = new FileWriter(file);
				fw.write("[ ]");
				fw.flush();
				fw.close();
//				System.out.println("New Address Book has Created....");
				flag = 1;
			}
		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void open() throws IOException {
		BookFileOp bookfile = new BookFileOp();

		ArrayList<File> openFile = displayOpenFiles();

		System.out.println("\n\nEnter the Number which file you want to perform Operation");
		int n = Utility.inputNumber();

		String openFilepath = openFile.get(n - 1).toString();
		System.out.println(openFilepath);
		bookfile.operation(openFilepath);

	}

	// return the open File by adding into arrayList
	public static ArrayList<File> displayOpenFiles() {
		ArrayList<File> openFile = new ArrayList<>(); // to store openm file
		int count = 0;
		String existpath = Utility.getExistFilePath(); // get exist path of directory
		File file = new File(existpath);
		File[] list = file.listFiles(); // store list of Open file in File[]
		for (int i = 0; i < list.length; i++) {
			if (list[i].isFile()) {
				count++;
				String filename = getFileName(list[i]);
				System.out.println(count + " : " + filename);
				openFile.add(list[i]);
			}
		}
		return openFile;
	}

	private static String getFileName(File file) {
		String filename = file.toString();
		String splitedFilename[] = filename.split("[/]");
		int lastindex = splitedFilename.length - 1;
		return splitedFilename[lastindex];
	}

	public static void save() {

	}

	public static void saveAs(List<Person> personsList) throws IOException {

		System.out.println("Enter the New Name For file");
		String newName = Utility.inputString();
		currentFile = Utility.getCurrentFile(newName);
		boolean createNew = createNewaddressBook(currentFile);
		if (createNew) {
			System.out.println("New Address Book is Created : ");
		} else {
			System.out.println("Address Book is Present : ");
		}

		Utility.writetoBook(currentFile, personsList);

	}

	public static void detete() {
		ArrayList<File> list = AddressBookController.displayOpenFiles();
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Enter the number on Which you perform Deletion ......");
		int n = Utility.inputNumber();
		String selectFilepath = list.get(n - 1).toString(); // get file path which is on Particular index no.of
		File f = new File(selectFilepath);
		if (f.delete()) {
			System.out.println("AddressBook is Deleted");
		} else {
			System.out.println("Try for Again.......");
		}
	}

}
