package hangman.model;

import hangman.exceptions.ANegativeValue;
import hangman.exceptions.HangmanExceptions;

/**
 * Class with the hangman power bonus score
 * @author Santiago Arevalo y Juan Sanchez
 *
 */
public class PowerBonusScore implements GameScore {
	private int score;
	private int currentCorrectPoints;
	
	/**
	 * Constructor of PowerBonusScore objects, with initial score of 0
	 */
	public PowerBonusScore () {
		score = 0;
		currentCorrectPoints = 0;
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
		if (correctCount < 0 || incorrectCount < 0) throw new ANegativeValue("A negative number can't be sent");
		int temporalScore = score;
		for (int i = 0; i < correctCount; i++) {
			currentCorrectPoints++;
			temporalScore += Math.pow(5, currentCorrectPoints);
			if (temporalScore <= 500) {
				score = temporalScore;
			} else {
				score = 500;
				break;
			}
		}
		temporalScore = score;
		for (int i = 0; i < incorrectCount; i++) {
			temporalScore -= 8;
			if (temporalScore >= 0) {
				score = temporalScore;
			} else {
				score = 0;
				break;
			}
		}
		return score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void reset() {
		score = 0;
		currentCorrectPoints = 0;
	}

}
