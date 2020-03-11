package com.bridgelabz.Driver;

import java.io.IOException;
import com.bridgelabz.controller.CliniqueControl;
import com.bridgelabz.utility.Utility;

public class CliniqueManagementApp {

	public static void main(String[] args) throws IOException {
		start();

	}

	public static void start() throws IOException {
		int ch;
		char c;
		do {
			System.out.println("Select the User :\n1.Admin\n2.User (Doctor/Patient)");
			ch = Utility.inputNumber();
			switch (ch) {
			case 1:
				System.out.println("Enter the Username :");
				String uname = Utility.inputString();
				System.out.println("Enter the Password");
				String pass = Utility.inputString();
				if (uname.equals("admin") && pass.equals("admin123")) {
					CliniqueControl.adminOperation();
				} else {
					System.out.println("Invalid Username and Password");
				}
				break;
			case 2:
				CliniqueControl.UserOperation();

				break;

			default:
				System.out.println("Enter the Valid Choice ..........!!!!!");
			}
			System.out.println("Do you want to Continue : ............Press Y or y");
			c = Utility.inputchar();
		} while (c == 'Y' || c == 'y');

	}
}
