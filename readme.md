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
9. Ejecutando las pruebas:
<img src="/img/LAB4-5.png" width="80%" height="80%"/>
10. Y realizar el commit:
<img src="/img/LAB4-6.png" width="80%" height="80%"/>
