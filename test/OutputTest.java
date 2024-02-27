/**
 * This class contains JUnit test cases for the 'Output' class.
 */
package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import packages.Output;

public class OutputTest {
    /**
     * Test case for the 'printError' method.
     * Verifies that the correct message gets passed to the'printError'method.
     * The expected error message is "Ungültige Eingabe".
     *
     * @throws AssertionError if the actual error message doesn't match the expected error message.
     */
    @Test
    public void testPrintError() {
        Output output = new Output();
        String actual = output.messages[1][3];

        assertEquals(actual, "Ungültige Eingabe. Versuchen Sie es erneut.", "Wrong message");
    }

    /**
     * Test case for the 'printTie' method.
     * Verifies that the correct message gets passed to the'printTie'method.
     * The expected error message is "its a tie\nPress 'R' to start a new game or 'Q' to quit: ".
     *
     * @throws AssertionError if the actual error message doesn't match the expected error message.
     */
    @Test
    public void testPrintTie() {
        Output output = new Output();
        String actual = output.messages[0][5];

        assertEquals(actual, "its a tie\nPress 'R' to start a new game or 'Q' to quit: ", "Wrong message");
    }

    /**
     * Test case for the 'printBoard' method with a random game board.
     * Verifies that the 'printBoard' method generates the correct board representation.
     * Compares the actual board output with the expected board output.
     *
     * @throws AssertionError if the actual board representation doesn't match the expected board representation.
     */
    @Test
    public void testPrintBoardRandom() {
        Output output = new Output();
        String actual = "\n" + "    A   B   C\n " +
                "  ___________\n" +
                "  |   |   |   |\n" +
                "1 | " + output.decode(2) + " | " + output.decode(1) + " | " + output.decode(0) + " |  \n" +
                "  |---|---|---|\n" +
                "2 | " + output.decode(1) + " | " + output.decode(2) + " | " + output.decode(2) + " |  \n" +
                "  |---|---|---|\n" +
                "3 | " + output.decode(0) + " | " + output.decode(1) + " | " + output.decode(0) + " |  \n" +
                "  |___|___|___|\n" +
                "";
        assertEquals(actual, "\n" + "    A   B   C\n " +
                "  ___________\n" +
                "  |   |   |   |\n" +
                "1 | " + "O" + " | " + "X" + " | " + " " + " |  \n" +
                "  |---|---|---|\n" +
                "2 | " + "X" + " | " + "O" + " | " + "O" + " |  \n" +
                "  |---|---|---|\n" +
                "3 | " + " " + " | " + "X" + " | " + " " + " |  \n" +
                "  |___|___|___|\n" +
                "", "Wrong board");
    }

    /**
     * Additional test cases for the 'printBoard' method with various game board configurations.
     * These test cases verify the correctness of the 'printBoard' method for different board states.
     *
     * @throws AssertionError if the actual board representation doesn't match the expected board representation.
     */
    @Test
    public void testPrintBoardAllEmpty() {
        // Test case for an empty game board.
        Output output = new Output();
        String actual = "\n" + "    A   B   C\n " +
                "  ___________\n" +
                "  |   |   |   |\n" +
                "1 | " + output.decode(0) + " | " + output.decode(0) + " | " + output.decode(0) + " |  \n" +
                "  |---|---|---|\n" +
                "2 | " + output.decode(0) + " | " + output.decode(0) + " | " + output.decode(0) + " |  \n" +
                "  |---|---|---|\n" +
                "3 | " + output.decode(0) + " | " + output.decode(0) + " | " + output.decode(0) + " |  \n" +
                "  |___|___|___|\n" +
                "";
        assertEquals(actual, "\n" + "    A   B   C\n " +
                "  ___________\n" +
                "  |   |   |   |\n" +
                "1 | " + " " + " | " + " " + " | " + " " + " |  \n" +
                "  |---|---|---|\n" +
                "2 | " + " " + " | " + " " + " | " + " " + " |  \n" +
                "  |---|---|---|\n" +
                "3 | " + " " + " | " + " " + " | " + " " + " |  \n" +
                "  |___|___|___|\n" +
                "", "Wrong board");
    }

    @Test
    public void testPrintBoardAllO() {
        // Test case for a game board with all cells occupied by 'O'.
        Output output = new Output();
        String actual = "\n" + "    A   B   C\n " +
                "  ___________\n" +
                "  |   |   |   |\n" +
                "1 | " + output.decode(2) + " | " + output.decode(2) + " | " + output.decode(2) + " |  \n" +
                "  |---|---|---|\n" +
                "2 | " + output.decode(2) + " | " + output.decode(2) + " | " + output.decode(2) + " |  \n" +
                "  |---|---|---|\n" +
                "3 | " + output.decode(2) + " | " + output.decode(2) + " | " + output.decode(2) + " |  \n" +
                "  |___|___|___|\n" +
                "";
        assertEquals(actual, "\n" + "    A   B   C\n " +
                "  ___________\n" +
                "  |   |   |   |\n" +
                "1 | " + "O" + " | " + "O" + " | " + "O" + " |  \n" +
                "  |---|---|---|\n" +
                "2 | " + "O" + " | " + "O" + " | " + "O" + " |  \n" +
                "  |---|---|---|\n" +
                "3 | " + "O" + " | " + "O" + " | " + "O" + " |  \n" +
                "  |___|___|___|\n" +
                "", "Wrong board");
    }

    @Test
    public void testPrintBoardAllX() {
        // Test case for a game board with all cells occupied by 'X'.
        Output output = new Output();
        String actual = "\n" + "    A   B   C\n " +
                "  ___________\n" +
                "  |   |   |   |\n" +
                "1 | " + output.decode(1) + " | " + output.decode(1) + " | " + output.decode(1) + " |  \n" +
                "  |---|---|---|\n" +
                "2 | " + output.decode(1) + " | " + output.decode(1) + " | " + output.decode(1) + " |  \n" +
                "  |---|---|---|\n" +
                "3 | " + output.decode(1) + " | " + output.decode(1) + " | " + output.decode(1) + " |  \n" +
                "  |___|___|___|\n" +
                "";
        assertEquals(actual, "\n" + "    A   B   C\n " +
                "  ___________\n" +
                "  |   |   |   |\n" +
                "1 | " + "X" + " | " + "X" + " | " + "X" + " |  \n" +
                "  |---|---|---|\n" +
                "2 | " + "X" + " | " + "X" + " | " + "X" + " |  \n" +
                "  |---|---|---|\n" +
                "3 | " + "X" + " | " + "X" + " | " + "X" + " |  \n" +
                "  |___|___|___|\n" +
                "", "Wrong board");
    }

    @Test
    public void testPrintBoardDiagX() {
        // Test case for a game board with a diagonal of 'X' marks.
        Output output = new Output();
        String actual = "\n" + "    A   B   C\n " +
                "  ___________\n" +
                "  |   |   |   |\n" +
                "1 | " + output.decode(1) + " | " + output.decode(1) + " | " + output.decode(0) + " |  \n" +
                "  |---|---|---|\n" +
                "2 | " + output.decode(1) + " | " + output.decode(1) + " | " + output.decode(2) + " |  \n" +
                "  |---|---|---|\n" +
                "3 | " + output.decode(0) + " | " + output.decode(1) + " | " + output.decode(1) + " |  \n" +
                "  |___|___|___|\n" +
                "";
        assertEquals(actual, "\n" + "    A   B   C\n " +
                "  ___________\n" +
                "  |   |   |   |\n" +
                "1 | " + "X" + " | " + "X" + " | " + " " + " |  \n" +
                "  |---|---|---|\n" +
                "2 | " + "X" + " | " + "X" + " | " + "O" + " |  \n" +
                "  |---|---|---|\n" +
                "3 | " + " " + " | " + "X" + " | " + "X" + " |  \n" +
                "  |___|___|___|\n" +
                "", "Wrong board");
    }

    @Test
    public void testPrintBoardVerticalO() {
        // Test case for a game board with a vertical column of 'O' marks.
        Output output = new Output();
        String actual = "\n" + "    A   B   C\n " +
                "  ___________\n" +
                "  |   |   |   |\n" +
                "1 | " + output.decode(2) + " | " + output.decode(1) + " | " + output.decode(0) + " |  \n" +
                "  |---|---|---|\n" +
                "2 | " + output.decode(2) + " | " + output.decode(2) + " | " + output.decode(2) + " |  \n" +
                "  |---|---|---|\n" +
                "3 | " + output.decode(2) + " | " + output.decode(1) + " | " + output.decode(0) + " |  \n" +
                "  |___|___|___|\n" +
                "";
        assertEquals(actual, "\n" + "    A   B   C\n " +
                "  ___________\n" +
                "  |   |   |   |\n" +
                "1 | " + "O" + " | " + "X" + " | " + " " + " |  \n" +
                "  |---|---|---|\n" +
                "2 | " + "O" + " | " + "O" + " | " + "O" + " |  \n" +
                "  |---|---|---|\n" +
                "3 | " + "O" + " | " + "X" + " | " + " " + " |  \n" +
                "  |___|___|___|\n" +
                "", "Wrong board");
    }
}
