/**
 * Provides Data Access Object (DAO) classes for managing database operations in
 * the Online Book Application.
 * <p>
 * This package contains utility classes responsible for handling database
 * connections and executing SQL queries. The primary class in this package is:
 * <ul>
 * <li>{@link com.onlinebookapp.dao.ConnectionBean} - Manages database
 * connections by providing methods to establish and close connections using
 * JDBC. It loads connection parameters from a properties file and handles the
 * connection lifecycle.</li>
 * </ul>
 * </p>
 * 
 * <p>
 * The classes in this package facilitate interaction with the database,
 * ensuring that connections are managed efficiently and SQL operations are
 * executed correctly. This separation of concerns helps maintain a clean and
 * organized codebase.
 * </p>
 * 
 * @since 1.0
 */
package com.onlinebookapp.dao;
