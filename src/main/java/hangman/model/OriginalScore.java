package hangman.model;

import com.google.inject.Singleton;

import hangman.exceptions.*;

/**
 * Class with the original hangman score
 * @author Santiago Arevalo y Juan Sanchez
 *
 */
@Singleton
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
		if (correctCount < 0 || incorrectCount < 0) throw new ANegativeValue("A negative number can't be sent");
		int tempIncorrectCount = incorrectCount;
		while ( score >= 10  && tempIncorrectCount > 0) {
			score -= 10;
			tempIncorrectCount -= 1;
			
		}
		return score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void reset() {
		score = 100;
	}

}
