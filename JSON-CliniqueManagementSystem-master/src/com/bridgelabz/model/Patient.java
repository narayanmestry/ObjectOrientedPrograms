package com.bridgelabz.model;

public class Patient {
	private int Pid;
	private String name ;
	private int age ;
	private String mobileNo;
	private String appontedDrName ;
	private String date;
	
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAppontedDrName() {
		return appontedDrName;
	}
	public void setAppontedDrName(String appontedDrName) {
		this.appontedDrName = appontedDrName;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
		
	}
	
	
}
