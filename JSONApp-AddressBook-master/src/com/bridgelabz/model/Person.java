package com.bridgelabz.model;

public class Person {
	private String fname;
	private String lname;
	private Address address;
	private int zip;
	private String mobNo;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String Zipget() {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString()
	{
		Address a = new Address();
		String personInfo = "First Name :"+fname+"\nLast Mestry :"+lname+"\n City :"+a.getCity()+"\n State :"+a.getState()+"\nZipCode :"+zip+"\n Mobile no."+mobNo;
		return personInfo;
		
	}
	
}
