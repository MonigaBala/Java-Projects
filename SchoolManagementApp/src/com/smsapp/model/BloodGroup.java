package com.smsapp.model;

public enum BloodGroup {

	BPOSITIVE("B+ve"), APOSITIVE("A+ve"), OPOSITIVE("O+ve"), ABPOSITIVE("AB+ve"), ABNEGATIVE("AB-ve"),
	ONEGATIVE("O-ve"), ANEGATIVE("A-ve"), BNEGATIVE("B-ve");

	private final String bloodGroup;

	BloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}
}
