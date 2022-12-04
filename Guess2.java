import java.util.Scanner;
import java.util.Random;

/**
 * The Guess2 class is an application that uses a Random object to 
 * to play a number guessing game with one computer player and one
 * human player.
 *
 * Bugs: The old bugs have been fixed by we've introduced new one.
 * Can you find them?
 * //YOU WILL ONLY NEED TO MAKE MINOR CHANGES/ADDITIONS TO FIX THEM!
 * 
 * @author Eva Schiffer, copyright 2006, all rights reserved
 * @author Daniel Wong, modified 2008
 * @author Jim Skrentny, modified 2009-2011
 */

public class Guess2 {
	// YOU MAY ASSUME THE COMMENTS CORRECTLY DESCRIBE WHAT SHOULD HAPPEN.
		public static void main(String[] args) {
			
			//THESE DECLARATIONS ARE CORRECT.
			Random ranGen = new Random(8);	// seeded to make debugging easier
			final int sides = 6;			// number of sides for a die
			Scanner userInput = new Scanner(System.in);
			int userguess = -1;				// user's guess,  1 - 6 inclusive
			int rolled = -1;				// number rolled, 1 - 6 inclusive
			int computerPoints = 0;			// computer's score, 0 - 5 max
			int humanPoints = 0;			// human user's score, 0 - 5 max
			boolean rightGuess = false;		// flag for correct guess
			int numGuesses = 0;				// counts the number of guesses per round

			//MAKE SURE THE PROGRAM PLAYS BY THESE RULES!!!
			System.out.println("Welcome to the Guess Game!\n\n RULES:");
			System.out.println("1. We will play five rounds.");
			System.out.println("2. Each round you will guess the number rolled on a six-sided die.");
			System.out.println("3. If you guess the correct value in three or fewer tries\n" +
				"   then you score a point, otherwise I score a point.");
			System.out.println("4. Whoever has the most points after five rounds wins.");
			
			// play five rounds
			for (int r = 1; r <= 5; r++) {

				// roll the die to start the round
				System.out.println("\n\nROUND " + r);
				System.out.println("-------");
				rolled = ranGen.nextInt(sides+1);
				System.out.println("The computer has rolled the die.");
				System.out.println("You have three guesses.");

				// loop gives user up to three guesses
				rightGuess = false;
				while (numGuesses < 3 && !rightGuess) {
					numGuesses++;

					// input & validation: must be in range 1 to 6 inclusive
					do {
						System.out.print("\nWhat is your guess [1-6]? ");

						userguess = userInput.nextInt();

						if ((userguess < 1) && (userguess > 6)) {
							System.out.println("   Please enter a valid guess [1-6]!");
						}
					} while (userguess < 1 || userguess > 6); 

					// did the user guess right?
					if (rolled == userguess) {
						System.out.println("   Correct!");
						rightGuess=true;
					} else {
						System.out.println("   Incorrect guess.");
					}
					numGuesses++;
				}

				// if the user guessed right, they get a point
				// otherwise the computer gets a point
				if (!rightGuess) {
					computerPoints++;
				} else {
					humanPoints++;
				}

				// display the answer and scores
				System.out.println("\n*** The correct answer was: " + rolled + " ***\n");
				System.out.println("Scores:");
				System.out.println("  You: \t\t" + humanPoints);
				System.out.println("  Computer: \t" + computerPoints);
				System.out.println("");
			}

			// tell the user if they won or lost
			if (computerPoints > humanPoints) {
				System.out.println("*** You Lose! ***");
			} else {
				System.out.println("*** You Win! ***");
			}

			System.out.println("Thanks for playing the Guess Game!");
		} // end main
	

}// end class Guess
