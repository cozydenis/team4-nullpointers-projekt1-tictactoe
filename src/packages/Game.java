package packages;

/**
 * The class game is the main class of the project. It creates new instances of the classes Field, Output and Input,
 * starts the game and ends until the player wants to end the game.
 * Whithin the game, the player can restart the game, change the language, get help or quit the game.
 * Own methods: actAfterInput, endOrPlayAgain, isWin, isDraw, endGame, restartGame
 */
public class Game {

    private Input playerMove;   //Gets player input
    private Field currentGame; // generates and updates field and checks if new move is valid
    private Output gameBoard;  // Prints current game board (after every draw)
    private Output text;       // Prints all interactions for the player
    private boolean isPlayerX = true;
    private int currentPlayer;             // parameter for setField, 2 = X, 3 = O
    private static final int PLAYERX = 2;
    private static final int PLAYERO = 3;
    private int language = ENGLISH; // 0 = English, 1 = German
    private static final int ENGLISH = 0;
    private static final int GERMAN = 1;
    private String actualPlayer; // X or O depending on isPlayerX


    public Game() {
    }

    /**
     * The start method creates new instances of the classes Field, Output and Input,
     * starts the game and ends until the player wishes to end the game.
     *
     * @param newDraw     the new draw/input of the player
     * 
     */
    public void start() {

        currentGame = new Field();
        gameBoard = new Output();
        text = new Output();
        playerMove = new Input();
        String newDraw = "";

        isPlayerX = true;
        text.printWelcome(language);
        gameBoard.printBoard(currentGame.getField());

        while (!newDraw.equals("Q")) {

            if (isPlayerX) {
                currentPlayer = PLAYERX;
                actualPlayer = "X";
            } else {
                currentPlayer = PLAYERO;
                actualPlayer = "O";
            }
            text.printTurn(language, actualPlayer);
            newDraw = actAfterInput(playerMove.getPlayerMove(language));    // gets player input and checks if player wants to change language, restart game, get help or quit game,
                                                                            // if not, the method returns the player input
            if (newDraw.equals("Q")) {                             // if player wants to quit game while playing, the loop breaks here
                break;
            }
            while (!currentGame.setField(currentPlayer, newDraw))           // if newDraw is on an occupied space, setField returns false
            {
                text.printError(language);
                text.printTurn(language, actualPlayer);
                newDraw = actAfterInput(playerMove.getPlayerMove(language));
            }
            gameBoard.printBoard(currentGame.getField());               // prints current game board
            isPlayerX = !isPlayerX;                                     // changes player for the next
            if (isWin(currentGame.getField()))                          // checks if game is won
            {
                text.printWin(language, actualPlayer);
                newDraw = playerMove.getPlayerMove(language);
                endOrPlayAgain(newDraw);
            }
            if (isDraw(currentGame.getField()))                         // checks if game is a draw
            {
                text.printTie(language);
                newDraw = playerMove.getPlayerMove(language);
                endOrPlayAgain(newDraw);
            }


        }

    }

    /**
     * The actAfterInput method checks if the player wants to change the language, restart the game, get help or quit the game.
     * If the player wants to change the language, the language is changed and the method is called again.
     * if neigher of the above is true, the method returns the player input.
     *
     * @param playerInput  the input of the player
     * @param language     0 = English, 1 = German
     * @param ENGLISH      0 = English
     * @param GERMAN       1 = German
     * @param actualPlayer Tells the method printTurn which player is playing
     * @return player input if it was a new draw
     */


    public String actAfterInput(String playerInput) {
        while (playerInput.equals("L") || playerInput.equals("R") || playerInput.equals("Q") || playerInput.equals("H")) {
            if (playerInput.equals("L")) {
                if (language == ENGLISH) {
                    language = GERMAN;
                } else {
                    language = ENGLISH;
                }
                /**
                 * After changing the language, the game continues with the new language.
                 */
                text.printTurn(language, actualPlayer);
                playerInput = actAfterInput((playerMove.getPlayerMove(language)));


            }
            if (playerInput.equals("R")) { // restarts game
                start();
            }

            if (playerInput.equals("Q")) {
                endGame();
            }

            if (playerInput.equals("H")) { // prints help
                text.printHelp(language);

                text.printTurn(language, actualPlayer);

                gameBoard.printBoard(currentGame.getField());
                playerInput = actAfterInput((playerMove.getPlayerMove(language)));
            } else {
                break;
            }
        }

        return playerInput; // returns player input if it was a new draw


    }

    /**
     * When the game is over by a win or draw situation, the player has to choose whether to end the game or play again.
     * If the player wants to end the game, the endGame method is called.
     * If the player wants to play again, the start method is called.
     * If the player inputs anything else, the method is called again until the player inputs Q or R.
     * In this part, the player can't change the language.
     * @param playerInput the input of the player
     * @param language 0 = English, 1 = German
     * 
     */
    public void endOrPlayAgain(String playerInput) {
        if (playerInput.equals("Q")) {
            endGame();
        } else if (playerInput.equals("R")) {
            start();
        } else {
            text.printError(language);
            endOrPlayAgain(playerMove.getPlayerMove(language)); // if player input is not Q or R, the method is called again until the player inputs Q or R
        }
    }

    /**
     * This method checks if the game is won by comparing the current game field with all possible win combinations.
     * As for the win combinations, there are 8 possible ways to win, 3 horizontal, 3 vertical and 2 diagonal.
     * Because it could be eighter X or O, there are 16 win combinations.
     *
     * @param currentGame the current game field 
     * @param CounterWin  counts how many X/O match with each win combination, if 3, the game is won, 
     * if not, the counter is reset for the next win combination
     * @param winCombinations 16 possible win combinations, 1 stands for X, 2 for O, 8 for any value thats irrelevant for the win
     * @param row         the row of the win combination
     * @param column      the column of the win combination
     * @return true if the game is won, false if not
     */
    public boolean isWin(int[] currentGame) {
        int CounterWin = 0; // Counter of how many X/O match with each win combination
        int[][] winCombinations =              // 1 stands for X, 2 for O, 8 for any value thats irrelevant for the win
                {
                        {1, 1, 1, 8, 8, 8, 8, 8, 8},
                        {8, 8, 8, 8, 8, 8, 1, 1, 1},
                        {8, 8, 8, 1, 1, 1, 8, 8, 8},
                        {1, 8, 8, 1, 8, 8, 1, 8, 8},
                        {8, 1, 8, 8, 1, 8, 8, 1, 8},
                        {8, 8, 1, 8, 8, 1, 8, 8, 1},
                        {1, 8, 8, 8, 1, 8, 8, 8, 1},
                        {8, 8, 1, 8, 1, 8, 1, 8, 8},
                        {2, 2, 2, 8, 8, 8, 8, 8, 8},
                        {8, 8, 8, 8, 8, 8, 2, 2, 2},
                        {8, 8, 8, 2, 2, 2, 8, 8, 8},
                        {2, 8, 8, 2, 8, 8, 2, 8, 8},
                        {8, 2, 8, 8, 2, 8, 8, 2, 8},
                        {8, 8, 2, 8, 8, 2, 8, 8, 2},
                        {2, 8, 8, 8, 2, 8, 8, 8, 2},
                        {8, 8, 2, 8, 2, 8, 2, 8, 8},
                };

        for (int row = 0; row < winCombinations.length; row++) {
            for (int column = 0; column < winCombinations[row].length; column++) {
                if (winCombinations[row][column] == currentGame[column]) // Checks if win combination matches with current game
                {
                    CounterWin++;
                    if (CounterWin == 3) { // If 3 X/O match with a win combination, the game is won
                        return true;
                    }
                }
            }
            CounterWin = 0; // Resets CounterWin for next win combination
        }
        return false;
    }

    /**
     * This method checks if the game is a draw by checking if there are any empty spaces left.
     *
     * @param currentGame the current game field
     * @param value       the value of each space in the array game field, 0 = empty, 1 = X, 2 = O
     * @return true if the game is a draw, false if not
     */
    public boolean isDraw(int[] currentGame) {

        for (int value : currentGame) { // Checks if there are any empty spaces left
            if (value == 0) {
                return false;
            }
        }
        return true;

    }

    /**
     * This method prints a firendly message after the player decides to end the game.
     * @param delay the delay between each character
     * @param text the text to print
     */
    public void endGame() {
        int delay = 5;
        printWithDelay("----------------------------------------------------------------", delay);
        printWithDelay("Thank you for enjoying our game! Please donate for more updates!", delay);
        printWithDelay("And have a happy Halloween!", delay);
        printWithDelay("             ___", delay);
        printWithDelay("        ___)__|_", delay);
        printWithDelay("   .-*'          '*-,", delay);
        printWithDelay("  /      /|   |\\      \\", delay);
        printWithDelay(" ;      /_|   |_\\      ;", delay);
        printWithDelay(" ;   |\\           /|   ;", delay);
        printWithDelay(" ;   | ''--...--'' |   ;", delay);
        printWithDelay("  \\ ''---.....--''  /", delay);
        printWithDelay("   ''*-.,_______,.-*'", delay);
        printWithDelay("----------------------------------------------------------------", delay);
        printWithDelay("And by the way, if you don't donate, you might get a virus on your PC!", delay);
        printWithDelay("Just 1$ a day can keep the viruses away!", delay);
        printWithDelay("You can get a lifetime subscription for just 100$ if you subscribe right now!", delay);
        printWithDelay("The subscription includes:", delay);
        printWithDelay(" - No more viruses", delay);
        printWithDelay(" - No more ads", delay);
        printWithDelay(" - No more annoying popups", delay);
        printWithDelay(" - No more annoying updates", delay);
        printWithDelay(" - No more annoying notifications", delay);
        printWithDelay(" - No more annoying people", delay);
        printWithDelay(" - No more annoying games", delay);
        printWithDelay(" - No more annoying anything", delay);
        printWithDelay(" - No more annoying", delay);
        printWithDelay(" - No more", delay);
        printWithDelay(" - Yeahhhhh, no more", delay);
        printWithDelay(" - No", delay);
        printWithDelay(" - No", delay);
        printWithDelay(" - No", delay);
        printWithDelay("And much more!", delay);
        printWithDelay("You can send your donation to:", delay);
        printWithDelay(" <3 1234 5678 9012 3456", delay);
        printWithDelay("Send the money, and get the gift of a lifetime!", delay);
        printWithDelay("                      _..-'(                          )`-.._", delay);
        printWithDelay("                   ./'. '||\\.       (\\_//)       .//||` .`\\.", delay);
        printWithDelay("                ./'.|'.'||||\\\\|..   )O O(    ..|//||||`.`|.`\\.", delay);
        printWithDelay("             ./'..|'.|| |||||\\`````` '`\"'` ''''''/||||| ||.`|..`\\.", delay);
        printWithDelay("           ./'.||'.|||| ||||||||||||.      .|||||||||||| |||||.`||.`\\.", delay);
        printWithDelay("          /'|||'.|||||| ||||||||||||{      }|||||||||||| ||||||.`|||`\\", delay);
        printWithDelay("         '.|||'.||||||| ||||||||||||{      }|||||||||||| |||||||.`|||.`", delay);
        printWithDelay("        '.||| ||||||||| |/'   ``\\||``     ''||/''   `\\| ||||||||| |||.`", delay);
        printWithDelay("        |/' \\./'     `\\./         \\!|\\   /|!/         \\./'     `\\./ `\\|", delay);
        printWithDelay("        V    V         V          }' `\\ /' `{          V         V    V", delay);
        printWithDelay("        `    `         `               V                '         '    '", delay);
    }
    /**
     * This method helps to print with a delay
     * @param text the text to print
     * @param delay the delay between each character
     * @param c the character to print
     * @param e the exception
     */
    
    public static void printWithDelay(String text, int delay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(); // Move to the next line after printing the entire text.
    }

}
