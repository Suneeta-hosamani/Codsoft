import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {

        // try-with-resources automatically closes the Scanner when done
        try (Scanner sc = new Scanner(System.in)) {
            Random rand = new Random();

            int totalScore = 0;
            boolean playAgain = true;

            System.out.println("🎯 Welcome to the Number Guessing Game!");

            while (playAgain) {
                int lowerBound = 1;
                int upperBound = 100;
                int randomNumber = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;

                int maxAttempts = 7; // limit attempts per round
                int attempts = 0;
                boolean guessedCorrectly = false;

                System.out.println("\nI've picked a number between " + lowerBound + " and " + upperBound + ".");
                System.out.println("You have " + maxAttempts + " attempts to guess it!");

                while (attempts < maxAttempts && !guessedCorrectly) {
                    System.out.print("\nEnter your guess: ");
                    int userGuess;

                    // check for valid input
                    if (!sc.hasNextInt()) {
                        System.out.println("⚠️ Please enter a valid number!");
                        sc.next(); // discard invalid input
                        continue;
                    }

                    userGuess = sc.nextInt();
                    attempts++;

                    if (userGuess == randomNumber) {
                        System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts!");
                        guessedCorrectly = true;

                        // scoring logic
                        int roundScore = (maxAttempts - attempts + 1) * 10;
                        totalScore += roundScore;
                        System.out.println("⭐ You earned " + roundScore + " points this round.");
                    } else if (userGuess < randomNumber) {
                        System.out.println("📉 Too low! Try again.");
                    } else {
                        System.out.println("📈 Too high! Try again.");
                    }
                }

                if (!guessedCorrectly) {
                    System.out.println("\n❌ Out of attempts! The correct number was: " + randomNumber);
                }

                // Ask for next round
                System.out.print("\nDo you want to play again? (yes/no): ");
                String response = sc.next().toLowerCase();
                if (!response.equals("yes") && !response.equals("y")) {
                    playAgain = false;
                }
            }

            System.out.println("\n🏁 Game Over! Your total score: " + totalScore);
            System.out.println("Thanks for playing! 👋");
        }
    }
}

