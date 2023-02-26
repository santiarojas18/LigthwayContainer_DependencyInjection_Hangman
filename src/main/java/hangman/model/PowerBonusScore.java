package hangman.model;

import hangman.exceptions.HangmanExceptions;

/**
 * Class with the hangman power bonus score
 * @author Santiago Arevalo y Juan Sanchez
 *
 */
public class PowerBonusScore implements GameScore {
	private int score;
	
	/**
	 * Constructor of PowerBonusScore objects, with initial score of 0
	 */
	public PowerBonusScore () {
		score = 0;
	}
	
	
	@Override
	/**
	 * Calculate the power bonus score, it means that adds 5^i points each i-th 
	 * letter to the score, discount 8 points each wrong letter
	 * and 0 is the minimum score, also when the score is greater than 500 points, 
	 * the final score will be 500
	 * @Param correctCount is the amount of correct letters in current turn
	 * @Param intcorrectCount is the amount of incorrect letters in current turn
	 */
	public int calculateScore(int correctCount, int incorrectCount) throws HangmanExceptions {
		
		int tempIncorrectCount = incorrectCount;
		if ( correctCount > 0 && score + Math.pow(5, correctCount) <= 500) {
			score += Math.pow(5, correctCount) ;
		} else {
			score = 500;
		}
		while ( score > 0 && tempIncorrectCount > 0) {
			
			if (score >= 8 ) {
				score -= 8;
			} else {
				score = 0;
			}
			tempIncorrectCount -= 1;
		}
		return score;
	}

}
