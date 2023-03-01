# Laboratorio 4
## Integrantes
* Santiago Arévalo Rojas
* Juan Felipe Sánchez Pérez
## Parte I
1. Clonando el proyecto de Hangman:
<img src="/img/LAB4-1.png" width="80%" height="80%"/>
2. Para definir el cascarón de la interfaz de GameScore:

```
/**
    * GameScore is an interface that allows the Dependency Inversion about the way to calculate the current score
    * @author Santiago Arevalo y Juan Felipe Perez
    *
    * /
    public interface GameScore {
        /**
         * 
         * Calculate the score in order of the correct and incorrect points
         * @param correctCount is the amount of correct letters in current turn
         * @param incorrectCount is the amount of incorrect letters in current turn
         * @return
         * @throws HangmanExceptions
         * 
         */
         public int calculateScore (int correctCount, int incorrectCount) throws HangmanExceptions;
         public int getScore ();
         public void reset ();
}
```
Y así con la creación del cascarón de las clases concretas, es decir OriginalScore, BonusScore y PowerBonusScore.
3. Especificación del método calculateScore de la clase OriginalScore:

```
@Override
    /**
     * Calculate the original score, it means that discount 10 points each wrong letter
     * and the minimum score is 0
     * @Param correctCount is the amount of correct letters in current turn
     * @Param intcorrectCount is the amount of incorrect letters in current turn
     * @throws HangmanExceptions
     */
```

Especificación del método calculateScore en la clase BonusScore:

```
@Override    
    /**     
     * Calculate the bonus score,  it means that it adds 10 points      
     * each correct letter to the score, discount 5 point each wrong letter     
     * and 0 is the minimum score     
     * @Param correctCount is the amount of correct letters in current turn     
     * @Param intcorrectCount is the amount of incorrect letters in current turn     
     */
```

Especificación del método calculateScore en la clase PowerBonusScore:

```
@Override    
    /**     
     * Calculate the power bonus score, it means that adds 5^i points each i-th      
     * letter to the score, discount 8 points each wrong letter     
     * and 0 is the minimum score, also when the score is greater than 500 points,      
     * the final score will be 500     
     * @Param correctCount is the amount of correct letters in current turn     
     * @Param intcorrectCount is the amount of incorrect letters in current turn     
     */
```
   
4. Haciendo commit de los cambios:
<img src="/img/LAB4-2.png" width="80%" height="80%"/>
5. En el pom se agrega los siguiente para tener las dependencias de JUnit y la versión de java 8:
<img src="/img/LAB4-3.png" width="70%" height="70%"/>
6. Como se indica en el enunciado, las clases de equivalencia se indican en el comentario de cada una de las clases.
7. De igual forma, las pruebas son implementadas en sus debidas clases.
8. Se realiza el commit de la implementación de las pruebas:
<img src="/img/LAB4-4.png" width="80%" height="80%"/>
9. Luego de implementar los métodos y ejecutando las pruebas:
<img src="/img/LAB4-5.png" width="80%" height="80%"/>
10. Y realizar el commit:
<img src="/img/LAB4-6.png" width="80%" height="80%"/>
11. Finalmente el push para subir los cambios al repositorio en github:
<img src="/img/LAB4-7.png" width="80%" height="80%"/>

## Parte II
1. Para agregar el tipo de score en la aplicación, realizamos la inyección por medio del método de Factory, por la clase HangmanFactoryMethod, entonces decidimos implementar una nueva clase, llamada GameModelUpdated que extiende de la clase GameModel, esto con el fin de enviarle por parámetro el tipo de Score que iba a utilizar, con el atributo hangmanScore, de igual forma a la interfaz le implementamos el método reset para resetear la información de los puntajes, en el GUI le agregamos el atributo hangmanScore para guardar el tipo de puntaje que iba a realizar. Para la clase Factory, le creamos el método createHangmanScore y en el defaultFactory implementamos el método y creamos una instancia de OriginalScore, luego en el GUI se crea un GameModel de tipo GameModelUpdated.
* Clase GameModelUpdated:
```
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
        // TODO Auto-generated constructor stub    }
    @Override    public void reset() {
        randomWord = selectRandomWord();
        randomWordCharArray = randomWord.toCharArray();
        incorrectCount = 0;
        correctCount = 0;
        hangmanScore.reset();
        gameScore = hangmanScore.getScore();
    }
    @Override    public ArrayList<Integer> makeGuess(String guess){
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
```

* En la clase de FactoryMethod:
```
package hangman.setup.factoryMethod;
import hangman.model.GameScore;
import hangman.model.Language;
import hangman.model.dictionary.HangmanDictionary;
import hangman.view.HangmanPanel;
abstract public class HangmanFactoryMethod {
    abstract public Language createLanguage();
    abstract public HangmanDictionary createDictionary();
    abstract public HangmanPanel createHangmanPanel();
    abstract public GameScore createHangmanScore();
}                                                                                 
```
* Y en la clase de FactoryDefault se implementa el método createHangmanScore:
```
@Override    public GameScore createHangmanScore() {
        return new OriginalScore();
    }
```
* Finalmente en el GUI se le modifica el siguiente método para obtener el tipo de Score con el que se va a jugar:
```
// Use Factory method    
public GUI(HangmanFactoryMethod factoryMethod) {
        this.language = factoryMethod.createLanguage();
        this.dictionary = factoryMethod.createDictionary();
        this.hangmanPanel = factoryMethod.createHangmanPanel();
        this.hangmanScore = factoryMethod.createHangmanScore();
    }
```    
* Para terminar en SwingProject llamando al creador por medio del método de fábrica:
```
public static void main(String[] args) {
        createGUIUsingFactoryMethod().play();    
        }
```
2. Haciendo la inyección por medio de Guice, se debe agregar la siguiente dependencia al pom.xml:

```
<!-- https://mvnrepository.com/artifact/com.google.inject/guice -->
<dependency>    
  <groupId>com.google.inject</groupId>    
  <artifactId>guice</artifactId>    
  <version>5.1.0</version>
</dependency>
```

* En la clase FactoryServices se realiza la creación de las dependencias que se van a inyectar:
```
package hangman.setup.guice;
import hangman.model.BonusScore;
import hangman.model.English;
/** * * @author 2106913 */import hangman.model.French;
import hangman.model.GameScore;
import hangman.model.Language;
import hangman.model.OriginalScore;
import hangman.model.PowerBonusScore;
import hangman.model.dictionary.HangmanDictionary;
import hangman.model.dictionary.EnglishDictionaryDataSource;
import hangman.model.dictionary.FrenchDictionaryDataSource;
import hangman.view.HangmanNoviolentoPanel;
import hangman.view.HangmanPanel;
import hangman.view.HangmanStickmanPanel;
public class HangmanFactoryServices extends com.google.inject.AbstractModule {
    @Override    
    protected void configure() {
        /* Guice dependency injection */        
        // Initial definition of language        
        bind(Language.class).to(English.class);
        //Initial definition of dictionary        
        bind(HangmanDictionary.class).to(EnglishDictionaryDataSource.class);
        //Initial definition of panel        
        bind(HangmanPanel.class).to(HangmanStickmanPanel.class);
        //Initial definition of score        
        bind(GameScore.class).to(BonusScore.class);
    }
}
```
* Y luego en la clase GUI le realizamos la inyección:
```
@Inject    
// Use Guice constructor    
public GUI(Language language, HangmanDictionary dictionary, HangmanPanel hangmanPanel, GameScore hangmanScore){
        this.language = language;
        this.dictionary= dictionary;
        this.hangmanPanel = hangmanPanel;
        this.hangmanScore = hangmanScore;
    }
```
* Para terminar llamando en SwingProject llamando al creador por medio del método de Guice:
```
public static void main(String[] args) {
        createGUIUsingGuice().play();
        //createGUIUsingFactoryMethod().play();    
        }
```
