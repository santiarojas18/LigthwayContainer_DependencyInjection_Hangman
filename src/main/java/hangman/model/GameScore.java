package hangman.model;

/**
 * GameScore is an interface that allows the Dependency Inversion about the way to calculate the current score
 * @author Santiago Arevalo y Juan Felipe Perez
 *
 */
public interface GameScore {
	public int calculateScore (int correctCount, int incorrectCount);
}
