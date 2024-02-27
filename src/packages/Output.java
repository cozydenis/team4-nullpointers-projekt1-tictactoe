package packages;

/**
 * The output class is called to print the game board and the various messages intended for the players
 */
public class Output {
    public String[][] messages = {{"--------------- Welcome to Tic Tac Toe ---------------\nTo start the game the first player 'X' enters the desired coordinates in the following fashion: A1,C3,B2 etc.\nRestart 'R'\nQuit 'Q'\nChange language to German 'L' \nHelp 'H' ", "Your turn player ", "To start the game the first player 'X' enters the desired coordinates in the following fashion: A1,C3,B2 etc.\nRestart 'R'\nQuit 'Q'\nChange language to German 'L' ", "invalid input. Try again", " WINS!!!\nPress 'R' to start a new game or 'Q' to quit: ", "its a tie\nPress 'R' to start a new game or 'Q' to quit: "},
                                  {"---------------Wilkommen zu Tic Tac Toe---------------\nUm das Spiel zu starten, gibt der erste Spieler 'X' die gewünschten Koordinaten wie folgt ein: A1, C3, B2, usw.\nNeustart 'R'\nBeenden 'Q'\nSprache auf Englisch ändern 'L' ", "Du bist dran, Spieler ", "Um das Spiel zu starten, gibt der erste Spieler 'X' die gewünschten Koordinaten wie folgt ein: A1, C3, B2, usw.\nNeustart 'R'\nBeenden 'Q'\nSprache auf Englisch ändern 'L' ", "Ungültige Eingabe. Versuchen Sie es erneut.", " hat gewonnen!\nNoch einmal spielen?\nNeustart 'R\nBeenden 'Q'", "Es ist ein Unentschieden\nNoch einmal spielen?\nNeustart 'R\nBeenden 'Q'"}};

    public Output() {
    }

    /**
     * The following methods print the various messages stored in the 2D array above
     *
     * @param language indicates what language(row) is acessed in the array
     */
    public void printWelcome(int language) {
        System.out.println(messages[language][0]);
    }

    public void printDashes() {
        System.out.println("-----------------------------------------------------------------");
    }

    public void printHelp(int language) {
        printDashes();
        System.out.println(messages[language][2]);
        printDashes();
    }

    public void printError(int language) {
        System.out.println(messages[language][3]);
    }

    /**
     * prints the turn order
     *
     * @param language current language
     * @param player   current player
     */
    public void printTurn(int language, String player) {
        System.out.print(messages[language][1] + player + ": ");
    }

    public void printWin(int language, String player) {
        if (language == 0) {
            System.out.println("Player  " + player + messages[language][4]);
        } else {
            System.out.println("Spieler " + player + messages[language][4]);
        }
    }

    public void printTie(int language) {
        System.out.println(messages[language][5]);
    }

    /**
     * Recives the game board and prints it to the user
     *
     * @param board an int array representing the game board
     */
    public void printBoard(int[] board) {
        System.out.println("\n" + "    A   B   C\n " +
                "  ___________\n" +
                "  |   |   |   |\n" +
                "1 | " + decode(board[0]) + " | " + decode(board[1]) + " | " + decode(board[2]) + " |  \n" +
                "  |---|---|---|\n" +
                "2 | " + decode(board[3]) + " | " + decode(board[4]) + " | " + decode(board[5]) + " |  \n" +
                "  |---|---|---|\n" +
                "3 | " + decode(board[6]) + " | " + decode(board[7]) + " | " + decode(board[8]) + " |  \n" +
                "  |___|___|___|\n" +
                "");
    }

    /**
     * decodes the value of the board into the corresponding symbols
     *
     * @param x the value in the array
     * @return the symbol X O or a blank space
     */
    public String decode(int x) {
        if (x == 2) {
            return "O";
        } else if (x == 1) {
            return "X";
        } else {
            return " ";
        }
    }
}
