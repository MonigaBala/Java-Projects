/**
 * Provides the classes and interfaces for managing exams within the school
 * management system.
 * <p>
 * This package contains functionalities related to exam operations, including:
 * <ul>
 * <li>Assigning students and teachers to exams</li>
 * <li>Retrieving exam details by student ID or date</li>
 * <li>Calculating total marks obtained by students across all exams</li>
 * <li>Deleting exam-related records</li>
 * </ul>
 * The classes in this package interact with the database to perform these
 * operations, using JDBC for database connectivity and transactions.
 * </p>
 * 
 * <p>
 * Key Classes:
 * <ul>
 * <li>{@link com.smsapp.services.implementations.ExamImpl} - Implements the
 * business logic for exam management.</li>
 * <li>{@link com.smsapp.exceptions.ExamNotFoundException} - Custom exception
 * thrown when an exam is not found.</li>
 * </ul>
 * </p>
 * 
 * <p>
 * This package ensures that exam-related data is managed efficiently and
 * consistently across the application, handling both retrieval and modification
 * of exam records.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
package com.smsapp.services.implementations;
