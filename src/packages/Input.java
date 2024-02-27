package packages;

import java.util.Scanner;

/**
 * The Input class is responsible for handling user input.
 */
public class Input {
    private final Scanner scanner;

    /**
     * Constructs an Input object and initializes the Scanner for reading user input.
     */
    public Input() {
        scanner = new Scanner(System.in);
    }

    /**
     * Reads and returns the player's move as a string.
     *
     * @return The player's move as a string.
     */
    public String getPlayerMove(int language) {
        String input = scanner.nextLine().trim().toUpperCase();

        while (!isValidInput(input)) {
            if (language == 0) {
                System.out.print("Invalid input, please enter a value between A1 and C3:");
            } else {
                System.out.print("Ungultige eingabe, bitte gib einen Wert zwischen A1 und C3 ein:");

            }

            input = scanner.nextLine().trim().toUpperCase();
        }

        return input;
    }

    /**
     * Checks if the provided input is valid.
     *
     * @param input The input to validate.
     * @return True if the input is valid, false otherwise.
     */
    public boolean isValidInput(String input) {
        if (input.equals("L") || input.equals("R") || input.equals("Q") || input.equals("H")) {
            return true;
        }

        if (input.length() != 2) {
            return false;
        }

        char col = input.charAt(0);
        char row = input.charAt(1);

        return (col == 'A' || col == 'B' || col == 'C') &&
                (row == '1' || row == '2' || row == '3');
    }
}
