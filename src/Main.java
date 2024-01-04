import model.Game;
import model.ScannerUserInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create scanner
        Scanner inputScanner = new Scanner(System.in);
        ScannerUserInput scannerUserInput = new ScannerUserInput(inputScanner);

        // Create and start game
        Game game = new Game(scannerUserInput);
        game.play();
    }
}
