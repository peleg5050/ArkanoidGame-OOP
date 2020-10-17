// ID: 208387969

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * gamehelper.SpriteCollection - The class will hold a collection of sprites.
 * The gamehelper.SpriteCollection class supports the addition of new sprites
 * interfaces.Sprite is a game object that can be drawn to the screen, and can be notified that time has passed
 * (so that they know to change their position / shape / appearance / etc).
 * All of the game objects (sprites.Ball, sprites.Block, sprites.Paddle, ...) are Sprites -- they will implement the interfaces.Sprite interface
 */
public class SpriteCollection {
    // Characteristics
    // List of the Sprites (things that can be collided with as sprites.Ball, sprites.Block, sprites.Paddle, ...)
    private List<Sprite> sprites;

    /**
     * constructor with configurable of list of the sprite
     * (objects that can be drawn to the screen and notified that time has passed).
     */
    public SpriteCollection() {
        // Create a list of the sprites (object that can be drawn to the screen and notified that time has passed)
        this.sprites = new ArrayList<Sprite>();
    }

    /**
     * addSprite - Add the given sprite (object that can be drawn to the screen) to the list of the sprites.
     *
     * @param sprite - The sprite object that we want to add to the list of the sprites.
     */
    public void addSprite(Sprite sprite) {
        // Add the sprite object to the List of the sprite
        sprites.add(sprite);
    }

    /**
     * notifyAllTimePassed - Call timePassed() on all sprites from the list of the sprites.
     */
    public void notifyAllTimePassed() {
        // For that run on all the sprites
        for (Sprite currentSprite : sprites) {
            // Call timePassed() for each sprite
            currentSprite.timePassed();
        }
    }

    /**
     * drawAllOn - Call drawOn() on all sprites from the list of the sprites.
     *
     * @param draw - The draw
     */
    public void drawAllOn(DrawSurface draw) {
        // For that run on all the sprites
        for (Sprite currentSprite : sprites) {
            // Call drawOn() for each sprite
            currentSprite.drawOn(draw);
        }
    }
}
