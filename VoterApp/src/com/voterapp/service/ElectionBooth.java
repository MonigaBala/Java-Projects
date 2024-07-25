package com.voterapp.service;

import com.voterapp.exceptions.LocalityNotFoundException;
import com.voterapp.exceptions.NoVoterIDException;
import com.voterapp.exceptions.NotEligibleException;
import com.voterapp.exceptions.UnderAgeException;

/**
 * The ElectionBooth class provides the core functionality for checking the
 * eligibility of a voter based on their age, locality, and voter ID. It
 * contains methods to validate each of these criteria and a method to check
 * overall eligibility.
 * 
 * The eligibility checks include: - Age verification (must be 18 or older) -
 * Locality verification (must be within a predefined set of localities) - Voter
 * ID verification (must be a three-digit number)
 * 
 * If any of these conditions are not met, a custom exception is thrown.
 * 
 * @author MonigaBalasubramanian
 */
public class ElectionBooth {

	// Initializing a String array to store the localities.
	String[] localities = { "Chennai", "Madurai", "Tirunelveli", "Coimbatore", "Salem" };

	/**
	 * Checks if the age is 18 or older.
	 * 
	 * @param age the age of the voter
	 * @return true if the age is 18 or older
	 * @throws UnderAgeException if the age is less than 18
	 */
	public boolean checkAge(int age) throws UnderAgeException {
		if (age < 18) {
			throw new UnderAgeException("UnderAgeException: Age should be greater than 18!");
		}
		return true;
	}

	/**
	 * Checks if the provided locality is within the allowed localities.
	 * 
	 * @param locality the locality of the voter
	 * @return true if the locality is valid
	 * @throws LocalityNotFoundException if the locality is not found in the allowed
	 *                                   list
	 */
	public boolean checkLocality(String locality) throws LocalityNotFoundException {
		for (String loc : localities) {
			if (loc.equalsIgnoreCase(locality)) {
				return true;
			}
		}
		throw new LocalityNotFoundException("LocalityNotFoundException: There is no election in your locality");
	}

	/**
	 * Checks if the voter ID is a valid three-digit number.
	 * 
	 * @param voterId the voter ID
	 * @return true if the voter ID is valid
	 * @throws NoVoterIDException if the voter ID is not a valid three-digit number
	 */
	public boolean checkVoterID(int voterId) throws NoVoterIDException {
		if (voterId >= 100 && voterId <= 999) {
			return true;
		} else {
			throw new NoVoterIDException(
					"NoVoterIDException: Voter ID is not valid! It should be a three-digit number.");
		}
	}

	/**
	 * Checks the overall eligibility of a voter based on age, locality, and voter
	 * ID.
	 * 
	 * @param age      the age of the voter
	 * @param locality the locality of the voter
	 * @param voterId  the voter ID
	 * @return true if all conditions are satisfied
	 * @throws NotEligibleException if any condition is not satisfied
	 */
	public boolean checkEligibility(int age, String locality, int voterId) throws NotEligibleException {
		boolean result = false;

		boolean checkage = checkAge(age);
		boolean checklocality = checkLocality(locality);
		boolean checkvoterid = checkVoterID(voterId);
		if (checkage == true) {
			if (checklocality == true) {
				if (checkvoterid == true) {
					result = true;
					System.out.println("Eligibility process is successful.. You're eligible to vote");
				}
			}
		} else {
			result = false;
			throw new NotEligibleException("Not Eligible to vote!");
		}
		return result;
	}
}
