/**
 * This package contains the service classes for the VoterApp application. It
 * includes core functionalities for checking voter eligibility based on various
 * criteria such as age, locality, and voter ID.
 * 
 * The main class in this package is {@link ElectionBooth}, which provides
 * methods to validate: - Age (must be 18 or older) - Locality (must be within a
 * predefined set of localities) - Voter ID (must be a three-digit number)
 * 
 * Custom exceptions are used to handle scenarios where a voter is not eligible
 * due to failing one or more of these criteria. The custom exceptions used are:
 * - {@link com.voterapp.exceptions.UnderAgeException} -
 * {@link com.voterapp.exceptions.LocalityNotFoundException} -
 * {@link com.voterapp.exceptions.NoVoterIDException} -
 * {@link com.voterapp.exceptions.NotEligibleException}
 * 
 * By encapsulating these functionalities within this package, the application
 * maintains a clear separation of concerns and ensures that eligibility checks
 * are performed consistently and reliably.
 * 
 * @see com.voterapp.service.ElectionBooth
 * @see com.voterapp.exceptions.UnderAgeException
 * @see com.voterapp.exceptions.LocalityNotFoundException
 * @see com.voterapp.exceptions.NoVoterIDException
 * @see com.voterapp.exceptions.NotEligibleException
 * 
 * @author MonigaBalasubramanian
 */
package com.voterapp.service;
