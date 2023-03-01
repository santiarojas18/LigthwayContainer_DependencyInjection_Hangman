package hangman.model;

import hangman.exceptions.ANegativeValue;
import hangman.exceptions.HangmanExceptions;

/**
 * Class with the hangman bonus score
 * @author Santiago Arevalo y Juan Sanchez
 *
 */
public class BonusScore implements GameScore {
	private int score;
	
	/**
	 * Constructor of BonusScore objects, with initial score of 0
	 */
	public BonusScore () {
		score = 0;
	}

	@Override
	/**
	 * Calculate the bonus score,  it means that it adds 10 points 
	 * each correct letter to the score, discount 5 point each wrong letter
	 * and 0 is the minimum score
	 * @Param correctCount is the amount of correct letters in current turn
	 * @Param intcorrectCount is the amount of incorrect letters in current turn
	 */
	public int calculateScore(int correctCount, int incorrectCount) throws HangmanExceptions {
		if (correctCount < 0 || incorrectCount < 0) throw new ANegativeValue("A negative number can't be sent");
		score += correctCount * 10;
		int tempIncorrectCount = incorrectCount;
		while ( score > 0  && tempIncorrectCount > 0) {
			if (score >= 5 ) {
				score -= 5;
			} else {
				score = 0;
			}
			tempIncorrectCount -= 1;
		}
		return score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void reset() {
		score = 0;
	}

}
