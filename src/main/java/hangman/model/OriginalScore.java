package hangman.model;

import hangman.exceptions.*;

/**
 * Class with the original hangman score
 * @author Santiago Arevalo y Juan Sanchez
 *
 */
public class OriginalScore implements GameScore {
	private int score;
	
	/**
	 * Constructor of OriginalScore objects, with initial score of 100
	 */
	public OriginalScore () {
		score = 100;
	}
	
	@Override
	/**
	 * Calculate the original score, it means that discount 10 points each wrong letter
	 * and the minimum score is 0
	 * @Param correctCount is the amount of correct letters in current turn
	 * @Param intcorrectCount is the amount of incorrect letters in current turn
	 * @throws HangmanExceptions
	 */
	public int calculateScore(int correctCount, int incorrectCount) throws HangmanExceptions {
		
		
		return score;
	}

}
