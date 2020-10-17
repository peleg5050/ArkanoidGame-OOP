// ID: 208387969

import gamehelper.Game;

/**
 * Ass3Game - The class run the game by a main method.
 */
public class Ass3Game {
    /**
     * main - Run the game.
     *
     * @param args - String that we get.
     */
    public static void main(String[] args) {
        // Call the game
        Game game = new Game();
        // Initialize the game
        game.initialize();
        // Run the game
        game.run();
    }
}
