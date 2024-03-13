package org.lostwords.library.app;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lostwords.library.FileHandling;
import org.lostwords.library.Puzzle;

public class PuzzleRunnerConsoleApp {

	public static void main(String[] args) {

		PuzzleRunnerConsoleApp app = new PuzzleRunnerConsoleApp();

		Puzzle myPuzzle = new Puzzle(12, 12);

		myPuzzle.fillPuzzle(myPuzzle.getSquare());

		boolean hiddenResult = false;
		int hiddenCount = 0;

		String sentence = "NOW IS THE TIME FOR ALL GOOD MEN TO LEARN HOW TO CODE IN JAVA";

		String[] words = sentence.split(" ");
		for (String word : words) {
			hiddenResult = app.hideAWord(myPuzzle, word);
			if (hiddenResult) {
				hiddenCount++;
			}
		}

//		for (int i = 0; i < 19; i++) {

//		hiddenResult = app.hideAWord(myPuzzle, "MICHAEL");
//		if (hiddenResult) {
//			hiddenCount++;
//		}
//		hiddenResult = app.hideAWord(myPuzzle, "ACE");
//		if (hiddenResult) {
//			hiddenCount++;
//		}
//		hiddenResult = app.hideAWord(myPuzzle, "SHELDON");
//		if (hiddenResult) {
//			hiddenCount++;
//		}
//		hiddenResult = app.hideAWord(myPuzzle, "MARY");
//		if (hiddenResult) {
//			hiddenCount++;
//		}
//		hiddenResult = app.hideAWord(myPuzzle, "BRYAN");
//		if (hiddenResult) {
//			hiddenCount++;
//		}
//		hiddenResult = app.hideAWord(myPuzzle, "ASHLEY");
//		if (hiddenResult) {
//			hiddenCount++;

//		}

		// System.out.println("Words hidden: " + hiddenCount);

		myPuzzle.printPuzzle();

		// app.run();

		// System.out.println("-----------------------");

		// app.minimalExample();

		// System.out.println("-----------------------");

		// app.hideSnakeWordExample();
	}

	private boolean hideAWord(Puzzle myPuzzle, String theWord) {

		int theLength = theWord.length();
		int puzzleRows = myPuzzle.getRows();
		int puzzleCols = myPuzzle.getCols();
		int sRow = (int) Math.floor(puzzleRows / 2);
		int sCol = (int) Math.floor(puzzleCols / 2);

		boolean wasHidden = false;
		int maxTries = 9999;
		int currentTries = 0;
		do {
			currentTries++;
			sRow = (int) Math.floor(puzzleRows * Math.random());
			sCol = (int) Math.floor(puzzleCols * Math.random());

			wasHidden = myPuzzle.testGetAndShowWordPathsByLength(theLength, theWord, sRow, sCol);

		} while (wasHidden == false && currentTries < maxTries);
		return wasHidden;
	}

	private void hideSnakeWordExample() {

		Puzzle myPuzzle = new Puzzle(15, 15);

		myPuzzle.fillPuzzle(myPuzzle.getSquare());

		// myPuzzle.fillPuzzleBlocks(myPuzzle.getSquare(), "1234");

		for (int i = 0; i < 99999; i++) {
			List<Point> result = myPuzzle.hideSnakeWord("JOSEPH", 5);
			if (result != null) {
				// System.out.println("Word placed.");
				break;
			}
		}

		myPuzzle.tryToPlaceWordDiagonal(myPuzzle, "SHELDON", 99999);

		myPuzzle.tryToPlaceWordRectangular(myPuzzle, "ALICIA", 999);

		myPuzzle.fillPuzzleBlocks('■', "-");

		myPuzzle.printPuzzle();

	}

	private void minimalExample() {

		int numRows = 12;
		int numCols = 12;

		boolean successfullyPlaced = false;

		Puzzle myPuzzle = new Puzzle(numRows, numCols);

		myPuzzle.fillPuzzle(myPuzzle.getSquare());

		myPuzzle.printPuzzle();

		successfullyPlaced = myPuzzle.tryToPlaceWordDiagonal(myPuzzle, "SHELDON", 99999);

		if (successfullyPlaced) {
			System.out.println("Word placed: SHELDON");
		} else {
			System.out.println("Word NOT placed: SHELDON");
		}

		successfullyPlaced = myPuzzle.tryToPlaceWordRectangular(myPuzzle, "ALICIA", 999);

		if (successfullyPlaced) {
			System.out.println("Word placed: ALICIA");
		} else {
			System.out.println("Word NOT placed: ALICIA");
		}

		myPuzzle.fillPuzzleBlocks('■', "-");

		System.out.println();

		myPuzzle.printPuzzle();

	}

	private void run() {

		Random rand = new Random();

		// String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		List<String> wordList = new ArrayList<>();

		wordList = FileHandling.readFileIntoListOfStrings("/usr/share/dict/words");

		if (wordList == null || wordList.size() == 0 || wordList.isEmpty()) {
			System.out.println("Word list is null, 0, or empty! Exiting.");
			return;
		}

		String[] words = new String[10];

		int minLen = 3;
		int maxLen = 12;

		for (int ii = 0; ii < 10; ii++) {
			boolean wasFound = false;
			do {
				int randIndex = rand.nextInt(wordList.size());
				if (wordList.get(randIndex).length() >= minLen && wordList.get(randIndex).length() <= maxLen) {
					words[ii] = wordList.get(randIndex).toUpperCase();
					wasFound = true;
				}
			} while (!wasFound);

		}

		int numRows = 12;
		int numCols = 12;

		Puzzle myPuzzle = new Puzzle(numRows, numCols);

		myPuzzle.printPuzzle();

		System.out.println();

		myPuzzle.fillPuzzle(myPuzzle.getSquare());

		System.out.println();

		myPuzzle.printPuzzle();

		System.out.println();

		adjustPuzzleUsableArea(numRows, numCols, myPuzzle, 2);

		myPuzzle.printPuzzle();

		System.out.println();

		boolean wasWordPlaced = false;

		int howManyPlaced = 0;

		int cycles = 0;

		int overallPlaced = 0;

		cycles = 0;

		howManyPlaced = 0;

		for (int i = 0; i < words.length; i++) {
			do {
				boolean successfullyPlaced = false;

				if (Math.random() < 0.5) {
					successfullyPlaced = myPuzzle.tryToPlaceWordDiagonal(myPuzzle, words[i], 1);
				} else {
					successfullyPlaced = myPuzzle.tryToPlaceWordRectangular(myPuzzle, words[i], 1);
				}

				if (successfullyPlaced) {
					howManyPlaced++;
					overallPlaced++;
					cycles = 0;
					break;
				}
				cycles++;
			} while (howManyPlaced < words.length && cycles < 999999);
		}

		myPuzzle.printPuzzle();

		String puzzleString = myPuzzle.puzzleToString();

		myPuzzle.fillPuzzleBlocks('■', "1234567890");

		myPuzzle.fillPuzzleBlocks('0', "abcdefghijklmnopqrstuvwxyz");

		puzzleString = myPuzzle.puzzleToString();

		myPuzzle.wordPiecesListForPuzzle.forEach((wordPieces) -> { // NOTE: This is a not so FAT arrow !?
			// System.out.println("WordPiecesList: " + wordPieces);
			// System.out.println("WordPiecesList: " +
			// myPuzzle.wordPiecesListForPuzzle.indexOf(wordPieces));
			wordPieces.forEach((key, value) -> {
				// System.out.print(value.letter);
			});
			// System.out.println();
		});

		// TODO: no duplicate word piece lists exist in the list of word pieces

		// TODO: no word pieces overlap from the wordPiecesListForPuzzle storage

		// TODO: filter out any duplicate word pieces

		// System.out.println(myPuzzle.toString().length());

		if (myPuzzle.toString().length() > 50000) {
			System.out.println("********");
			System.out.println(myPuzzle.getRows());
			System.out.println(myPuzzle.getCols());

		}
		System.out.println("");
		myPuzzle.printPuzzle();
		System.out.println("");
		System.out.println("Number of words placed: " + overallPlaced + " of possible " + words.length);
		System.out.println("");
	}

	private void adjustPuzzleUsableArea(int numRows, int numCols, Puzzle myPuzzle, int i) {

	}

}
