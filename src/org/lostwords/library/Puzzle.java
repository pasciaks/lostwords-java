package org.lostwords.library;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Puzzle {

	private int rows;
	private int cols;

	private char dash = '-';
	private char circle = '\u25CF';
	private char square = '\u25A0';

	private String thePuzzleAsAString = "";

	private int index = 0;

	final class MyRowColClass {
		private int row;
		private int col;

		MyRowColClass(int col, int row) {

			this.col = col;
			this.row = row;
		}

		@Override
		public String toString() {
			return " Row: " + row + ", Col: " + col + " ";
		}
	}

	public List<Map<Integer, PuzzlePiece>> wordPiecesListForPuzzle = new ArrayList<>();

	public Map<Integer, List<List<MyRowColClass>>> wordPathsByLength = new HashMap<>();

	PuzzleMatrix matrix = new PuzzleMatrix();

	public Puzzle(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		matrix = new PuzzleMatrix();
		createAndPopulateWordPaths();
	}

	public boolean testGetAndShowWordPathsByLength(int wordLength, String word, int sRow, int sCol) {
		return showWordPathsByLength(wordLength, word, sRow, sCol);
	}

	private boolean showWordPathsByLength(int wordLength, String word, int sRow, int sCol) {
		List<List<MyRowColClass>> wordPaths = getWordPathsByLength(wordLength);

		int countOfPossibleWordPaths = wordPaths.size();
		int randomPath = generateRandomInt(0, countOfPossibleWordPaths - 1);

		int currentCount = 0;
		for (List<MyRowColClass> list : wordPaths) {
			// System.out.println("List: " + list.size());
			if (currentCount == randomPath) {
				if (checkForWordHidePossibleInPath(sRow, sCol, word, list)) {
					hideWordInPath(sRow, sCol, word, list);
					for (MyRowColClass myRowCol : list) {
						// System.out.println(myRowCol);
					}
					return true;
				}
			}
			currentCount++;
		}
		return false;
	}

	private List<List<MyRowColClass>> getWordPathsByLength(int wordLength) {
		return wordPathsByLength.get(wordLength);
	}

	private void createAndPopulateWordPaths() {

		List<MyRowColClass> myRowColList = new ArrayList<>();

		for (int i = 1; i <= 17; i++) {
			wordPathsByLength.put(i, new ArrayList<List<MyRowColClass>>());
		}

		for (int j = 0; j <= 17; j++) {

			List<List<MyRowColClass>> gottenPaths = new ArrayList<>();

			List<String> lines = readFileIntoListOfStrings("_" + j + ".txt");

			gottenPaths = new ArrayList<>();

			for (String line : lines) {

				String[] parts = line.split("\\|");

				List<MyRowColClass> sublist = new ArrayList<>();

				for (String part : parts) {

					int p1 = Integer.parseInt(part.split(",")[0]);
					int p2 = Integer.parseInt(part.split(",")[1]);

					sublist.add(new MyRowColClass(p1, p2));
				}

				gottenPaths.add(sublist);

			}

			wordPathsByLength.put(j, gottenPaths);

			List<List<MyRowColClass>> myLists = wordPathsByLength.get(j);

		}

	}

	public List<Point> hideSnakeWord(String word, int maxBends) {

		List<Point> points = new ArrayList<>();

		int colD = Math.random() > 0.5 ? 1 : -1;
		int rowD = Math.random() > 0.5 ? 1 : -1;

		int currentColDirection = 1;
		int currentRowDirection = 1;

		int randomChoiceOfDirection = Math.random() > 0.5 ? 1 : 0;

		if (randomChoiceOfDirection == 0) {
			currentRowDirection = Math.random() > 0.5 ? 1 : -1;

			currentColDirection = 0;

		} else {
			currentColDirection = Math.random() > 0.5 ? 1 : -1;

			currentRowDirection = 0;

		}

		int startRow = Math.abs(generateRandomInt(0, rows - 1));
		int startCol = Math.abs(generateRandomInt(0, cols - 1));

		int currentRow = startRow;
		int currentCol = startCol;

		int currentBends = 0;

		for (int i = 0; i < word.length(); i++) {

			String currentLetter = "" + word.charAt(i);

			String nextLetter = "";

			for (Point point : points) {
				if (point.x == currentCol && point.y == currentRow) {
					return null;
				}
			}

			try {
				nextLetter = "" + matrix.get(currentRow, currentCol).letter;
				if (!nextLetter.equals(currentLetter) && !nextLetter.equals("" + getSquare())) {
					return null;
				}
			} catch (Exception e) {
				// System.out.println("Invalid row or column.");
				return null;
			}

			points.add(new Point(currentCol, currentRow));

			if (currentBends < maxBends) {

				boolean wasBended = false;

				if (Math.random() > .5) {

					if ((Math.random() > 0.5) && (currentBends < maxBends)) {
						currentColDirection = 1 * colD;
						currentRowDirection = 0;
						wasBended = true;
						rowD = -1 * rowD;
					} else {
						currentColDirection = 0;
						currentRowDirection = 1 * rowD;
						colD = -1 * colD;
					}
				} else {

					if ((Math.random() > 0.5) && (currentBends < maxBends)) {
						currentRowDirection = 1 * rowD;
						currentColDirection = 0;
						wasBended = true;
						colD = -1 * colD;
					} else {
						currentRowDirection = 0;
						currentColDirection = 1 * colD;
						rowD = -1 * rowD;
					}
				}
				if (wasBended) {
					currentBends++;
				}

			}

			currentRow += currentRowDirection;
			currentCol += currentColDirection;

		}

		for (int i = 0; i < points.size(); i++) {
			Point testPoint = points.get(i);
			// System.out.println("Point: " + testPoint);
			matrix.set(testPoint.y, testPoint.x, new PuzzlePiece(word.charAt(i), null, testPoint.y, testPoint.x));
		}

		return points;

	}

	public void fillPuzzle(char fillLetter) {
		PuzzlePiece piece;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (fillLetter == '-') {
					piece = new PuzzlePiece((char) generateRandomInt('A', 'Z'), null, i, j);
				} else {
					piece = new PuzzlePiece(fillLetter, null, i, j);
				}
				matrix.set(i, j, piece);
			}
		}
	}

	public static int generateRandomInt(int min, int max) {
		if (min > max) {
			max = min;
		}
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}

	public void printPuzzle() {
		for (int i = 0; i < rows; i++) {
			// System.out.println();
			for (int j = 0; j < cols; j++) {
				try {
					System.out.print(matrix.get(i, j).letter + " ");
				} catch (Exception e) {
					// System.out.println("Invalid row or column.");
				}
			}
			System.out.println();
		}

	}

	public String puzzleToString() {
		StringBuilder thePuzzleAsAString = new StringBuilder("");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				try {
					thePuzzleAsAString.append(matrix.get(i, j).letter);
				} catch (Exception e) {
					thePuzzleAsAString.append(dash);
				}
			}
		}
		this.thePuzzleAsAString = "" + thePuzzleAsAString.toString();
		return thePuzzleAsAString.toString();
	}

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

	private boolean checkForWordHidePossibleInPath(int startRow, int startCol, String word, List<MyRowColClass> path) {

		boolean hideOnlyInBlankSquares = false; // @TODO - implement in calling method

		int wordLength = word.length();
		if (wordLength != path.size()) {
			return false;
		}

		int currentRow = startRow;
		int currentCol = startCol;

		for (int i = 0; i < wordLength; i++) {
			currentRow += path.get(i).row; // 1st coordinate offsets are 0,0
			currentCol += path.get(i).col;
			try {

				if (!hideOnlyInBlankSquares) {
					// square or same letter
					if (matrix.get(currentRow, currentCol).letter != word.charAt(i)
							&& matrix.get(currentRow, currentCol).letter != square) {
						return false;
					}
				} else {
					// just square
					if (matrix.get(currentRow, currentCol).letter != square) {
						return false;
					}
				}
			} catch (Exception e) {
				return false;
			}

		}
		return true;
	}

	private boolean hideWordInPath(int startRow, int startCol, String word, List<MyRowColClass> path) {
		int wordLength = word.length();
		if (wordLength != path.size()) {
			return false;
		}

		int currentRow = startRow;
		int currentCol = startCol;

		for (int i = 0; i < wordLength; i++) {
			currentRow += path.get(i).row; // 1st coordinate offsets are 0,0
			currentCol += path.get(i).col;
			// System.out.println("Row: " + currentRow + ", Col: " + currentCol);
			// System.out.println(word.charAt(i));
			matrix.set(currentRow, currentCol, new PuzzlePiece(word.charAt(i), null, currentRow, currentCol));

		}
		return true;
	}

	private boolean checkForWord(String word, int startRow, int startCol, boolean isForward, boolean isBackward,
			boolean isHorizontal, boolean isVertical, boolean isDiagonal) {

		int wordLength = word.length();

		if (isHorizontal) {
			if (isForward) {
				for (int i = 0; i < wordLength; i++) {
					try {

						if (matrix.get(startRow, startCol + i).letter != word.charAt(i)
								&& matrix.get(startRow, startCol + i).letter != square) {
							return false;
						}
					} catch (Exception e) {
						return false;
					}
				}
			} else if (isBackward) {
				for (int i = 0; i < wordLength; i++) {
					try {

						if (matrix.get(startRow, startCol - i).letter != word.charAt(i)
								&& matrix.get(startRow, startCol - i).letter != square) {
							return false;
						}
					} catch (Exception e) {
						return false;
					}
				}
			}
		} else if (isVertical) {
			if (isForward) {
				for (int i = 0; i < wordLength; i++) {
					try {

						if (matrix.get(startRow + i, startCol).letter != word.charAt(i)
								&& matrix.get(startRow + i, startCol).letter != square) {
							return false;
						}
					} catch (Exception e) {
						return false;
					}
				}
			} else if (isBackward) {
				for (int i = 0; i < wordLength; i++) {
					try {
						if (matrix.get(startRow - i, startCol).letter != word.charAt(i)
								&& matrix.get(startRow - i, startCol).letter != square) {
							return false;
						}
					} catch (Exception e) {
						return false;
					}
				}
			}
		} else if (isDiagonal) {
			if (isForward) {
				for (int i = 0; i < wordLength; i++) {
					try {
						if (matrix.get(startRow + i, startCol + i).letter != word.charAt(i)
								&& matrix.get(startRow + i, startCol + i).letter != square) {
							return false;
						}
					} catch (Exception e) {
						return false;
					}
				}
			} else if (isBackward) {
				for (int i = 0; i < wordLength; i++) {
					try {

						if (matrix.get(startRow - i, startCol - i).letter != word.charAt(i)
								&& matrix.get(startRow - i, startCol - i).letter != square) {
							return false;
						}
					} catch (Exception e) {
						return false;
					}
				}
			}
		}

		return true;

	}

	private boolean makeDiagonalPuzzleWord(String word) {
		int wordLength = word.length();
		boolean isForward = generateRandomInt(0, 1) == 1;
		boolean isBackward = !isForward;
		int startRow = 0;
		int startCol = 0;

		boolean wasWordPlaced = false;
		if (isForward) {
			startRow = generateRandomInt(0, rows - wordLength);
			startCol = generateRandomInt(0, cols - wordLength);
			if (checkForWord(word, startRow, startCol, isForward, isBackward, false, false, true)) {
				for (int i = 0; i < wordLength; i++) {
					setLetter(startRow + i, startCol + i, word.charAt(i));
				}
				wasWordPlaced = true;
				storePuzzleWord(word, startRow, startCol, isForward, isBackward, false, false, true);
			}

		} else if (isBackward) {
			startRow = generateRandomInt(wordLength - 1, rows - 1);
			startCol = generateRandomInt(wordLength - 1, cols - 1);
			if (checkForWord(word, startRow, startCol, isForward, isBackward, false, false, true)) {
				for (int i = 0; i < wordLength; i++) {
					setLetter(startRow - i, startCol - i, word.charAt(i));
				}
				wasWordPlaced = true;
				storePuzzleWord(word, startRow, startCol, isForward, isBackward, false, false, true);
			}

		}

		return wasWordPlaced;

	}

	private Map<Integer, PuzzlePiece> storePuzzleWord(String word, int startRow, int startCol, boolean isForward,
			boolean isBackward, boolean isHorizontal, boolean isVertical, boolean isDiagonal) {

		int wordLength = word.length();
		Map<Integer, PuzzlePiece> wordPieces = new HashMap<Integer, PuzzlePiece>();
		if (isHorizontal) {
			if (isForward) {
				for (int i = 0; i < wordLength; i++) {
					wordPieces.put(i, matrix.get(startRow, startCol + i));
				}
			} else if (isBackward) {
				for (int i = 0; i < wordLength; i++) {
					wordPieces.put(i, matrix.get(startRow, startCol - i));
				}
			}
		} else if (isVertical) {
			if (isForward) {
				for (int i = 0; i < wordLength; i++) {
					wordPieces.put(i, matrix.get(startRow + i, startCol));
				}
			} else if (isBackward) {
				for (int i = 0; i < wordLength; i++) {
					wordPieces.put(i, matrix.get(startRow - i, startCol));
				}
			}
		} else if (isDiagonal) {
			if (isForward) {
				for (int i = 0; i < wordLength; i++) {
					wordPieces.put(i, matrix.get(startRow + i, startCol + i));
				}
			} else if (isBackward) {
				for (int i = 0; i < wordLength; i++) {
					wordPieces.put(i, matrix.get(startRow - i, startCol - i));
				}
			}
		}

		for (int i = 0; i < wordLength; i++) {
			PuzzlePiece testPuzzlePiece = wordPieces.get(i);
			String myPieceDetails = testPuzzlePiece.toString();
			// System.out.println(myPieceDetails);
		}

		storeHashMapOfWordPiecesInList(wordPieces);

		return wordPieces;

	}

	private void storeHashMapOfWordPiecesInList(Map<Integer, PuzzlePiece> wordPieces) {

		List<Map<Integer, PuzzlePiece>> wordPiecesList = new ArrayList<>();
		wordPiecesList.add(wordPieces);

		wordPiecesListForPuzzle.add(index++, wordPieces);

		for (int i = 0; i < wordPiecesList.size(); i++) {
			Map<Integer, PuzzlePiece> testWordPieces = wordPiecesList.get(i);
			// System.out.println("WordPiecesList: " + testWordPieces);
			for (int j = 0; j < testWordPieces.size(); j++) {
				PuzzlePiece testPuzzlePiece = testWordPieces.get(j);
				// System.out.println(testPuzzlePiece.toString());
			}
		}

	}

	public void displayAllWordPieces() {
		for (int i = 0; i < wordPiecesListForPuzzle.size(); i++) {
			Map<Integer, PuzzlePiece> testWordPieces = wordPiecesListForPuzzle.get(i);
			// System.out.println("WordPiecesList: " + testWordPieces);
		}
		// System.out.println("Number of words: " + wordPiecesListForPuzzle.size());
	}

	public void fillPuzzleBlocks(char prev, char newLetter) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				try {
					if (matrix.get(i, j).letter == prev) {
						setLetter(i, j, newLetter);
					}
				} catch (Exception e) {
					// System.out.println("Invalid row or column.");
				}
			}
		}
	}

	public void fillPuzzleBlocks(char prev, String randomCharFromString) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				try {
					if (matrix.get(i, j).letter == prev) {
						if (randomCharFromString != null) {
							setLetter(i, j, randomCharFromString
									.charAt(generateRandomInt(0, randomCharFromString.length() - 1)));
						} else {
							setLetter(i, j, prev);
						}
					}
				} catch (Exception e) {
					// System.out.println("Invalid row or column.");
				}
			}
		}
	}

	private void displayLastWordPieces() {
		Map<Integer, PuzzlePiece> testWordPieces = wordPiecesListForPuzzle.get(index - 1);
		System.out.println("WordPiecesList: " + testWordPieces);
	}

	public boolean makePuzzleWord(String word) { // NOTE: This does not include diagonal words

		boolean wasWordPlaced = false;

		int wordLength = word.length();
		boolean isHorizontal = generateRandomInt(0, 1) == 1;
		boolean isVertical = !isHorizontal;
		boolean isForward = generateRandomInt(0, 1) == 1;
		boolean isBackward = !isForward;

		int startRow = 0;
		int startCol = 0;

		if (isHorizontal) {
			if (isForward) {
				startRow = generateRandomInt(0, rows - 1);
				startCol = generateRandomInt(0, cols - wordLength);
			} else if (isBackward) {
				startRow = generateRandomInt(0, rows - 1);
				startCol = generateRandomInt(wordLength - 1, cols - 1);
			}
		} else if (isVertical) {
			if (isForward) {
				startRow = generateRandomInt(0, rows - wordLength);
				startCol = generateRandomInt(0, cols - 1);
			} else if (isBackward) {
				startRow = generateRandomInt(wordLength - 1, rows - 1);
				startCol = generateRandomInt(0, cols - 1);
			}
		}

		if (isHorizontal) {
			if (isForward) {
				if (checkForWord(word, startRow, startCol, isForward, isBackward, true, false, false)) {
					for (int i = 0; i < wordLength; i++) {
						setLetter(startRow, startCol + i, word.charAt(i));
					}
					wasWordPlaced = true;
					storePuzzleWord(word, startRow, startCol, isForward, isBackward, true, false, false);
				}

			} else if (isBackward) {
				if (checkForWord(word, startRow, startCol, isForward, isBackward, true, false, false)) {
					for (int i = 0; i < wordLength; i++) {
						setLetter(startRow, startCol - i, word.charAt(i));
					}
					wasWordPlaced = true;
					storePuzzleWord(word, startRow, startCol, isForward, isBackward, true, false, false);
				}

			}
		} else if (isVertical) {
			if (isForward) {
				if (checkForWord(word, startRow, startCol, isForward, isBackward, false, true, false)) {
					for (int i = 0; i < wordLength; i++) {
						setLetter(startRow + i, startCol, word.charAt(i));
					}
					wasWordPlaced = true;
					storePuzzleWord(word, startRow, startCol, isForward, isBackward, false, true, false);
				}

			} else if (isBackward) {
				if (checkForWord(word, startRow, startCol, isForward, isBackward, false, true, false)) {
					for (int i = 0; i < wordLength; i++) {
						setLetter(startRow - i, startCol, word.charAt(i));
					}
					wasWordPlaced = true;
					storePuzzleWord(word, startRow, startCol, isForward, isBackward, false, true, false);
				}

			}
		}

		return wasWordPlaced;

	}

	public void printPuzzleData() {
		for (int i = 0; i < rows; i++) {
			System.out.println();
			for (int j = 0; j < cols; j++) {
				PuzzlePiece testPuzzlePiece = matrix.get(i, j);
				String myPieceDetails = testPuzzlePiece.toString();
				System.out.println(myPieceDetails);
			}
		}
	}

	private boolean setLetter(int row, int col, char letter) {
		try {
			matrix.get(row, col).setLetter(letter);
			return true;
		} catch (Exception e) {
			System.out.println("Invalid row or col");
		}
		return false;
	}

	public boolean tryToPlaceWordRectangular(Puzzle myPuzzle, String word, int tries) {
		boolean wasWordPlaced = false;
		int attempts = 0;
		do {
			wasWordPlaced = myPuzzle.makePuzzleWord(word);
			attempts++;
		} while (attempts < tries && wasWordPlaced == false);

		return wasWordPlaced;
	}

	public boolean tryToPlaceWordDiagonal(Puzzle myPuzzle, String word, int tries) {
		boolean wasWordPlaced = false;
		int attempts = 0;
		do {
			wasWordPlaced = myPuzzle.makeDiagonalPuzzleWord(word);
			attempts++;
		} while (attempts < tries && wasWordPlaced == false);

		return wasWordPlaced;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Puzzle [rows=");
		builder.append(rows);
		builder.append(", cols=");
		builder.append(cols);
		builder.append(", thePuzzleAsAString=");
		builder.append(thePuzzleAsAString);
		builder.append(", wordPiecesListForPuzzle=");
		builder.append(wordPiecesListForPuzzle);
		builder.append("]");
		return builder.toString();
	}

	public void adjustPuzzleUsableArea(int numRows, int numCols, Puzzle myPuzzle, int distanceMax) {
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				int x = numCols / 2;
				int y = numRows / 2;
				double distance = Math.sqrt((x - i) * (x - i) + (y - j) * (y - j));
				if (distance < (numCols / 2) - 2) {
					if (distance > distanceMax) {
						myPuzzle.setLetter(i, j, ' ');
					}
				}

			}
		}
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public char getDash() {
		return dash;
	}

	public void setDash(char dash) {
		this.dash = dash;
	}

	public char getCircle() {
		return circle;
	}

	public void setCircle(char circle) {
		this.circle = circle;
	}

	public char getSquare() {
		return square;
	}

	public void setSquare(char square) {
		this.square = square;
	}

}
