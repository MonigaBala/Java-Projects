package com.smsapp.model;

/**
 * Represents blood groups in the School Management System.
 * <p>
 * Each blood group is associated with a string value representation.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public enum BloodGroup {
	B_POSITIVE("B+ve"), A_POSITIVE("A+ve"), O_POSITIVE("O+ve"), AB_POSITIVE("AB+ve"), AB_NEGATIVE("AB-ve"),
	O_NEGATIVE("O-ve"), A_NEGATIVE("A-ve"), B_NEGATIVE("B-ve");

	private String value;

	/**
	 * Constructor to initialize the blood group with a string value.
	 * 
	 * @param value the string representation of the blood group
	 */
	BloodGroup(String value) {
		this.value = value;
	}

	/**
	 * Gets the string representation of the blood group.
	 * 
	 * @return the string representation of the blood group
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Converts a string value to its corresponding BloodGroup enum value.
	 * 
	 * @param value the string representation of the blood group
	 * @return the BloodGroup enum value corresponding to the string value
	 * @throws IllegalArgumentException if the string value does not match any blood
	 *                                  group
	 */
	public static BloodGroup fromValue(String value) {
		for (BloodGroup bloodGroup : values()) {
			if (bloodGroup.getValue().equalsIgnoreCase(value)) {
				return bloodGroup;
			}
		}
		throw new IllegalArgumentException("Unknown BloodGroup " + value);
	}
}
