package com.bridgelabz.Controller;

import java.util.ArrayList;
import java.util.Date;

import com.bridgelabz.Driver.StockManagementApp;
import com.bridgelabz.model.Stock;
import com.bridgelabz.model.User;
import com.bridgelabz.utility.Utility;

public class StockManageControl {

	static ArrayList<User> userList = new ArrayList<>();
	static User u = new User();
	static String userfilePath = "/home/admin2/eclipse-workspace/JSON-OOPS-StockManagementApp/src/com/bridgelabz/repo/userList.json";

	public static ArrayList<Stock> getStockData(ArrayList<Stock> stockdata) {
		Date date = new Date();
		Stock stock = new Stock();

		System.out.println("Enter the Company Id ");
		stock.setId(Utility.inputNumber());

		System.out.println("Enter the Comany Name :");
		stock.setCompanyname(Utility.inputString());

		System.out.println("Enter the Comany Symbol :");
		stock.setSymbol(Utility.inputString());

		System.out.println("Enter the Number of Share :");
		stock.setNoOfShare(Utility.inputNumber());

		System.out.println("Enter the Price per share :");
		stock.setPriceperShare(Utility.inputNumber());

		stock.setTotalPriceOfshare(stock.getNoOfShare() * stock.getPriceperShare());

		System.out.println("Enter the Company Total Amonut");
		stock.setCompanyAmount(Utility.inputNumber());
		stock.setDate(date.toString());
		boolean present = isPresentStock(stockdata, stock);
		System.out.println(present);
		if (!present) {
			stockdata.add(stock);
		}
		return stockdata;
	}

	private static boolean isPresentStock(ArrayList<Stock> stockdata, Stock stock) {
		int flag = 0;
		for (Stock st : stockdata) {
			if (stock.getCompanyname().equals(st.getCompanyname())) {
				st.setNoOfShare(stock.getNoOfShare());
				st.setPriceperShare(stock.getPriceperShare());
				st.setTotalPriceOfshare(st.getNoOfShare() * st.getPriceperShare());
				flag = 1;
				break;
			}
		}

		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * 
	 * private int id; private String symbol; private String companyname ; private
	 * int noOfShare; private int priceperShare; private int totalPriceOfshare;
	 * private String companyAmount; private String date;
	 */
	public static void calculatedStockReport(ArrayList<Stock> stockdata) {
		System.out.println("Stock-Report : \n");
		System.out.println(
				"ID\tSymbol\tCompany Name\tNo of Share\tPrice per Share \tTotalProice\tCompany Amount \t\tTime\n"
						+ "--------------------------------------------------------------------------------------------------------------------------------------------");
		for (Stock s : stockdata) {
			System.out.println(s.getId() + "\t" + s.getSymbol() + "\t" + s.getCompanyname() + "\t\t" + s.getNoOfShare()
					+ "" + "\t\t" + s.getPriceperShare() + "$\t\t\t" + s.getNoOfShare() * s.getPriceperShare() + "$\t\t"
					+ s.getCompanyAmount() + "$" + "\t\t\t" + s.getDate());
			System.out.println(
					"--------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}

	public static void CommecialDataProcessing(String filePath, ArrayList<Stock> stockdata) {

		int ch;
		char c;
		userList = Utility.readUserData(userfilePath, userList);
		do {
			System.out.println("Enter the Choice :\n\t1.Create User Account \n\t2. Buy the share \n\t3. Sell the Share:"
					+ "\n\t4. User-Report \n\t5. Stock-Report \n\t6. Back");
			ch = Utility.inputNumber();
			switch (ch) {
			case 1:
				u = createUserAccount();
				userList.add(u);
				Utility.writeUserData(userfilePath, userList);
				break;

			case 2:
				buyShare(filePath, stockdata);
				break;
			case 3:
				sellShare();
				break;
			case 4:
				showUserDetails();
				break;
			case 5:
				calculatedStockReport(stockdata);
				break;
			case 6:
				StockManagementApp.start();
				break;

			default:
				System.out.println("Enter the Valid choice :");

			}
			System.out.println("Do you want to Continue .......press Y || y");
			c = Utility.inputChar();
		} while (c == 'Y' || c == 'y');

	}

	// Display the User Details :

	private static void showUserDetails() {
		userList = Utility.readUserData(userfilePath, userList);
		System.out.println("UID\tUsername\tBuy Share\tSold Share\tTotal Amount"
				+ "\n----------------------------------------------------------------------------------");

		for (User u : userList) {
			System.out.println(u.getUid() + "\t" + u.getName() + "\t\t" + u.getBuyshare() + "\t\t" + u.getSoldShare()
					+ "\t\t" + u.getUseramount() + ""
					+ "\n----------------------------------------------------------------------------------");
		}
	}

	private static void buyShare(String filePath, ArrayList<Stock> stockdata) {
		stockdata = Utility.readStockData(filePath, stockdata);

		u = isvalid(); // Check the particular user present or not

		if (u != null) {
			calculatedStockReport(stockdata);
			System.out.println("Enter the Company name to buy the Share :");
			String name = Utility.inputString();
			System.out.println("How many share want to buy ?");
			int number = Utility.inputNumber();

			for (Stock s : stockdata) {
				if (s.getCompanyname().equalsIgnoreCase(name.toLowerCase())) {

					s.setNoOfShare(s.getNoOfShare() - number);
					s.setTotalPriceOfshare(s.getNoOfShare() * s.getPriceperShare());
					s.setCompanyAmount((number * s.getPriceperShare()) + s.getCompanyAmount());
					u.setBuyshare(u.getBuyshare() + number);
					u.setUseramount(u.getUseramount() - (number * s.getPriceperShare()));
					Utility.writeStockData(filePath, stockdata);
					Utility.writeUserData(userfilePath, userList);
					System.out.println("User buy " + number + " share Successfully........");
					break;
				}
			}
		} else {
			System.out.println("Please create Account First ...");
		}

	}

	private static void sellShare() {
		u = isvalid();
		int number, price;
		if (u != null) {
			do {
				System.out.println("How many share want to sell ?");
				number = Utility.inputNumber();
				System.out.println("How much price of Per share ?");
				price = Utility.inputNumber();

				if (number > u.getBuyshare() && number > 0) {
					System.out.println("You have not enough Share....Enter again ");
				}
				u.setBuyshare(u.getBuyshare() - number);
				u.setUseramount(u.getUseramount() + (price*number));
			} while (number > u.getBuyshare() && number > 0);

			Utility.writeUserData(userfilePath, userList);
			System.out.println("User Sold Share SuccessFully..........");
		}
	}

	private static User isvalid() {
		userList = Utility.readUserData(userfilePath, userList);
		System.out.println("Enter the Username First :");
		String username = Utility.inputString();
		for (User u : userList) {
			if (u.getName().equalsIgnoreCase(username)) {
				return u;
			}

		}
		return null;
	}

	private static User createUserAccount() {
		System.out.println("Enter the User Id  : ");
		u.setUid(Utility.inputNumber());
		System.out.println("Enter the username : ");
		u.setName(Utility.inputString());
		System.out.println("Enter the Amount User have :");
		u.setUseramount(Utility.inputNumber());

		return u;

	}

}
