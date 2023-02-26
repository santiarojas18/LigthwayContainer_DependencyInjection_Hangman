package hangman.exceptions;

/**
 * Class to manage when a negative value is sent to calculate the score
 * @author Santiago Arevalo and Juan Sanchez
 *
 */
public class ANegativeValue extends HangmanExceptions{

	public ANegativeValue(String message) {
		super(message);
	}

}
