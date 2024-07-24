/**
 * Package contains Service class that implements the code logic of VoterApp.
 */
package com.voterapp.service;

import com.voterapp.exceptions.LocalityNotFoundException;
import com.voterapp.exceptions.NoVoterIDException;
import com.voterapp.exceptions.NotEligibleException;
import com.voterapp.exceptions.UnderAgeException;

/**
 * Service Class ElectionBooth that has the code logics to check the eligibility
 * for checking the age, locality, Id and Eligibility to Vote.
 * 
 * @author MonigaBalasubramanian
 */
public class ElectionBooth {

	// Initializing a String array to store the localities.
	String[] localities = { "Chennai", "Madurai", "Tirunelveli", "Coimbatore", "Salem" };

	/**
	 * boolean checkAge() method checks for the given age and throws an exception if
	 * the given condition is not satisfied.
	 * 
	 * @param age
	 * @return flag [true or false]
	 * @throws UnderAgeException
	 */
	public boolean checkAge(int age) throws UnderAgeException {
		boolean flag = false;
		if (age < 18) {
			throw new UnderAgeException("UnderAgeException: Age should be greater than 18!");
		} else {
			flag = true;
		}
		return flag;
	}

	/**
	 * boolean checkLocality() method checks for the presence of locality and if not
	 * present, throws an exception.
	 * 
	 * @param locality
	 * @return flag
	 * @throws LocalityNotFoundException
	 */
	public boolean checkLocality(String locality) throws LocalityNotFoundException {
		boolean flag = false;
		for (String loc : localities) {
			if (loc.equalsIgnoreCase(locality)) {
				flag = true;
				break;
			}
		}
		if (flag == false) {
			throw new LocalityNotFoundException("LocalityNotFoundException: There is no election in your locality");
		}

		return flag;
	}

	/**
	 * boolean checkVoterID() method checks for the given voterID and if the voterID
	 * doesn't satisfies the condition, it throws an exception.
	 * 
	 * @param vid
	 * @return flag
	 * @throws NoVoterIDException
	 */
	public boolean checkVoterID(int vid) throws NoVoterIDException {
		boolean flag = false;
		if (vid >= 100 && vid <= 999) {
			flag = true;
		} else {
			flag = false;
			throw new NoVoterIDException("NoVoterIDException: Age is not valid! Give correct age");
		}
		return flag;

	}

	/**
	 * boolean checkEligibility() method returns a boolean value true if all the
	 * conditions are satisfied and throws exception if either one of it is not
	 * satisfied.
	 * 
	 * @param age
	 * @param locality
	 * @param vid
	 * @return flag
	 * @throws NotEligibleException
	 */
	public boolean checkEligibility(int age, String locality, int vid) throws NotEligibleException {
		boolean flag = false;

		boolean checkage = checkAge(age);
		boolean checkloc = checkLocality(locality);
		boolean checkvid = checkVoterID(vid);
		if (checkage == true) {
			if (checkloc == true) {
				if (checkvid == true) {
					flag = true;
					System.out.println("Eligibility process is successful.. You're eligible to vote");
				}
			}
		} else {
			flag = false;
			throw new NotEligibleException("Not Eligible to vote!");
		}
		return flag;
	}
}
