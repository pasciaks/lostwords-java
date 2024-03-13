

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

		PuzzleRunnerConsoleApp app = new PuzzleRunnerConsoleApp();

		Puzzle myPuzzle = new Puzzle(12, 12);

		myPuzzle.fillPuzzle(myPuzzle.getSquare());

		myPuzzle.tryToPlaceWordDiagonal(myPuzzle, "SHELDON", 99999);

		myPuzzle.tryToPlaceWordRectangular(myPuzzle, "PASCIAK", 99999);

		boolean hiddenResult = false;

		int hiddenCount = 0;

		String sentence = "Code is like humor When you have to explain it it is bad Cory House";

		String[] words = sentence.split(" ");
		for (String word : words) {
			hiddenResult = app.hideAWord(myPuzzle, word);
			if (hiddenResult) {
				hiddenCount++;
			}
		}

		System.out.println("Words hidden using stored paths algorithm: " + hiddenCount + "\n");

		myPuzzle.printPuzzle();

		System.out.println("\nAll words hidden: " + hiddenCount + "\n");

		myPuzzle.displayAllWordPieces();

```

```
Words hidden using stored paths algorithm: 15

■ s n e ■ ■ ■ ■ ■ ■ ■ ■ 
■ i ■ h ■ ■ l i h ■ ■ ■ 
■ ■ N W ■ ■ ■ k a v P ■ 
■ ■ ■ O ■ y r e ■ e A ■ 
■ ■ ■ ■ D ■ o C ■ ■ S t 
■ ■ ■ ■ ■ L ■ ■ ■ ■ C o 
b a ■ ■ ■ ■ E ■ ■ ■ I ■ 
■ d d o o u ■ H ■ ■ A ■ 
i t e C y H o u S i K ■ 
■ ■ r ■ ■ ■ ■ s ■ s i n 
■ t o ■ ■ ■ ■ e ■ l a ■ 
■ i m u h ■ ■ ■ ■ p x e 

All words hidden: 15

WordPiecesList: {0=PuzzlePiece [letter=S, row=8, col=8, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=H, row=7, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=E, row=6, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=L, row=5, col=5, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 4=PuzzlePiece [letter=D, row=4, col=4, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 5=PuzzlePiece [letter=O, row=3, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 6=PuzzlePiece [letter=N, row=2, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=S, row=8, col=8, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=H, row=7, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=E, row=6, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=L, row=5, col=5, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=D, row=4, col=4, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=O, row=3, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=N, row=2, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)

WordPiecesList: {0=PuzzlePiece [letter=P, row=2, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=A, row=3, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=S, row=4, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=C, row=5, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 4=PuzzlePiece [letter=I, row=6, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 5=PuzzlePiece [letter=A, row=7, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 6=PuzzlePiece [letter=K, row=8, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=P, row=2, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=A, row=3, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=S, row=4, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=C, row=5, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=I, row=6, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=A, row=7, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=K, row=8, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)

WordPiecesList: {0=PuzzlePiece [letter=C, row=8, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=o, row=7, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=d, row=7, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=e, row=8, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=C, row=8, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=o, row=7, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=d, row=7, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=e, row=8, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)

WordPiecesList: {0=PuzzlePiece [letter=i, row=1, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=s, row=0, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=i, row=1, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=s, row=0, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)

WordPiecesList: {0=PuzzlePiece [letter=l, row=1, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=i, row=1, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=k, row=2, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=e, row=3, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=l, row=1, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=i, row=1, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=k, row=2, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=e, row=3, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)

WordPiecesList: {0=PuzzlePiece [letter=h, row=11, col=4, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=u, row=11, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=m, row=11, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=o, row=10, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 4=PuzzlePiece [letter=r, row=9, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=h, row=11, col=4, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=u, row=11, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=m, row=11, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=o, row=10, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=r, row=9, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)

WordPiecesList: {0=PuzzlePiece [letter=W, row=2, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=h, row=1, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=e, row=0, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=n, row=0, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=W, row=2, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=h, row=1, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=e, row=0, col=3, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=n, row=0, col=2, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)

WordPiecesList: {0=PuzzlePiece [letter=y, row=8, col=4, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=o, row=7, col=4, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=u, row=7, col=5, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=y, row=8, col=4, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=o, row=7, col=4, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=u, row=7, col=5, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)

WordPiecesList: {0=PuzzlePiece [letter=h, row=1, col=8, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=a, row=2, col=8, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=v, row=2, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=e, row=3, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=h, row=1, col=8, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=a, row=2, col=8, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=v, row=2, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=e, row=3, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)

WordPiecesList: {0=PuzzlePiece [letter=t, row=4, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=o, row=5, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=t, row=4, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=o, row=5, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)

WordPiecesList: {0=PuzzlePiece [letter=e, row=11, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=x, row=11, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=p, row=11, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=l, row=10, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 4=PuzzlePiece [letter=a, row=10, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 5=PuzzlePiece [letter=i, row=9, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 6=PuzzlePiece [letter=n, row=9, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=e, row=11, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=x, row=11, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=p, row=11, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=l, row=10, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=a, row=10, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=i, row=9, col=10, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=n, row=9, col=11, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)

WordPiecesList: {0=PuzzlePiece [letter=i, row=11, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=t, row=10, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=i, row=11, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=t, row=10, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)

WordPiecesList: {0=PuzzlePiece [letter=i, row=8, col=0, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=t, row=8, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=i, row=8, col=0, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=t, row=8, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)

WordPiecesList: {0=PuzzlePiece [letter=i, row=8, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=s, row=9, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=i, row=8, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=s, row=9, col=9, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)

WordPiecesList: {0=PuzzlePiece [letter=b, row=6, col=0, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=a, row=6, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=d, row=7, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=b, row=6, col=0, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=a, row=6, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=d, row=7, col=1, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)

WordPiecesList: {0=PuzzlePiece [letter=C, row=4, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=o, row=4, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=r, row=3, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=y, row=3, col=5, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=C, row=4, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=o, row=4, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=r, row=3, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=y, row=3, col=5, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)

WordPiecesList: {0=PuzzlePiece [letter=H, row=8, col=5, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 1=PuzzlePiece [letter=o, row=8, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 2=PuzzlePiece [letter=u, row=8, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 3=PuzzlePiece [letter=s, row=9, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255), 4=PuzzlePiece [letter=e, row=10, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)}
PuzzlePiece [letter=H, row=8, col=5, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=o, row=8, col=6, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=u, row=8, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=s, row=9, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)
PuzzlePiece [letter=e, row=10, col=7, color=java.awt.Color[r=255,g=255,b=255]] (255, 255, 255, 255)

Number of words: 17

```


