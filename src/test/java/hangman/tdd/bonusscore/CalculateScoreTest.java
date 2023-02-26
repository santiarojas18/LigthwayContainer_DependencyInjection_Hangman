package hangman.tdd.bonusscore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hangman.exceptions.HangmanExceptions;
import hangman.model.BonusScore;

/**
 * Class for test the calculteScore method of the BonusScore class
 * Equivalence Classes:
 * 1. Amount of incorrect points is greater than 0 when score is greater than 0
 * 2. Amount of correct points is greater than 0
 * 3. Amount of incorrect points is greater than 0 when score is 0
 * 4. Amount of incorrect points is less than 0
 * 5. Amount of correct points is less than 0
 * @author Santiago Arevalo y Juan Sanchez
 *
 */
class CalculateScoreTest {

	BonusScore scoreCalculator;
	
	@BeforeEach
	public void createABonusScoreObject () {
		scoreCalculator = new BonusScore();
	}
	
	@Test
	public void should_ReturnANumberBetween0AndN_When_IncorrectIsGreaterThan0AndScoreIsGreaterThan0 () {
		//arrange
		int correctPoints = 3;
		int incorrectPoints = 4;
		int score = 0;
		
		//act
		try {
			score = scoreCalculator.calculateScore(correctPoints, incorrectPoints);
		} catch (HangmanExceptions e) {
		}
		
		//assert
		assertEquals(10, score);
	}
	
	@Test
	public void should_ReturnAScoreGreaterThan0_When_CorrectIsGreaterThan0 () {
		//arrange
		int correctPoints = 4;
		int incorrectPoints = 0;
		int score = 0;
		
		//act
		try {
			score = scoreCalculator.calculateScore(correctPoints, incorrectPoints);
		} catch (HangmanExceptions e) {
		}
		
		//assert
		assertEquals(40, score);
	}
	
	@Test
	public void should_ReturnA0_When_IncorrectIsGreaterThan0AndScoreIsLessThan5 () {
		//arrange
		int correctPoints = 4;
		int incorrectPoints = 9;
		int score = 0;
		
		//act
		try {
			score = scoreCalculator.calculateScore(correctPoints, incorrectPoints);
		} catch (HangmanExceptions e) {
		}
		
		//assert
		assertEquals(0, score);
	}
	
	@Test
	public void should_ThrowNegativeNumberExcpetion_When_ANegativeIncorrectAmountIsSent () {
		//arrange
		int correctPoints = 0;
		int incorrectPoints = -10;
		
		//act
		try {
			scoreCalculator.calculateScore(correctPoints, incorrectPoints);
		} catch (HangmanExceptions e) {
			//assert
			assertEquals("A negative number can't be sent", e.getMessage());
		}
	}
	
	@Test
	public void should_ThrowNegativeNumberExcpetion_When_ANegativeCorrectAmountIsSent () {
		//arrange
		int correctPoints = -10;
		int incorrectPoints = 0;
		
		//act
		try {
			scoreCalculator.calculateScore(correctPoints, incorrectPoints);
		} catch (HangmanExceptions e) {
			//assert
			assertEquals("A negative number can't be sent", e.getMessage());
		}
	}


}
