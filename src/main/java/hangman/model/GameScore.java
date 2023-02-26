package hangman.model;

import hangman.exceptions.*;

/**
 * GameScore is an interface that allows the Dependency Inversion about the way to calculate the current score
 * @author Santiago Arevalo y Juan Felipe Perez
 *
 */
public interface GameScore {
	/**
	 * Calculate the score in order of the correct and incorrect points
	 * @param correctCount is the amount of correct letters in current turn
	 * @param incorrectCount is the amount of incorrect letters in current turn
	 * @return
	 * @throws HangmanExceptions
	 * 
	 */
	public int calculateScore (int correctCount, int incorrectCount) throws HangmanExceptions;
}
