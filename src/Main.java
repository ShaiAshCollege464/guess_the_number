import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean winnerFound;
        int triesCounter = 0;
        boolean player1Turn = true;
        int secret = getNumberInRange(1, 1000);
        do {
            int playerNumber = player1Turn ? 1 : 2;
            winnerFound = getPlayerGuessAndCheck(playerNumber, secret);
            triesCounter++;
            System.out.println("(" + triesCounter + " turns)");
            player1Turn = !player1Turn; //switch players
        } while (!winnerFound);
    }

    public static boolean getPlayerGuessAndCheck(int playerNumber, int secret) {
        boolean success = false;
        int guess = getPlayerGuess(playerNumber);
        if (guess == secret) {
            System.out.println("Correct! Player " + playerNumber + " is the winner!");
            success = true;
        } else {
            printHint(secret, guess);
        }
        return success;
    }

    private static int getPlayerGuess (int playerNumber) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player " + playerNumber + ", guess a number: ");
        int guess = scanner.nextInt();
        return guess;
    }

    public static void printHint (int secret, int guess) {
        boolean higher;
        if (secret > guess) {
            higher = true;
        } else {
            higher = false;
        }
        System.out.println("Wrong answer! Try a " + (higher ? "higher" : "lower") + " number...");
    }

    public static int getNumberInRange (int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
