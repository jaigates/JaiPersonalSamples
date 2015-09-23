package com.mkyong.common.model;

public class Shop {

	String name;

	String staffName[];

	public Shop() {
	}

	public String getName() {
		return name;
	}

	public String[] getStaffName() {
		return staffName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStaffName(String[] staffName) {
		this.staffName = staffName;
	}

}