// ID: 208387969

package interfaces;

import biuoop.DrawSurface;

/**
 * interfaces.Sprite - The interface sprites can be drawn on the screen, and can be notified that time has passed
 * (so that they know to change their position / shape / appearance / etc).
 * In our design, all of the game objects as: sprites.Ball, sprites.Block, sprites.Paddle, ... are Sprites
 * so they will implement
 * the interfaces.Sprite interface
 */
public interface Sprite {
    /**
     * drawOn - Draw the sprite to the screen.
     *
     * @param draw - The draw.
     */
    void drawOn(DrawSurface draw);

    /**
     * timePassed - notify that time has passed.
     */
    void timePassed();
}
