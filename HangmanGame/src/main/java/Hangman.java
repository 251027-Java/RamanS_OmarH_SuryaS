import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class Hangman {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        String word = "thesaurus";
        String guessedLetter = "";
        String[] letters = word.split("");
        String[] dashes = new String[letters.length];


        Arrays.fill(dashes, "_");
        int numberOfGuesses = dashes.length+2;

        boolean hangmanCompleted = false;
        int count = 0;
        boolean correctLetter = false;
        System.out.println("This is how many letters the word has: " + Arrays.toString(dashes));
        System.out.println("You have a total of " + numberOfGuesses + " guesses left.");

        do {

            System.out.print("\nEnter your guess for the next letter: ");

            guessedLetter = scanner.next();

            boolean enteredElseIf = false;
            for (int i = 0; i < letters.length; i++) {
                if (letters[i].equals(guessedLetter) && !dashes[i].equals(letters[i])) {
                    dashes[i] = letters[i];
                    correctLetter = true;
                }
                else if (letters[i].equals(guessedLetter) && !enteredElseIf){
                    enteredElseIf = true;
                    System.out.println("You've already guessed that letter.");
                    System.out.println("You have "+ numberOfGuesses +" guesses left.");
                    correctLetter = true;
                }
                else{
                    correctLetter = false;
                }
            }
            if (correctLetter) {
                System.out.println("That was a correct letter!");
                System.out.println("This is your current status: " + Arrays.toString(dashes));
            }
            else {
                numberOfGuesses--;
                System.out.println("That was incorrect!");
                System.out.println("This is your current status: " + Arrays.toString(dashes));
            }
            System.out.println("You have "+ numberOfGuesses +" guesses left.");
            correctLetter = false;
            if (Arrays.equals(letters, dashes)) {
                System.out.println("\nYou won!");
                System.out.println("The correct word was: " + Arrays.toString(dashes));
                break;
            }

        } while (numberOfGuesses > 0);

        if(!Arrays.equals(letters, dashes)) {
            System.out.println("You lost!");
            System.out.println("The correct word was: " + Arrays.toString(letters));
            System.out.println("This was your guess: " + Arrays.toString(dashes));
        }
    }
}
