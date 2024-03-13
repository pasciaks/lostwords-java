package org.lostwords.library;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DeleteLostWordExample {
	public static void main(String[] args) {
		// JDBC URL, username, and password
		String url = "jdbc:mysql://localhost:3306/your_database_name";
		String username = "your_username";
		String password = "your_password";

		// SQL statement to call stored procedure
		String sql = "{CALL DeleteLostWord(?)}";

		try (Connection conn = DriverManager.getConnection(url, username, password);
				CallableStatement stmt = conn.prepareCall(sql)) {

			// Set value for stored procedure parameter (ID of the row to be deleted)
			stmt.setInt(1, 1); // Assuming the ID of the row to be deleted is 1

			// Execute the stored procedure
			stmt.execute();

			System.out.println("Delete successful.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
