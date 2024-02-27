package packages;

import java.util.Arrays;

/**
 * Represents a game field with methods to manage and interact with the field.
 */
public class Field {
    private int[] gameFieldArray;
    int newPositionInArrayIndex;

    public Field() {
        gameFieldArray = new int[9];
        newPositionInArrayIndex = 0;
    }

    /**
     * Retrieves the entire game field array.
     *
     * @return The game field array.
     */
    public int[] getField() {
        return gameFieldArray;
    }

    /**
     * Sets a value in the game field array based on a specified ID and drawing command.
     *
     * @param id      The ID to determine if X (= id 02) or O (= id 03) is playing.
     * @param newDraw The coordinates from the game field.
     * @return true if the value was set successfully, false otherwise.
     */
    public boolean setField(int id, String newDraw) {
        if (!checkMoveValidity(newDraw)) {
            return false;
        }

        if (!(id == 2 || id == 3)) {
            return false;
        }
        gameFieldArray[newPositionInArrayIndex] = --id;
        return true;
    }

    /**
     * Checks the validity of a move based on a specified field from the game field.
     *
     * @param newDraw The coordinates from the game field.
     * @return true if the move is valid, false otherwise.
     */
    private boolean checkMoveValidity(String newDraw) {
        newPositionInArrayIndex = switch (newDraw) {
            // First row
            case "A1" -> 0;
            case "A2" -> 3;
            case "A3" -> 6;

            // Second row
            case "B1" -> 1;
            case "B2" -> 4;
            case "B3" -> 7;

            // Third row
            case "C1" -> 2;
            case "C2" -> 5;
            case "C3" -> 8;
            default -> -1;
        };
        if ((newPositionInArrayIndex == -1) || (gameFieldArray[newPositionInArrayIndex] != 0)) {
            return false;
        }
        return true;
    }

    /**
     * Resets the game field array to its default state.
     */
    public void resetGameFieldArray() {
        Arrays.fill(gameFieldArray, 0);
    }
}