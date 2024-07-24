/**
 * Package that contains main class to execute the VoterApp. 
 */
package com.voterapp.main;

/** 
 * 
 * @author MonigaBalasubramanian
 */
import java.util.Scanner;
import com.voterapp.service.ElectionBooth;

/**
 * Main Class Voter with an instance to check for the eligibility of the voting.
 * 
 * @author MonigaBalasubramanian
 */
public class Voter {

	public static void main(String[] args) {

		ElectionBooth election = new ElectionBooth();
		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Enter the age to check for voting:");
			int agecheck = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Enter your corresponding locality: ");
			String locality = scanner.nextLine();

			System.out.println("Enter your voter ID: ");
			int voteID = scanner.nextInt();
			// Checking for the eligibility to vote.
			election.checkEligibility(agecheck, locality, voteID);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
