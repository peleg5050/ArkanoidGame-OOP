// ID: 208387969

package interfaces;

import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import sprites.Ball;

/**
 * interfaces.Collidable - The interface used by things that can be collided with (as Blocks and the sprites.Paddle).
 */
public interface Collidable {
    /**
     * getCollisionRectangle - Return the "collision shape" of the object.
     *
     * @return "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * hit - Return the new velocity expected after the hit (based on the force the object inflicted on us).
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param hitter          - The hitter object.
     * @param collisionPoint  - The collision point of the shape.
     * @param currentVelocity - The current velocity.
     * @return New velocity expected after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
