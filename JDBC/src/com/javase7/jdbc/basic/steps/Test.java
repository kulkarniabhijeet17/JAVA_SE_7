package com.javase7.jdbc.basic.steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// Step 2: Register JDBC Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Step 3: Open a Connection
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Pulsor@150cc");
			stmt = conn.createStatement();
			String sql = null;
			// sql = "insert into user_info_tbl values(1, 'abhijeet24', '@bhijeetdada89', 'Abhijeet', 'Kulkarni','shonest tower, wakad', 'India', 'Maharashtra', 'Pune', 'Wakad')";
			sql = "SELECT user_seq, user_id, first_name, last_name FROM user_info_tbl";
			// int i = stmt.executeUpdate(sql);
			ResultSet rs = stmt.executeQuery(sql);
			// System.out.println("Number of rows inserted are:: " + i);
			while (rs.next()) {
				System.out.println(rs.getString("first_name"));
			}
		} catch (SQLException | ClassNotFoundException s) {
		}
	}
}