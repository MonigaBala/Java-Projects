/**
 * This package contains the main classes for the VoterApp application, which
 * serve as the entry point for the application.
 * 
 * The primary class in this package is {@link Voter}, which includes the `main`
 * method to interact with the user and check their eligibility for voting.
 * 
 * The Voter class provides a command-line interface for the user to input their
 * age, locality, and voter ID. It then utilizes the
 * {@link com.voterapp.service.ElectionBooth} class to validate the user's
 * eligibility based on these criteria.
 * 
 * The main steps involved in the application are: 1. Prompting the user for
 * their age, locality, and voter ID. 2. Passing these inputs to the
 * {@link com.voterapp.service.ElectionBooth#checkEligibility(int, String, int)}
 * method for validation. 3. Informing the user of their eligibility status or
 * displaying an error message if any criteria are not met.
 * 
 * This package ensures that the application handles user inputs and exceptions
 * appropriately, providing clear feedback to users regarding their voting
 * eligibility.
 * 
 * @see com.voterapp.service.ElectionBooth
 * @see com.voterapp.exceptions.UnderAgeException
 * @see com.voterapp.exceptions.LocalityNotFoundException
 * @see com.voterapp.exceptions.NoVoterIDException
 * @see com.voterapp.exceptions.NotEligibleException
 * 
 * @author MonigaBalasubramanian
 */
package com.voterapp.main;
