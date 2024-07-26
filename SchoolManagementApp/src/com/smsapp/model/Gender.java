package com.smsapp.model;

public enum Gender {

	MALE("Boy"), FEMALE("Girl");

	private final String gender;

	private Gender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}
}
