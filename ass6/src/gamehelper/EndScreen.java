// ID: 208387969

package gamehelper;
import biuoop.DrawSurface;
import biuoop.GUI;
import interfaces.Animation;
import java.awt.Color;

/**
 * gamehelper.EndScreen - The class display the final score once the game is over
 * (either the player died, or he managed to clear all the levels). If the game ended with the player dying
 * (i.e. all balls fall off the screen), the end screen should display the message "Game Over.
 * Your score is X" (X being the final score). If the game ended by clearing all the levels, the screen
 * should display "You Win! Your score is X".
 * The "end screen" should persist until the space key is pressed. After the space key is pressed,
 * your program should terminate.
 */
public class EndScreen implements Animation {
    // The width of the background block
    private static final int BACKGROUND_WIDTH = 800;
    // The height of the background block
    private static final int BACKGROUND_HEIGHT = 600;
    private boolean stop;
    private Counter score;
    private boolean isWin;
    private GUI gui;

    /**
     * constructor with configurable of the KeyboardSensor.
     *
     * @param score - the counter score (from the start till the play end).
     * @param isWin - indicate if the player win or lose the game.
     * @param gui   - the gui.
     */
    public EndScreen(Counter score, boolean isWin, GUI gui) {
        this.stop = false;
        this.score = score;
        this.isWin = isWin;
        this.gui = gui;
    }

    /**
     * doOneFrame - help to run the game (frame by frame).
     *
     * @param draw - the draw surface.
     */
    public void doOneFrame(DrawSurface draw) {
        draw.setColor(new Color(13, 73, 39));
        draw.fillRectangle(0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        // if the player is the winner
        if (isWin) {
            draw.setColor(Color.white);
            // Print "You Win!" massage with the score
            draw.drawText(145, draw.getHeight() / 2 - 100,
                    "You Win! Your score is " + score.getValue(), 35);
            // if the player is the loser
        } else {
            draw.setColor(Color.white);
            // Print "Game Over" massage with the score
            draw.drawText(145, draw.getHeight() / 2 - 100,
                    "Game Over. Your score is " + score.getValue(), 35);
        }
    }

    /**
     * shouldStop - return true if the game is continue, false otherwise.
     *
     * @return true if the game is continue, false otherwise.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
