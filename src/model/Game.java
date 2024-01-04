package model;

import java.util.InputMismatchException;
import java.util.Random;

public class Game {

    // Keep track of rounds left
    private int roundsLeft;

    // Keep track of scores
    private int userScore;
    private int computerScore;

    private final ScannerUserInput scannerUserInput;

    // Random used for computer's choice
    private final Random random;

    /**
     * Initialize the game
     *
     * @param scannerUserInput: The input scanner given from the main class.
     */
    public Game(ScannerUserInput scannerUserInput) {
        this.roundsLeft = 0;
        this.userScore = 0;
        this.computerScore = 0;
        this.scannerUserInput = scannerUserInput;
        this.random = new Random();
    }

    /**
     * The method which starts the chain of methods that play the amount
     * of rounds specified by the setNumRounds function
     */
    public void play() {
        // First prompt user with how many rounds must be played
        this.setNumRounds();

        // Keep on playing rounds
        do {
            playRound();
        } while (roundsLeft >= 1);

        // After the game, print the score
        this.printTotalScore();
    }

    /**
     * Prompt user for the amount of rounds and validate their answer.
     */
    public void setNumRounds() {

        // Keep on prompting until the roundsLeft var is set
        do {
            try {
                System.out.println("How many rounds would you like to play? ");
                this.roundsLeft = this.scannerUserInput.nextInt();

                // Throw if 0 since it's not valid.
                if (this.roundsLeft == 0) throw new InputMismatchException();

            } catch (InputMismatchException ignored) {
                System.out.println("Please enter a valid integer above 0");
            } finally {
                // .nextInt() doesn't read the following new-line character, so the first nextLine will always return an empty string
                // To prevent this from happening go to the next line here.
                this.scannerUserInput.nextLine();
            }
        } while (this.roundsLeft == 0);

    }

    /**
     * Request user's choice, randomly select a choice for the computer and compare.
     */
    public void playRound() {
        Hand userHand = requestUserInput();
        Hand computerHand = requestComputerHand();

        updateScore(userHand, computerHand);

        // Decrement the rounds left
        this.roundsLeft -= 1;
    }

    /**
     * Prompt the user for their choice. This is a recursive function in the case that the user's input is invalid.
     * Valid options are: R (rock), P (paper), S (scissors). Case ignored.
     *
     * @return the Hand (enum) chosen by the user.
     */
    public Hand requestUserInput() {
        System.out.println("Choose your hand (R/P/S)");
        String nextLineValue = scannerUserInput.nextLine();

        if (nextLineValue != null && !nextLineValue.isBlank() && nextLineValue.length() == 1) {
            Hand chosenHand = Hand.getHandByLetter(nextLineValue);
            // Should never return null, but check just in case. If it is null the recursion takes care of the rest
            if (chosenHand != null) {
                return chosenHand;
            }
            System.out.printf("\nYour given input: '%s' is not specified. Please select R/P/S\n", nextLineValue);
        }

        return requestUserInput();
    }


    /**
     * Randomly select a hand for the computer to play
     *
     * @return randomly chosen hand for thr computer to play.
     */
    public Hand requestComputerHand() {
        Hand[] hands = Hand.values();

        // Pick random value
        int randomIndex = random.nextInt(hands.length);
        return hands[randomIndex];
    }

    /**
     * Updated the score counters: userScore & computerScore
     *
     * @param userHand:     User's chosen hand
     * @param computerHand: Computer's chosen hand
     */
    public void updateScore(Hand userHand, Hand computerHand) {
        // Check for draw first, then check for if the user wins, if neither of those are true, then the computer wins
        if (userHand.equals(computerHand)) {
            System.out.printf("You played %s and the computer played %s, it's a draw! No points are awarded\n", userHand, computerHand);
        } else if (userWins(userHand, computerHand)) {
            this.userScore += 1;
            System.out.printf("You played %s and the computer played %s, you win! You are awarded 1 point.\n", userHand, computerHand);
        } else {
            this.computerScore += 1;
            System.out.printf("You played %s and the computer played %s, you lose. The computer is awarded 1 point.\n", userHand, computerHand);
        }
    }

    /**
     * A simple switch-statement that checks if the user wins.
     * This function should only be called after an initial draw check as this logic is based of a possible draw being ruled out.
     *
     * @param userHand     the users chosen hand
     * @param computerHand the computers randomly generated hand
     * @return true if the user wins
     */
    public boolean userWins(Hand userHand, Hand computerHand) {

        return switch (userHand) {
            // In the case that user has rock and the computer has scissors the user wins. else loses
            case ROCK -> computerHand.equals(Hand.SCISSORS);
            // In the case that user has paper and the computer has rock the user wins. else loses
            case PAPER -> computerHand.equals(Hand.ROCK);
            // Else the only possible outcome is that the user has scissors,
            // and so only check if the computer has paper
            case SCISSORS -> computerHand.equals(Hand.PAPER);
        };
    }

    /**
     * Print score as a scoreboard.
     */
    private void printTotalScore() {
        System.out.printf("\nFinal game scores:\nYou: %s\nComputer: %s\n", userScore, computerScore);
    }


    // Getters (used for unit testing)
    public int getUserScore() {
        return userScore;
    }

    public int getComputerScore() {
        return computerScore;
    }


    public int getRoundsLeft() {
        return roundsLeft;
    }
}
