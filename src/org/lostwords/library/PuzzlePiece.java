package org.lostwords.library;

import java.awt.Color;

public class PuzzlePiece {

	char letter;
	int row;
	int col;
	Color color;

	public PuzzlePiece(char letter, Color color, int row, int col) {

		if (color == null) {
			color = new Color(255, 255, 255, 255);
		}

		this.letter = letter;
		this.color = color;
		this.row = row;
		this.col = col;
	}

	public Color setColor(int r, int g, int b, int a) {
		Color previousColor = this.color;
		color = new Color(r, g, b, a);
		return previousColor;
	}

	public char setLetter(char letter) {
		char previousLetter = this.letter;
		this.letter = letter;
		return previousLetter;
	}

	public char getLetter() {
		return letter;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	@Override
	public String toString() {
		return "PuzzlePiece [letter=" + letter + ", row=" + row + ", col=" + col + ", color=" + color + "] ("
				+ color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ", " + color.getAlpha() + ")";
	}

}
