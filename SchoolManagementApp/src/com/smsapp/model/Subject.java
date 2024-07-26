package com.smsapp.model;

public enum Subject {

	MATHEMATICS("Mathematics"), SCIENCE("Science"), TAMIL("Tamil"), ENGLISH("English"), HISTORY("History"),
	GEOGRAPHY("Geography"), PHYSICS("Physics"), CHEMISTRY("Chemistry"), BIOLOGY("Biology"),
	COMPUTER_SCIENCE("Computer Science"), PHYSICAL_EDUCATION("Physical Education"), ART("Art"),
	GENERAL_KNOWLEDGE("General Knowledge"), MUSIC("Music");

	private final String subjectName;

	private Subject(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectName() {
		return subjectName;
	}
}
