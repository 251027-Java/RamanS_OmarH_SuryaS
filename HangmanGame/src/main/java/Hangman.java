import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        HashMap<Character, Boolean> correctLetters = new HashMap<Character, Boolean>();
        String word = "apple";
        for(char c: word.toCharArray()) {
            correctLetters.put(c, true);
        }
        System.out.println(correctLetters);

        Scanner scanner = new Scanner(System.in);

        int count = 0;
        boolean correctGuess = false;

        do {
            System.out.print("Enter your guess: ");
            char guessLetter = scanner.next().charAt(0);
            if(word.contains(String.valueOf(guessLetter))) {
                correctLetters.put(guessLetter, true);
            }
            else {
               count += 1;
            }

        } while(count == (correctLetters.size() + 2) || correctGuess == true);

        scanner.close();
    }
}
