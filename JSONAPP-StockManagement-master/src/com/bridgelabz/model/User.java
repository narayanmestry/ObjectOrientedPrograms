package com.bridgelabz.model;

public class User {

	private int uid;
	private String name;
	private int buyshare;
	private int soldShare;
	private long useramount;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBuyshare() {
		return buyshare;
	}

	public void setBuyshare(int buyshare) {
		this.buyshare = buyshare;
	}

	public int getSoldShare() {
		return soldShare;
	}

	public void setSoldShare(int soldShare) {
		this.soldShare = soldShare;
	}

	public long getUseramount() {
		return useramount;
	}

	public void setUseramount(long useramount) {
		this.useramount = useramount;
	}

}
