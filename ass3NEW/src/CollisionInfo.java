// ID: 208387969


/**
 * gamehelper.CollisionInfo - The class return the point at which the collision occurs
 * and the collidable object involved in the collision.
 */
public class CollisionInfo {
    // Characteristics
    // The point at which the collision occurs
    private Point collidePoint;
    // The collidable object involved in the collision
    private Collidable collidableObject;

    /**
     * constructor with configurable of point (at which the collision occurs) and a collidable object
     * involved in the collision.
     *
     * @param collidePoint     - The point at which the collision occurs.
     * @param collidableObject - The collidable object involved in the collision.
     */
    public CollisionInfo(Point collidePoint, Collidable collidableObject) {
        // set the list of the collidables (things that can be collided with) in the environment
        this.collidePoint = collidePoint;
        this.collidableObject = collidableObject;
    }

    /**
     * collisionPoint - Return the point at which the collision occurs.
     *
     * @return geometry.Point at which the collision occurs.
     */
    // the point at which the collision occurs.
    public Point collisionPoint() {
        return this.collidePoint;
    }

    /**
     * collisionObject - Return the collidable object involved in the collision.
     *
     * @return interfaces.Collidable object involved in the collision.
     */
    // the collidable object involved in the collision.
    public Collidable collisionObject() {
        return this.collidableObject;
    }
}
