// ID: 208387969


package gamehelper;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/**
 * gamehelper.LevelIndicator - The class hold a reference to the level name, and will be added to the game as
 * a sprite positioned at the top of the screen.
 */
public class LevelIndicator implements Sprite {
    private String levelName;

    /**
     * constructor with configurable of the gamehelper.Counter score.
     *
     * @param levelName - The level name.
     */
    public LevelIndicator(String levelName) {
        this.levelName = levelName;
    }

    /**
     * drawOn - Draw the sprite to the screen.
     *
     * @param surface - The draw.
     */
    public void drawOn(DrawSurface surface) {
        // Set the color
        surface.setColor(Color.white);
        // Draw the name level on the top
        surface.drawText(620, 15, "Level Name: " + levelName, 15);
    }

    /**
     * timePassed - notify that time has passed.
     */
    public void timePassed() {
    }
}

