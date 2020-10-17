// ID: 208387969

package gamehelper;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;

/**
 * gamehelper.KeyPressStoppableAnimation - The class wrap an existing animation and add a "waiting-for-key" behavior
 * to it.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboard;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isPressed;

    /**
     * constructor with configurable of the KeyboardSensor.
     *
     * @param sensor    - the keyboard.
     * @param key       - .
     * @param animation - .
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isPressed = true;
    }

    /**
     * doOneFrame - help to run the game (frame by frame).
     *
     * @param draw - the draw surface.
     */
    public void doOneFrame(DrawSurface draw) {
        // If pressed on the space
        if ((!isPressed) && (keyboard.isPressed(key))) {
            this.stop = true;
        }
        if (!this.keyboard.isPressed(key)) {
            isPressed = false;
        }
        animation.doOneFrame(draw);
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
