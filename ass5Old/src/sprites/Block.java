// ID: 208387969

package sprites;


import biuoop.DrawSurface;
import gamehelper.Game;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.Collidable;
import interfaces.HitListener;
import interfaces.HitNotifier;
import interfaces.Sprite;
import sprites.Ball;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * sprites.Block - The "block" signifies something that the ball can be collide into.
 * The block can be in the middle of the screen, or a block in the edge of the screen.
 * If the ball hits a vertical edge of the block, the horizontal direction should change,
 * and if the ball hits an horizontal edge of the block, the vertical direction should change.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    // Const number (We will use Epsilon to correct the deflection)
    public static final double EPSILON = Math.pow(10, -10);

    // Characteristics
    private Rectangle rectangle;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * constructor with configurable of rectangle and color.
     *
     * @param rectangle -  A shape of rectangle.
     * @param color     The color of the rectangle.
     */
    public Block(Rectangle rectangle, java.awt.Color color) {
        this.rectangle = rectangle;
        this.color = color;
        // Create a list of the hitListeners
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * getColor - Return the color of the rectangle.
     *
     * @return Color of the rectangle.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * drawOn - Draw the sprite to the screen.
     *
     * @param surface - The draw.
     */
    public void drawOn(DrawSurface surface) {
        // Set the color (to be the color we got)
        surface.setColor(getColor());
        // Draw the rectangle
        surface.fillRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
        surface.setColor(Color.LIGHT_GRAY);
        surface.drawRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    /**
     * timePassed - notify the sprite that time has passed.
     */
    public void timePassed() {
    }

    /**
     * getCollisionRectangle - Return the "collision shape" of the object.
     *
     * @return "collision shape" of the object.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * notifyHit -  called whenever a hit() occurs, and notifiers all of the registered interfaces.HitListener objects by
     * calling their hitEvent method.
     *
     * @param hitter - The ball that's doing the hitting (The hitter parameter).
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * hit - Return the new velocity expected after the hit (based on the force the object inflicted on us).
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param collisionPoint  - The collision point of the shape.
     * @param currentVelocity - The current velocity.
     * @return New velocity expected after the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // The dx and dy of the current velocity
        double currentVelocityDx = currentVelocity.getDx();
        double currentVelocityDy = currentVelocity.getDy();
        // if the collision point is on the upper rib of the rectangle
        if ((Math.abs(this.rectangle.getUpperLeft().getY() - collisionPoint.getY()) <= EPSILON)) {
            // Changes the direction of progress along the Y axis
            currentVelocityDy = -1 * currentVelocityDy;
            // Set the new velocity
            currentVelocity.setDy(currentVelocityDy);
            // if the collision point is on the upper rib or on the lower rib of the rectangle
        } else if (Math.abs(this.rectangle.getLowerLeft().getY() - collisionPoint.getY()) <= EPSILON) {
            // Changes the direction of progress along the Y axis
            currentVelocityDy = -1 * currentVelocityDy;
            // Set the new velocity
            currentVelocity.setDy(currentVelocityDy);
        }
        // if the collision point is on the left rib or on the right rib of the rectangle
        if ((Math.abs(collisionPoint.getX() - this.rectangle.getUpperLeft().getX()) <= EPSILON)
                || (Math.abs(collisionPoint.getX() - this.rectangle.getUpperRight().getX()) <= EPSILON)) {
            // Changes the direction of progress along the X axis
            currentVelocityDx = currentVelocityDx * -1;
            // Set the new velocity
            currentVelocity.setDx(currentVelocityDx);
        }
        // call notifyHit
        this.notifyHit(hitter);
        // Return the new velocity expected after the hit
        return currentVelocity;

    }

    /**
     * addToGame - Let each of the game objects know how they should be added to the game
     * (adding the block to the game).
     *
     * @param gameObject - game objects (sprites and the collidables).
     */
    public void addToGame(Game gameObject) {
        // Adding the block to the interfaces.Collidable list
        gameObject.addCollidable(this);
        // Adding the block to the interfaces.Sprite list
        gameObject.addSprite(this);
    }

    /**
     * removeSprite - Remove a block b from a game "game" (that we get).
     *
     * @param game - The game that we wont to remove from him the block.
     */
    public void removeFromGame(Game game) {
        // Remove the block from the interfaces.Collidable list
        game.removeCollidable(this);
        // Remove the block from the interfaces.Sprite list
        game.removeSprite(this);
    }

    /**
     * addHitListener - Add hitListen as a listener to hit events.
     *
     * @param hitListen - the hitListener that we want to add to the hitListeners list.
     */
    public void addHitListener(HitListener hitListen) {
        // Add the hitListener to the hitListeners list.
        hitListeners.add(hitListen);
    }

    /**
     * removeHitListener - Remove hitListen from the list of listeners to hit events.
     *
     * @param hitListen - the hitListener that we want to remove from the hitListeners list.
     */
    public void removeHitListener(HitListener hitListen) {
        // Remove the hitListener from the hitListeners list.
        hitListeners.remove(hitListen);
    }
}

