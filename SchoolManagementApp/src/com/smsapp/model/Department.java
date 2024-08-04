package com.smsapp.model;

/**
 * Represents the departments in the School Management System.
 * <p>
 * Each department is associated with a string value representation.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public enum Department {

	MATHEMATICS("Mathematics"), SCIENCE("Science"), ENGLISH("English"), HISTORY("History"), GEOGRAPHY("Geography"),
	PHYSICS("Physics"), CHEMISTRY("Chemistry"), BIOLOGY("Biology"), COMPUTER_SCIENCE("Computer Science"),
	PHYSICAL_EDUCATION("Physical Education"), ART("Art"), MUSIC("Music"), SOCIAL_STUDIES("Social Studies"),
	LANGUAGE("Language"), BUSINESS_STUDIES("Business Studies"), ECONOMICS("Economics");

	private final String value;

	/**
	 * Constructor to initialize the department with a string value.
	 * 
	 * @param value the string representation of the department
	 */
	private Department(String value) {
		this.value = value;
	}

	/**
	 * Gets the string representation of the department.
	 * 
	 * @return the string representation of the department
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Converts a string value to its corresponding Department enum value.
	 * 
	 * @param value the string representation of the department
	 * @return the Department enum value corresponding to the string value
	 * @throws IllegalArgumentException if the string value does not match any
	 *                                  department
	 */
	public static Department fromValue(String value) {
		for (Department dept : Department.values()) {
			if (dept.getValue().equalsIgnoreCase(value)) {
				return dept;
			}
		}
		throw new IllegalArgumentException("No matching Department for value: " + value);
	}

	/**
	 * Gets the display value of the specified department.
	 * 
	 * @param department the Department enum value
	 * @return the string representation of the department
	 */
	public static String getDisplayValue(Department department) {
		return department.getValue();
	}
}
