package com.javase7.oracle.jdbc;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

public class OracleJDBC {
	final static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String DB_USER = "system";
	final static String DB_PASSWORD = "Pulsor@150cc";

	public static void main(String args[]) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL(DB_URL);
		ods.setUser(DB_USER);
		ods.setPassword(DB_PASSWORD);

		try (OracleConnection conn = (OracleConnection) ods.getConnection()) {
			// Get the JDBC driver name and version
			DatabaseMetaData databaseMetaData = conn.getMetaData();
			System.out.println("Driver Name: " + databaseMetaData.getDriverName());
			System.out.println("Driver Version: " + databaseMetaData.getDriverVersion());
			// Print some connection properties
			System.out.println("Default Row Prefetch Value is: " + conn.getDefaultRowPrefetch());
			System.out.println("Database Username is: " + conn.getUserName());
			conn.setAutoCommit(false);
			// Perform a database operation
			try (Statement statement = conn.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery("select first_name, last_name from user_info_tbl")) {
					while (resultSet.next())
						System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " ");
				}
			}
		}
	}
}