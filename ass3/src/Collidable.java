// ID: 208387969

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
     * @param collisionPoint  - The collision point of the shape.
     * @param currentVelocity - The current velocity.
     * @return New velocity expected after the hit.
     */
    Velocity hit(Point collisionPoint, Velocity currentVelocity);
}
