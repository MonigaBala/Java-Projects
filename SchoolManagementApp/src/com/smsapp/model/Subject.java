package com.smsapp.model;

/**
 * Represents the subjects taught in the school management system.
 * <p>
 * This enum includes predefined constants for various subjects, each with a
 * string representation. It provides methods to retrieve the string
 * representation, create an enum instance from a string, and get the display
 * value of a subject.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public enum Subject {

	MATHEMATICS("Mathematics"), SCIENCE("Science"), TAMIL("Tamil"), ENGLISH("English"), HISTORY("History"),
	GEOGRAPHY("Geography"), PHYSICS("Physics"), CHEMISTRY("Chemistry"), BIOLOGY("Biology"),
	COMPUTER_SCIENCE("Computer Science"), PHYSICAL_EDUCATION("Physical Education"), ART("Art"),
	GENERAL_KNOWLEDGE("General Knowledge"), MUSIC("Music"), UNKNOWN("Unknown");

	private final String value;

	/**
	 * Constructor to initialize the enum constant with its string representation.
	 * 
	 * @param value the string representation of the subject
	 */
	private Subject(String value) {
		this.value = value;
	}

	/**
	 * Gets the string representation of the subject.
	 * 
	 * @return the string representation of the subject
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Creates a Subject enum constant from its string representation.
	 * 
	 * @param value the string representation of the subject
	 * @return the Subject enum constant
	 * @throws IllegalArgumentException if the value does not match any Subject
	 *                                  constant
	 */
	public static Subject fromValue(String value) {
		for (Subject subject : Subject.values()) {
			if (subject.getValue().equalsIgnoreCase(value)) {
				return subject;
			}
		}
		throw new IllegalArgumentException("No matching Subject for value: " + value);
	}

	/**
	 * Gets the display value of a subject.
	 * 
	 * @param subject the Subject enum constant
	 * @return the string representation of the subject
	 */
	public static String getDisplayValue(Subject subject) {
		return subject.getValue();
	}
}
