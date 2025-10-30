import java.util.Scanner;
import java.util.Arrays;

public class Hangman {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        String word = "omar";
        String[] letters = word.split("");
        String[] dashes = new String[letters.length];

        for (int i = 0; i < dashes.length; i++) {
            dashes[i] = "_";
        }
        boolean hangmanCompleted = false;
        int count = 0;
        boolean correctLetter = false;
        System.out.println("This is how many letters the word has: " + Arrays.toString(dashes));
        int guessNum = 7;
        System.out.println("You have a total of " + guessNum + " guesses left.");
        do {
            System.out.print("Enter your guess for the next letter: ");
            word = scanner.next();
            for (int i = 0; i < letters.length; i++) {
                if (letters[i].equals(word)) {
                    dashes[i] = letters[i];
                    correctLetter = true;
                }
            }
            if (correctLetter) {
                System.out.println("That was a correct letter!");
                System.out.println("You have a total of " + guessNum + " guesses left.");
                System.out.println("This is your current status: " + Arrays.toString(dashes));
                System.out.println("");
            }
            else {
                System.out.println("That was incorrect!");
                guessNum -= 1;
                System.out.println("You have a total of " + guessNum + " guesses left.");
                System.out.println("This is your current status: " + Arrays.toString(dashes));
                System.out.println("");
                count += 1;
            }
            correctLetter = false;
            if (Arrays.equals(letters, dashes)) {
                System.out.println("You won!");
                System.out.println("The correct word was: " + Arrays.toString(letters));
                System.out.println("This was your guess: " + Arrays.toString(dashes));
                break;
            }
        } while (guessNum != 0);
        if (guessNum == 0) {
            System.out.println("You lost!");
            System.out.println("The correct word was: " + Arrays.toString(letters));
            System.out.println("This was your guess: " + Arrays.toString(dashes));
        }

    }
}
