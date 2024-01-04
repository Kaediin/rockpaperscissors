package model;

import interfaces.UserInputInterface;

import java.util.Scanner;

/**
 * The implementation of the UserInputInterface using Java's Scanner for console input.
 */
public class ScannerUserInput implements UserInputInterface {

    private final Scanner scanner;

    public ScannerUserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public int nextInt() {
        return scanner.nextInt();
    }
}
