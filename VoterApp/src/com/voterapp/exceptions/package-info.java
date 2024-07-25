/**
 * The package com.voterapp.exceptions encloses different custom exceptions that
 * may occur in the service package of the voter application.
 * 
 * This package includes:
 * <ul>
 * <li>{@link com.voterapp.exceptions.LocalityNotFoundException} - Thrown when a
 * user's locality is not found.</li>
 * <li>{@link com.voterapp.exceptions.NoVoterIDException} - Thrown when a user
 * does not have a valid voter ID.</li>
 * <li>{@link com.voterapp.exceptions.UnderAgeException} - Thrown when a user is
 * not eligible due to being under the required age limit.</li>
 * <li>{@link com.voterapp.exceptions.NotEligibleException} - Base exception for
 * indicating ineligibility.</li>
 * </ul>
 * 
 * By using these custom exceptions, the voter application can handle various
 * ineligibility scenarios in a consistent and informative manner, providing
 * better error handling and user feedback.
 * 
 * @author MonigaBalasubramanian
 */
package com.voterapp.exceptions;
