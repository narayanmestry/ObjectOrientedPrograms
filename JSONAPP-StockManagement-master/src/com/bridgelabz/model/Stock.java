package com.bridgelabz.model;

import java.util.ArrayList;

public class Stock {
	private int id;
	private String symbol;
	private String companyname ;
	private int noOfShare;
	private int priceperShare;
	private int totalPriceOfshare;
	private int companyAmount;
	private String date;
	private ArrayList<User> user;
 	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public int getNoOfShare() {
		return noOfShare;
	}
	public void setNoOfShare(int noOfShare) {
		this.noOfShare = noOfShare;
	}
	public int getPriceperShare() {
		return priceperShare;
	}
	public void setPriceperShare(int priceperShare) {
		this.priceperShare = priceperShare;
	}
	public int getTotalPriceOfshare() {
		return totalPriceOfshare;
	}
	public void setTotalPriceOfshare(int totalPriceOfshare) {
		this.totalPriceOfshare = totalPriceOfshare;
	}
	public int getCompanyAmount() {
		return companyAmount;
	}
	public void setCompanyAmount(int companyAmount) {
		this.companyAmount = companyAmount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ArrayList<User> getUser() {
		return user;
	}
	public void setUser(ArrayList<User> user) {
		this.user = user;
	}
	
	
}
