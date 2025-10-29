import java.util.Scanner;
import java.util.Arrays;

public class Hangman {
    public static void main(String[] args) {
        //word
        String word = "Dinosaur";

        // empty array with all false values
        boolean[] wordBoolean = new boolean[word.length()];
        System.out.println(Arrays.toString(wordBoolean));

        Scanner scanner = new Scanner(System.in);

        // We just need to ask the user for the letter and if they guess correctly update the
        // array value to true.  We can print an array of underscores and replace correctly guessed
        // letters with X.

        scanner.close();
    }
}
