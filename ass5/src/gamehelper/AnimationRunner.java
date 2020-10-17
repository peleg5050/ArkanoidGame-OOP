// ID: 208387969

package gamehelper;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import interfaces.Animation;


/**
 * gamehelper.AnimationRunner - The class - AnimationRunner - takes an interfaces.Animation object and runs it',
 * so we can implement the task-specific information in the interfaces. Animation object, and run it using
 * the loop in the AnimationRunner class.
 */
public class AnimationRunner {

    // Characteristics
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * Constructor that create a gui, sleeper and set the framesPerSecond.
     *
     * @param gui - the gui.
     */
    public AnimationRunner(GUI gui) {
        // How many frames per seconds pass (60)
        this.framesPerSecond = 60;
        // Create a window with the title "gamehelper.AnimationRunner"
        // which is 800 pixels wide and 600 pixels high
        this.gui = gui;
        this.sleeper = new Sleeper();
    }

    /**
     * run - run the game.
     *
     * @param animation - .
     */
    public void run(Animation animation) {
        // How many milliseconds Per Frame pass (1000)
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            // timing
            long startTime = System.currentTimeMillis();
            DrawSurface draw = gui.getDrawSurface();
            animation.doOneFrame(draw);
            gui.show(draw);
            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
