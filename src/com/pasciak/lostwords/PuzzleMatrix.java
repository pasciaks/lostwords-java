package com.pasciak.lostwords;

import java.util.HashMap;
import java.util.Map;

public class PuzzleMatrix {
	private Map<Integer, Map<Integer, PuzzlePiece>> matrix;

	public PuzzleMatrix() {
		matrix = new HashMap<>();
	}

	protected PuzzlePiece set(int row, int col, PuzzlePiece piece) {
		try {
			if (!matrix.containsKey(row)) {
				matrix.put(row, new HashMap<>());
			}
			matrix.get(row).put(col, piece);
			return matrix.get(row).get(col);
		} catch (Exception e) {
			return null;
		}
	}

	protected PuzzlePiece get(int row, int col) {
		try {
			if (matrix.containsKey(row) && matrix.get(row).containsKey(col)) {
				return matrix.get(row).get(col);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
}
