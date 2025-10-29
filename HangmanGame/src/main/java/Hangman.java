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
                System.out.println("The letter " + guessLetter + " is not in the word!");
                count += 1;
                System.out.println("You have gussed " + count + " time(s) and you have " + (correctLetters.size() + 2 - count) + " guesses left!");
            }
            System.out.println("Do you know what the word is? Enter Yes or No");
            String ans = scanner.next();
            if (ans.equals("Yes")) {
                System.out.println("Enter what you think the word is: ");
                ans = scanner.next();
                if (ans.equals(word)) {
                    correctGuess = true;
                    if (correctGuess == true) {
                        break;
                    }
                }
                else {
                    System.out.println("Wrong Guess! Try again");
                    continue;
                }
            }
            else {
                continue;
            }
        } while(count <= (correctLetters.size() + 2) || correctGuess == false);
        if (correctGuess == true) {
            System.out.println("You win! The correct word was " + word);
        }
        else {
            System.out.println("You lose! The correct word was " + word);
        }

        scanner.close();
    }
}
