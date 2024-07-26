package com.smsapp.model;

public enum Department {

	MATHEMATICS("Mathematics"), SCIENCE("Science"), ENGLISH("English"), HISTORY("History"), GEOGRAPHY("Geography"),
	PHYSICS("Physics"), CHEMISTRY("Chemistry"), BIOLOGY("Biology"), COMPUTER_SCIENCE("Computer Science"),
	PHYSICAL_EDUCATION("Physical Education"), ART("Art"), MUSIC("Music"), SOCIAL_STUDIES("Social Studies"),
	LANGUAGE("Language"), BUSINESS_STUDIES("Business Studies"), ECONOMICS("Economics");

	private final String departmentName;

	private Department(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}
}
