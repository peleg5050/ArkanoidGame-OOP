// ID: 208387969

package gamehelper;

import biuoop.DrawSurface;
import biuoop.Sleeper;
import interfaces.Animation;

/**
 * gamehelper.CountdownAnimation - The class , CountdownAnimation , will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show a countdown from countFrom back to 1,where each number
 * will appear on the screen for (numOfSeconds / countFrom) seconds, before it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    // Characteristics
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private int remainingTime;
    private boolean isFirstTime;

    /**
     * constructor with configurable of the KeyboardSensor.
     *
     * @param numOfSeconds - how many time each number will appear on the screen - (numOfSeconds / countFrom) seconds.
     * @param countFrom    - a countdown from 3 back to 1.
     * @param gameScreen   - the sprites.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.remainingTime = countFrom;
        this.gameScreen = gameScreen;
        this.isFirstTime = true;
    }

    /**
     * doOneFrame - show a countdown from 3 back to 1,where each number will appear on the screen for
     * (numOfSeconds / countFrom) seconds, before it is replaced with the next one.
     *
     * @param draw - the draw surface.
     */
    public void doOneFrame(DrawSurface draw) {
        // draw on the game screen
        this.gameScreen.drawAllOn(draw);
        // draw the countdown at the middle of the screen
        draw.drawText(draw.getWidth() / 2 - 25, draw.getHeight() / 2, "" + this.remainingTime, 120);
        // let us know were the count is finished
        remainingTime = remainingTime - 1;
        // help us to avoid from the sleep at the start
        if (isFirstTime) {
            this.isFirstTime = false;
            return;
        }
        Sleeper sleeper = new Sleeper();
        sleeper.sleepFor((long) ((numOfSeconds / countFrom) * 1000));
    }

    /**
     * shouldStop - let us know when the countdown is finished.
     *
     * @return false if the game is continue, true otherwise (if the countdown has finished).
     */
    public boolean shouldStop() {
        // if it's the first time of the countdown (so shouldStop will return false)
        if (remainingTime >= 0) {
            return false;
        }
        // if the countdown has finished (not the first time) (so shouldStop will return true)
        return true;
    }
}
