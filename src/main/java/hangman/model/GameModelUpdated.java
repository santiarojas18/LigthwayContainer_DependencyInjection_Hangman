package hangman.model;

import java.util.ArrayList;

import hangman.exceptions.HangmanExceptions;
import hangman.model.dictionary.HangmanDictionary;

public class GameModelUpdated extends GameModel {

	private GameScore hangmanScore;
	
	public GameModelUpdated(HangmanDictionary dictionary, GameScore hangmanScore) {
		super(dictionary);
		this.gameScore = hangmanScore.getScore();
		this.hangmanScore = hangmanScore;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void reset() {
		randomWord = selectRandomWord();
        randomWordCharArray = randomWord.toCharArray();
        incorrectCount = 0;
        correctCount = 0;
		hangmanScore.reset();
		gameScore = hangmanScore.getScore();
	}
	
	@Override
	public ArrayList<Integer> makeGuess(String guess){
		char guessChar = guess.charAt(0);
		int tempIncorrectCount = 0;
		int tempCorrectCount = 0;
        ArrayList<Integer> positions = new ArrayList<>();
        for(int i = 0; i < randomWordCharArray.length; i++){
            if(randomWordCharArray[i] == guessChar){
                positions.add(i);
            }
        }
        if(positions.size() == 0){
            tempIncorrectCount = 1;
            incorrectCount++;
            
        } else {
        	tempCorrectCount = positions.size();
            correctCount += positions.size();
        };
        try {

            gameScore = hangmanScore.calculateScore(tempCorrectCount, tempIncorrectCount);
        } catch (HangmanExceptions e) {
        	
        }
        return positions;
	}
}
