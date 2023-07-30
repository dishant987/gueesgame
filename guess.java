import java.util.Random;
import java.util.Scanner;

public class guess {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randomNum = new Random();
        System.out.print("Enter your name : ");
        String name = scan.nextLine();

        int rangeStart = 1; // starting number 
        int rangeEnd = 100; // ending number 
        int maxAttempts = 6; //maximum number of attempts
        int totalRounds = 3; //total number of rounds

        int totalScore = 0;
        
        System.out.println("Welcome "+name+" to the Number Guessing Game!");
        System.out.println(
                "You have " + totalRounds + " rounds to play. Each round, you have " + maxAttempts + " attempts.");
        System.out.println("Let's start the game!");

        for (int round = 1; round <= totalRounds; round++) {
            int targetNumber = randomNum.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
            System.out.println("\nRound " + round + ":");
            System.out.println("I have chosen a number between " + rangeStart + " and " + rangeEnd);

            int attempts = 0;
            int guess;
            int roundScore = 0;

            while (attempts < maxAttempts) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess number: ");
                guess = scan.nextInt();

                if (guess == targetNumber) {
                    roundScore = maxAttempts - attempts + 1;
                    totalScore += roundScore;
                    System.out.println("Congratulations! You guessed the correct number " + targetNumber + " in "
                            + attempts + " attempts.");
                    System.out.println("Round Score: " + roundScore);
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("\nRound " + round + " over! You couldn't guess the number. The correct number was: "
                        + targetNumber);
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Score: " + totalScore);
        scan.close();
    }
}
