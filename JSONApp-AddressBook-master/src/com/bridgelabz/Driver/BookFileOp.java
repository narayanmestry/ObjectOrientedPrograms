package com.bridgelabz.Driver;

import java.io.IOException;
import java.util.ArrayList;
import com.bridgelabz.controller.BookOpController;
import com.bridgelabz.model.Person;
import com.bridgelabz.utility.Utility;

public class BookFileOp {
	static ArrayList<Person> personsList;

	public void operation(String openFilepath) throws IOException {
		BookOpController fc = new BookOpController();
		int ch;
		char c;
		do
		{
		System.out.println("Enter your choice");
		System.out.println("1. Add the Person");
		System.out.println("2. Edit the Person details :");
		System.out.println("3. Delete the Person");
		System.out.println("4. Sort the Entry by Name");
		System.out.println("5. Sort the Entry by Zip code");
		System.out.println("6. Print Entry ");
		System.out.println("7. Back	 ");

		ch = Utility.inputNumber();

		switch (ch) {
		case 1:
			fc.addNewPerson(openFilepath);
		
			break;

		case 2:
			fc.editPerson(openFilepath);
			break;

		case 3:
			fc.deletPerson(openFilepath);
			break;

		case 4:
			fc.sortEntryByName(openFilepath);
			break;

		case 5:
			fc.sortEntryByZip(openFilepath);
			break;

		case 6:
			fc.printEntry(openFilepath);
			break;

		case 7 :
			try {
				AddressBookApp.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			break;
		default:
			System.out.println("Enter valid choice :");

		}
		System.out.println("Do you want to Continue......Press Y or y");
		c=Utility.inputchar();
		}while(c=='y'||c=='Y');
	}

}
