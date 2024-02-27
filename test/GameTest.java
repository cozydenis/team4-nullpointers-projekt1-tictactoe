package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import packages.Game;


public class GameTest {

    @Test
    @DisplayName("Test if detects is not a win")
    public void testIsWinNoWin() {
        Game game = new Game();
        int[] currentGame = {0, 0, 0, 0, 0, 0, 0, 0, 0}; // Represents an empty game board
        boolean result = game.isWin(currentGame);
        assertEquals(false, result); // Expect the input to be returned as-is
        // Your isWin method should not trigger a win message with an empty board.
        // You can add more specific assertions based on your implementation.
    }

    @Test
    @DisplayName("Test if detects is a win")
    public void testIsWin() {
        Game game = new Game();
        int[] currentGame = {1, 1, 1, 2, 2, 0, 0, 0, 0}; // Represents a win game board
        boolean result = game.isWin(currentGame);
        assertEquals(true, result); // Expect the input to be returned as-is
    }

    @Test
    @DisplayName("Test if detects is a draw")
    public void testIsDraw() {
        Game game = new Game();
        int[] currentGame = {1, 2, 1, 2, 2, 1, 1, 1, 2}; // Represents full game board
        boolean result = game.isDraw(currentGame);
        assertEquals(true, result); // Expect the input to be returned as-is
    }

    @Test
    @DisplayName("Test if detects is not a draw")
    public void testIsNotDraw() {
        Game game = new Game();
        int[] currentGame = {1, 2, 1, 2, 2, 0, 1, 1, 2}; // Represents a game board with one empty cell
        boolean result = game.isDraw(currentGame);
        assertEquals(false, result); // Expect the input to be returned as-is
    }
}

/**
 * -------------------------------------------------------------------
 * THE FOLLOWING TESTS ARE NOT POSSIBLE TO TEST BECAUSE OF THE INPUT IS GETTING ASKED AGAIN!!
 * INDICATOR FOR BAD CODE DESIGN ?:(
 * -------------------------------------------------------------------
 * /*
 * Output text = new Output();
 * Input playerMove = new Input();
 * Game game = new Game();
 *
 * @BeforeEach public void setUp() {
 * game = new Game();
 * text = new Output();
 * playerMove = new Input();
 * game.Start();
 * }
 * /**
 * -------------------------------------------------------------------
 * @Test
 * @DisplayName("Test if the game starts")
 * public void testActAfterInputChangeLanguage() {
 * Game game = new Game();
 * game.Start();
 * String input = "L";
 * int language = 0 ;
 * String player = "X";
 * text.printTurn(language, player);
 * String result = game.actAfterInput(input);
 * assertEquals(1, result); // Expect the input to be returned as-is
 * assertEquals(1, game.getLanguage());
 * }
 * -------------------------------------------------------------------
 * @Test public void testActAfterInputRestartGame() {
 * Game game = new Game();
 * String input = "R";
 * String result = game.actAfterInput(input);
 * assertEquals("R", result); // Expect the input to be returned as-is
 * }
 * ----------------------------------------------------------------------
 * @Test public void testActAfterInputQuitGame() {
 * Game game = new Game();
 * String input = "Q";
 * String result = game.actAfterInput(input);
 * assertEquals("Q", result); // Expect the input to be returned as-is
 * }
 * ---------------------------------------------------------------------
 * @Test public void testActAfterInputGetHelp() {
 * Game game = new Game();
 * String input = "H";
 * String result = game.actAfterInput(input);
 * assertEquals("H", result); // Expect the input to be returned as-is
 * }
 * ---------------------------------------------------------------------
 * @Test
 * @DisplayName("Test if detects is  a win")
 * public void testIsWin() {
 * Game game = new Game();
 * int[] currentGame = {1,1,1, 0, 0, 0, 0, 0, 0}; // Represents an empty game board
 * game.isWin(currentGame);
 * // Your isWin method should not trigger a win message with an empty board.
 * // You can add more specific assertions based on your implementation.
 * }
 * <p>
 * // Add more test cases for isWin, actAfterInput, and other methods as needed.
 * ---------------------------------------------------------------------
 * not possible to test because input gets asked again
 * <p>
 * <p>
 * <p>
 * /*
 */