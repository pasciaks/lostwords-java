package org.lostwords.library;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class InsertLostWordExample {
	public static void main(String[] args) {
		// JDBC URL, username, and password
		String url = "jdbc:mysql://localhost:3306/your_database_name";
		String username = "your_username";
		String password = "your_password";

		// SQL statement to call stored procedure
		String sql = "{CALL InsertLostWord(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

		try (Connection conn = DriverManager.getConnection(url, username, password);
				CallableStatement stmt = conn.prepareCall(sql)) {

			// Set values for stored procedure parameters
			stmt.setInt(1, 8); // puzzle_rows_param
			stmt.setInt(2, 8); // puzzle_cols_param
			stmt.setString(3, "example words"); // words_param
			stmt.setString(4, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"); // fill_characters_param
			stmt.setString(5, "DWXQEZC0123456789"); // available_directions_param
			stmt.setNull(6, Types.INTEGER); // category_id_param (assuming null)
			stmt.setNull(7, Types.VARCHAR); // generated_puzzle_param (assuming null)
			stmt.setNull(8, Types.VARCHAR); // word_hidden_param (assuming null)
			stmt.setNull(9, Types.VARCHAR); // hide_positions_param (assuming null)
			stmt.setNull(10, Types.INTEGER); // creator_id_param (assuming null)
			stmt.setString(11, "Example Title"); // title_param
			stmt.setString(12, "Example Description"); // description_param
			stmt.setNull(13, Types.INTEGER); // total_views_param (assuming null)
			stmt.setNull(14, Types.INTEGER); // total_plays_param (assuming null)
			stmt.setNull(15, Types.VARCHAR); // optional_image_param (assuming null)

			// Register output parameter for last_insert_id
			stmt.registerOutParameter(16, Types.INTEGER);

			// Execute the stored procedure
			stmt.execute();

			// Retrieve the last inserted ID
			int lastInsertId = stmt.getInt(16);
			System.out.println("Last Inserted ID: " + lastInsertId);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
