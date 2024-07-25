package com.voterapp.main;

import java.util.Scanner;
import com.voterapp.service.ElectionBooth;

/**
 * The Voter class contains the main method to interact with the user and check
 * their eligibility for voting based on their age, locality, and voter ID.
 * 
 * It provides a command-line interface for the user to input their details and
 * then uses the {@link ElectionBooth} class to validate their eligibility.
 * 
 * The flow of the program is as follows: 1. The user is prompted to enter their
 * age, locality, and voter ID. 2. The input values are passed to the
 * {@link ElectionBooth} instance's
 * {@link ElectionBooth#checkEligibility(int, String, int)} method. 3. If all
 * criteria are met, the user is informed that they are eligible to vote. 4. If
 * any criteria are not met, an appropriate exception message is displayed.
 * 
 * The program handles various exceptions that may be thrown during the
 * eligibility check and provides relevant feedback to the user.
 * 
 * @author MonigaBalasubramanian
 */
public class Voter {

	/**
	 * Main method to run the Voter application.
	 * 
	 * @param args command-line arguments (not used in this application)
	 */
	public static void main(String[] args) {

		// Create an instance of ElectionBooth to perform eligibility checks.
		ElectionBooth election = new ElectionBooth();

		// Use Scanner to read input from the user.
		try (Scanner scanner = new Scanner(System.in)) {

			// Prompt the user to enter their age.
			System.out.println("Enter the age to check for voting:");
			int agecheck = scanner.nextInt();
			scanner.nextLine(); // Consume newline left-over.

			// Prompt the user to enter their locality.
			System.out.println("Enter your corresponding locality: ");
			String locality = scanner.nextLine();

			// Prompt the user to enter their voter ID.
			System.out.println("Enter your voter ID: ");
			int voteID = scanner.nextInt();

			// Check the eligibility of the voter using the ElectionBooth instance.
			election.checkEligibility(agecheck, locality, voteID);

		} catch (Exception e) {
			// Catch any exceptions thrown during eligibility check and display the message.
			System.out.println(e.getMessage());
		}
	}
}
