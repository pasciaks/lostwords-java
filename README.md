

#### lostwords.org - (lostwords-java) 

Written by Sheldon Pasciak, March 2024

[Lostwords.org](http://lostwords.org)

Go make your mark on the world, one word at a time.

<hr>



This is a work in progress while I put forth the effort to learn and use JAVA in my full stack web development career.

There's a lot to stay about this project, as well as the word journey as a whole, but for now let's just get to the bare-bones of it all.

This is a set of JAVA Class files that can be used to generate a rectangular word search.

Mostly randomized word hiding algorithms are implemented to hide words.

More work to re factor, re name and document this code and it's use is still needed.  This project is being written simultaneously while attending Skill Distillery JAVA Full Stack bootcamp.



```JAVA

// JAVA

		Puzzle myPuzzle = new Puzzle(12, 12);

		myPuzzle.fillPuzzle(myPuzzle.getSquare());

		// @TODO - clean up use, why does myPuzzle have to pass itself to the method?

		myPuzzle.tryToPlaceWordDiagonal(myPuzzle, "SHELDON", 99999);

		myPuzzle.tryToPlaceWordRectangular(myPuzzle, "PASCIAK", 99999);

		String sentence = "Code is like humor when you have to explain it it is bad Cory House";

		String[] words = sentence.split(" ");

		for (String theWord : words) {
			// @TODO - clean up code, put all behavior in the myPuzzle object
			// @TODO - replace unneeded app.hideAWord(myPuzzle, word);

			int theLength = theWord.length();
			int puzzleRows = myPuzzle.getRows();
			int puzzleCols = myPuzzle.getCols();

			int sRow = (int) Math.floor(puzzleRows / 2);
			int sCol = (int) Math.floor(puzzleCols / 2);

			boolean wasHidden = false;

			int maxTries = 99999;
			int currentTries = 0;

			do {
				currentTries++;
				sRow = (int) Math.floor(puzzleRows * Math.random());
				sCol = (int) Math.floor(puzzleCols * Math.random());
				// @TODO - modify method naming and use
				wasHidden = myPuzzle.testGetAndShowWordPathsByLength(theLength, theWord, sRow, sCol);
			} while (wasHidden == false && currentTries < maxTries);
		}

		myPuzzle.printPuzzle();

		myPuzzle.displayAllWordPieces();

```

```

■ ■ N ■ ■ ■ ■ ■ ■ ■ ■ ■ 
■ ■ ■ O ■ ■ w h ■ ■ y P 
o ■ ■ ■ D ■ ■ e a h r A 
t i s u ■ L ■ n v e o S 
■ s e o ■ ■ E ■ ■ ■ C C 
■ ■ ■ H ■ ■ ■ H ■ ■ ■ I 
■ ■ y o ■ ■ ■ r S ■ ■ A 
■ b a u ■ ■ h o ■ ■ ■ K 
■ ■ d ■ ■ ■ u m n ■ e x 
■ ■ i s o d e e i a l p 
■ ■ ■ ■ C ■ ■ k ■ ■ ■ ■ 
■ ■ i t ■ ■ l i ■ i t ■ 
WordPiecesList: {0=PuzzlePiece [letter=S, row=6, col=8, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=H, row=5, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=E, row=4, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=L, row=3, col=5, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 4=PuzzlePiece [letter=D, row=2, col=4, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 5=PuzzlePiece [letter=O, row=1, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 6=PuzzlePiece [letter=N, row=0, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=S, row=6, col=8, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=H, row=5, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=E, row=4, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=L, row=3, col=5, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=D, row=2, col=4, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=O, row=1, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=N, row=0, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
WordPiecesList: {0=PuzzlePiece [letter=P, row=1, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=A, row=2, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=S, row=3, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=C, row=4, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 4=PuzzlePiece [letter=I, row=5, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 5=PuzzlePiece [letter=A, row=6, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 6=PuzzlePiece [letter=K, row=7, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=P, row=1, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=A, row=2, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=S, row=3, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=C, row=4, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=I, row=5, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=A, row=6, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=K, row=7, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
WordPiecesList: {0=PuzzlePiece [letter=C, row=10, col=4, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=o, row=9, col=4, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=d, row=9, col=5, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=e, row=9, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=C, row=10, col=4, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=o, row=9, col=4, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=d, row=9, col=5, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=e, row=9, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
WordPiecesList: {0=PuzzlePiece [letter=i, row=9, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=s, row=9, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=i, row=9, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=s, row=9, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
WordPiecesList: {0=PuzzlePiece [letter=l, row=11, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=i, row=11, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=k, row=10, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=e, row=9, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=l, row=11, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=i, row=11, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=k, row=10, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=e, row=9, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
WordPiecesList: {0=PuzzlePiece [letter=h, row=7, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=u, row=8, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=m, row=8, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=o, row=7, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 4=PuzzlePiece [letter=r, row=6, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=h, row=7, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=u, row=8, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=m, row=8, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=o, row=7, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=r, row=6, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
WordPiecesList: {0=PuzzlePiece [letter=w, row=1, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=h, row=1, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=e, row=2, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=n, row=3, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=w, row=1, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=h, row=1, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=e, row=2, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=n, row=3, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
WordPiecesList: {0=PuzzlePiece [letter=y, row=6, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=o, row=6, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=u, row=7, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=y, row=6, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=o, row=6, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=u, row=7, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
WordPiecesList: {0=PuzzlePiece [letter=h, row=2, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=a, row=2, col=8, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=v, row=3, col=8, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=e, row=3, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=h, row=2, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=a, row=2, col=8, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=v, row=3, col=8, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=e, row=3, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
WordPiecesList: {0=PuzzlePiece [letter=t, row=3, col=0, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=o, row=2, col=0, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=t, row=3, col=0, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=o, row=2, col=0, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
WordPiecesList: {0=PuzzlePiece [letter=e, row=8, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=x, row=8, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=p, row=9, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=l, row=9, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 4=PuzzlePiece [letter=a, row=9, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 5=PuzzlePiece [letter=i, row=9, col=8, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 6=PuzzlePiece [letter=n, row=8, col=8, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=e, row=8, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=x, row=8, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=p, row=9, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=l, row=9, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=a, row=9, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=i, row=9, col=8, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=n, row=8, col=8, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
WordPiecesList: {0=PuzzlePiece [letter=i, row=11, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=t, row=11, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=i, row=11, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=t, row=11, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
WordPiecesList: {0=PuzzlePiece [letter=i, row=11, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=t, row=11, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=i, row=11, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=t, row=11, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
WordPiecesList: {0=PuzzlePiece [letter=i, row=3, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=s, row=4, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=i, row=3, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=s, row=4, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
WordPiecesList: {0=PuzzlePiece [letter=b, row=7, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=a, row=7, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=d, row=8, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=b, row=7, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=a, row=7, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=d, row=8, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
WordPiecesList: {0=PuzzlePiece [letter=C, row=4, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=o, row=3, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=r, row=2, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=y, row=1, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=C, row=4, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=o, row=3, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=r, row=2, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=y, row=1, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
WordPiecesList: {0=PuzzlePiece [letter=H, row=5, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=o, row=4, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=u, row=3, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=s, row=3, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 4=PuzzlePiece [letter=e, row=4, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=H, row=5, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=o, row=4, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=u, row=3, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=s, row=3, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=e, row=4, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
Number of words: 17

```


