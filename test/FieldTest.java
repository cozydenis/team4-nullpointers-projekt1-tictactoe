package test;

import packages.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains tests for the Field class, ensuring its functionality is correct.
 */
public class FieldTest {

    private Field gameField;

    /**
     * Setup method which is executed before each test. Initializes the game field.
     */
    @BeforeEach
    public void setUp() {
        gameField = new Field();
    }

    /**
     * Tests if the game field is initialized correctly with default values (0).
     */
    @Test
    public void testInitializeField() {
        int[] expected = new int[9];
        assertArrayEquals(expected, gameField.getField());
    }


    /**
     * Tests if a valid move on the game field is accepted.
     * X is playing on the first cell (A1) of the field.
     */
    @Test
    public void testValidMove() {
        assertTrue(gameField.setField(2, "A1"));
    }


    /**
     * Tests if an invalid move due to a position already being occupied is rejected.
     * X is playing on the first cell (A1) of the field.
     * O wants to play on the occupied cell A1.
     */
    @Test
    public void testInvalidMoveDueToPositionOccupied() {
        gameField.setField(2, "A1");
        assertFalse(gameField.setField(3, "A1"));
    }


    /**
     * Tests if an invalid move due to an invalid position is rejected.
     * X wants to play on an unexisting cell D1.
     */
    @Test
    public void testInvalidMoveDueToInvalidPosition() {
        assertFalse(gameField.setField(2, "D1"));
    }

    /**
     * Tests if an invalid move due to an invalid player ID is rejected.
     */
    @Test
    public void testInvalidMoveDueToInvalidId() {
        assertFalse(gameField.setField(1, "A1"));
        assertFalse(gameField.setField(4, "A1"));
    }

    /**
     * Tests if the game field can be reset to its default state correctly.
     */
    @Test
    public void testResetGameFieldArray() {
        gameField.setField(2, "A1");
        gameField.setField(3, "A2");
        gameField.resetGameFieldArray();
        int[] expected = new int[9];
        assertArrayEquals(expected, gameField.getField());
    }
}
