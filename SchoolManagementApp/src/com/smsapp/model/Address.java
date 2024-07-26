package com.smsapp.model;

public class Address {

	private int doorNo;
	private String street;
	private String city;
	private String district;
	private int pincode;
	private String state;
	private String country;

	public Address() {
		super();
	}

	public Address(int doorNo, String street, String city, String district, int pincode, String state, String country) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.city = city;
		this.district = district;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
	}

	public int getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", street=" + street + ", city=" + city + ", district=" + district
				+ ", pincode=" + pincode + ", state=" + state + ", country=" + country + "]";
	}

}
