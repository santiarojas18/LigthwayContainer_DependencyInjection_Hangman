package hangman.tdd.powerbonusscore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hangman.exceptions.HangmanExceptions;
import hangman.model.PowerBonusScore;

/**
 * Class for test the calculteScore method of the PowerBonusScore class
 * Equivalence Classes:
 * 1. Amount of incorrect points is greater than 0 when score is 0
 * 2. Amount of correct points is greater or equal than 4
 * 3. Amount of correct points is between 0 and 3
 * 4. Amount of incorrect points is less than 0
 * 5. Amount of correct points is less than 0
 * 6. Amount of incorrect points is greater than 0 when score is greater than 0
 * @author Santiago Arevalo and Juan Sanchez
 *
 */
class CalculateScoreTest {

	PowerBonusScore scoreCalculator;
	
	@BeforeEach
	public void createAPowerBonusScoreObject () {
		scoreCalculator = new PowerBonusScore();
	}
	
	@Test
	public void should_ReturnA0_When_IncorrectIsGreaterThan0AndScoreIs0 () {
		//arrange
		int correctPoints = 2;
		int incorrectPoints = 4;
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
	public void should_ReturnA500_When_CorrectIsGreaterOrEqualThan4 () {
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
		assertEquals(500, score);
	}
	
	@Test
	public void should_ReturnANumberBetween0And500_When_CorrectIsBetween0And3 () {
		//arrange
		int correctPoints = 3;
		int incorrectPoints = 0;
		int score = 0;
		
		//act
		try {
			score = scoreCalculator.calculateScore(correctPoints, incorrectPoints);
		} catch (HangmanExceptions e) {
		}
		
		//assert
		assertEquals(125, score);
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
	
	@Test
	public void should_ReturnANumberBetween0And500_When_IncorrectIsGreaterThan0AndScoreIsGreaterThan0 () {
		//arrange
		int correctPoints = 2;
		int incorrectPoints = 3;
		int score = 0;
		
		//act
		try {
			score = scoreCalculator.calculateScore(correctPoints, incorrectPoints);
		} catch (HangmanExceptions e) {
		}
		
		//assert
		assertEquals(1, score);
	}

}
