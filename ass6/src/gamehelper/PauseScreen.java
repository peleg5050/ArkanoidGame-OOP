// ID: 208387969

package gamehelper;
import biuoop.DrawSurface;
import interfaces.Animation;
import java.awt.Color;

/**
 * gamehelper.PauseScreen - The class adding an option to pause the game when pressing the 'p', and that will display
 * a screen with the message "paused -- press space to continue" until a key is pressed.
 * In the game, when we identify the key p being pressed, we start running the PauseScreen animation instead of the
 * Game one.
 * The Game animation will resume as soon as we will return from the PauseScreen animation.
 */
public class PauseScreen implements Animation {
    // The width of the background block
    private static final int BACKGROUND_WIDTH = 800;
    // The height of the background block
    private static final int BACKGROUND_HEIGHT = 600;
    private boolean stop;

    /**
     * constructor with configurable of the KeyboardSensor.
     */
    public PauseScreen() {
        this.stop = false;
    }

    /**
     * doOneFrame - help to run the game (frame by frame).
     * adding an option to pause the game when pressing the 'p', and that will display
     * a screen with the message "paused -- press space to continue" until a key is pressed.
     *
     * @param draw - the draw surface.
     */
    public void doOneFrame(DrawSurface draw) {
        draw.setColor(new Color(13, 73, 39));
        draw.fillRectangle(0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        draw.setColor(Color.white);
        draw.drawText(120, draw.getHeight() / 2 - 100, "paused -- press space to continue", 40);
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

