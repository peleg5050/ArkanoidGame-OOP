// ID: 208387969


package gamehelper;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/**
 * gamehelper.ScoreIndicator - The class hold a reference to the scores counter, and will be added to the game as
 * a sprite positioned at the top of the screen.
 */
public class ScoreIndicator implements Sprite {
    private Counter counterScore;

    /**
     * constructor with configurable of the gamehelper.Counter score.
     *
     * @param currentScore - The current score.
     */
    public ScoreIndicator(Counter currentScore) {
        this.counterScore = currentScore;
    }

    /**
     * drawOn - Draw the sprite to the screen.
     *
     * @param surface - The draw.
     */
    public void drawOn(DrawSurface surface) {
        // Set the color
        surface.setColor(Color.white);
        // Draw the Score: on the top
        surface.drawText(370, 15, "Score: " + counterScore.getValue(), 15);
    }

    /**
     * timePassed - notify that time has passed.
     */
    public void timePassed() {
    }
}
