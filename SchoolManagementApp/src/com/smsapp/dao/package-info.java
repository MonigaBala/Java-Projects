/**
 * Provides the classes necessary for managing database connections in the
 * School Management System application.
 * <p>
 * This package includes the {@link com.smsapp.dao.ConnectionBean} class, which
 * provides static methods for establishing and closing JDBC connections to the
 * database. The {@code ConnectionBean} class uses a properties file to load
 * connection parameters and manages the connection lifecycle.
 * </p>
 * <p>
 * Example usage:
 * 
 * <pre>{@code
 * Connection conn = ConnectionBean.openConnection();
 * // Use the connection
 * ConnectionBean.closeConnection();
 * }</pre>
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
package com.smsapp.dao;
