//Author: Joseph Nielson
//Date: 2016-11-21
//Purpose: Creates a number guessing game in which the user guesses a number until the user guesses the correct number. 
//Provides feedback if the user's number is too high or too low.

import java.util.Scanner;

public class NumberGuessing 
{
	public static Scanner in;
	
	public static void main(String[] args)
	{
		//Instatiate Scanner
		Scanner in = new Scanner(System.in);
		
		//Greets the user and asks for a confirmation to play the game.
		int playing = 1; //Is 1 while the user is playing
		System.out.print("Welcome to the number guessing game! \nWould you like to play? Enter 1 for yes or 2 to quit. >>>");
		playing = in.nextInt();
		
		//Repeats while playing
		while (playing == 1)
		{
			//Generates a random number between 1 and 100, inclusive.
			int correctNumber = (int)(1 + 100 * Math.random());
			System.out.println("I'm thinking of a number between 1 and 100, inclusive.");
			
			//Defines more variables
			int guessedNumber = 0; //Entered by the user in each guess
			int numberOfGuesses = 0;
			
			//Repeats for each guess. Ends when the user guesses correctly.
			while (correctNumber != guessedNumber)
			{
				//Inputs guess from user.
				System.out.print("What number do you guess? >>>");
				guessedNumber = in.nextInt();
				
				//Keeps track of the number of guesses
				numberOfGuesses++;
				
				//Gives feedback if the user's guess is too high or too low.
				if (guessedNumber > correctNumber)
				{
					System.out.println("That number is too high.");
				}
				else if (guessedNumber < correctNumber)
				{
					System.out.println("That number is too low.");
				}
				else
				{
					break;
				}
			}//End Repeats for each guess
			
			//Once the correct number is guessed, tell the user and report the number of guesses
			System.out.println("That is correct! You made " + numberOfGuesses + " guesses.");
			
			//Ask the user to quit or play again
			System.out.print("Would you like to play again? Enter 1 for yes or 2 to quit. >>>");
			playing = in.nextInt();
			
		}//End Repeats while playing
		
		//Thank the user for playing.
		System.out.println("Thanks for playing the number guessing game!");
		
	}//End main

}//End NumberGuessing
