package com.smsapp.model;

/**
 * Represents the gender of an individual.
 * <p>
 * This enum includes predefined constants for male, female, and other genders.
 * Each constant has a string representation that can be retrieved or used to
 * create an enum instance.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public enum Gender {
	MALE("Male"), FEMALE("Female"), OTHER("Other");

	private String value;

	/**
	 * Constructor to initialize the enum constant with its string representation.
	 * 
	 * @param value the string representation of the gender
	 */
	Gender(String value) {
		this.value = value;
	}

	/**
	 * Gets the string representation of the gender.
	 * 
	 * @return the string representation of the gender
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Creates a Gender enum constant from its string representation.
	 * 
	 * @param value the string representation of the gender
	 * @return the Gender enum constant
	 * @throws IllegalArgumentException if the value does not match any Gender
	 *                                  constant
	 */
	public static Gender fromValue(String value) {
		for (Gender gender : values()) {
			if (gender.getValue().equalsIgnoreCase(value)) {
				return gender;
			}
		}
		throw new IllegalArgumentException("Unknown Gender " + value);
	}
}
