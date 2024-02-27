package test;


/**
 * This class contains test cases for the Input class to validate user inputs.
 */

import org.junit.jupiter.api.Test;
import packages.Input;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {

    /**
     * Test the user input validation.
     */
    @Test
    public void testUserInput() {
        String[] letters = {"A", "B", "C"};
        int[] numbers = {1, 2, 3};

        Input input = new Input();

        for (String letter : letters) {
            for (int number : numbers) {
                String element = letter + number;

                assertEquals(true, input.isValidInput(element));
            }
        }
    }
}
