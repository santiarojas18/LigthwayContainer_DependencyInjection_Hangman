package hangman.tdd.originalscore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hangman.exceptions.*;
import hangman.model.OriginalScore;

/**
 * Class for testing the calculateScore method in OriginalScore class
 * Equivalence Classes:
 * 1. Amount of incorrect points is greater than 10
 * 2. Amount of incorrect points is between 0 and 10
 * 3. Amount of correct points is greater or equal than 0
 * 4. Amount of incorrect points is less than 0
 * 5. Amount of correct points is less than 0
 * @author Santiago Arevalo y Juan Sanchez
 *
 */
class CalculateScoreTest {

	OriginalScore scoreCalculator;
	
	@BeforeEach
	public void createAnOrginalScoreObject () {
		scoreCalculator = new OriginalScore();
	}
	
	@Test
	public void should_ReturnA0_When_IncorrectIsGreaterThan10 () {
		//arrange
		int correctPoints = 0;
		int incorrectPoints = 11;
		int score = 0;
		
		//act
		try {
			score = scoreCalculator.calculateScore(correctPoints, incorrectPoints);
		} catch (HangmanExceptions e) {
		}
		System.out.println(score);
		
		//assert
		assertEquals(0, score);
	}
	
	@Test
	public void should_ReturnANumberBetween0And100_When_IncorrectIsLessThan10() {
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
		assertEquals(60, score);
	}
	
	@Test
	public void should_Return100_When_DoesntHaveAnyIncorrect () {
		//arrange
		int correctPoints = 10;
		int incorrectPoints = 0;
		int score = 0;
				
		//act
		try {
			score = scoreCalculator.calculateScore(correctPoints, incorrectPoints);
		} catch (HangmanExceptions e) {
		}
		
		//assert
		assertEquals(100, score);
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
