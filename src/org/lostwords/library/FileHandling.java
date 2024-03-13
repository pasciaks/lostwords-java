package org.lostwords.library;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandling {

	public static List<String> readFileIntoListOfStrings(String fileName) {
		String line = null;
		boolean hasError = false;
		Error error = null;
		List<String> arrayListOfStrings = new ArrayList<>();
		// NOTE: Auto-closable try-with-resources
		try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
			while ((line = in.readLine()) != null) {
				arrayListOfStrings.add(line);
			}
		} catch (FileNotFoundException e) { // Catch file not found exceptions
			// System.err.println(e);
			error = new Error("File not found: " + fileName);
			hasError = true;
		} catch (IOException e) { // Catch IO exceptions
			// System.err.println(e);
			error = new Error("IO Exception: " + e.getMessage());
			hasError = true;
		} catch (Exception e) { // Catch all other exceptions
			// System.err.println(e);
			error = new Error("Exception: " + e.getMessage());
			hasError = true;
		} finally {
			// NOTE: No close() method to call, try-with-resources does it for us
		}

		if (hasError) {
			// consider early return of new empty ArrayList<>();
			// System.err.println(error);
			// System.err.println(error.getMessage());
		}

		return arrayListOfStrings;
	}

}
