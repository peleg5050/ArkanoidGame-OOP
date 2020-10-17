// ID: 208387969

package gamehelper;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import interfaces.Collidable;

import java.util.ArrayList;
import java.util.List;

/**
 * gamehelper.GameEnvironment - The class will be a collection of objects that the sprites.Ball can be collide with.
 * The class adds the given collidable to the environment.
 * If the object will collide with any of the collidables, the class will return the information
 * about the closest collision that is going to occur.
 * If the object will not collide with any of the collidables,  return null.
 * The ball will know the game environment, and will use it to check for collisions and direct its movement.
 */
public class GameEnvironment {
    // Characteristics
    // List of the collidables (things that can be collided with) in the environment
    private List<Collidable> collidables;

    /**
     * constructor with configurable of list of the collidables (things that can be collided with) in the environment.
     */
    public GameEnvironment() {
        // Create a list of the collidables (things that can be collided with) in the environment
        this.collidables = new ArrayList<Collidable>();
    }

    /**
     * addCollidable - Add the given collidable to the environment.
     *
     * @param collide - The collide object that we want to add to the environment.
     */
    public void addCollidable(Collidable collide) {
        // Add the collidable object to the List of the collidables (to the environment)
        collidables.add(collide);
    }

    /**
     * removeCollide - Remove the given collidable from the environment.
     *
     * @param collide - The collide object that we want to remove from the environment.
     */
    public void removeCollide(Collidable collide) {
        // Remove the collidable object from the List of the collidables
        collidables.remove(collide);
    }

    /**
     * getClosestCollision - Return the information about the closest collision that is going to occur.
     * If this object will not collide with any of the collidables in this collection, return null.
     *
     * @param trajectory - The line of the object movement.
     * @return The information about the closest collision, and null if this object will not collide
     * with any of the collidables.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        // The point of the current collision that is going to occur (closest intersection with the current rectangle)
        Point tempPoint = null;
        // The distance of the closest collision that is going to occur
        // The -1 value gives information if we insert point to the closest point at the first time
        // (turn into the new distance after the first time)
        double minCollisionDistance = -1;
        // Distance of each collision that is going to occur
        double tempDistance;
        // The point of the closest collision that is going to occur
        Point closestPoint = null;
        Collidable minCollidable = null;
        CollisionInfo collisionInfo;
        // Current rectangle
        Rectangle currentRectangle;
        // Make a copy of the collidables before iterating over them.
        List<Collidable> collidablesCopy = new ArrayList<Collidable>(this.collidables);
        // Traverse the elements - collidables - in the list using a for
        for (Collidable currentCollide : collidablesCopy) {
            // Current rectangle (turn the current collide into current rectangle)
            currentRectangle = currentCollide.getCollisionRectangle();
            //the current collision point (the closest intersection point to start of the line from all the
            // The point of the current collision
            tempPoint = trajectory.closestIntersectionToStartOfLine(currentRectangle);
            // If this current rectangle have collision point
            if (tempPoint != null) {
                // Distance of the current collision
                tempDistance = tempPoint.distance(trajectory.start());
                // If we didn't insert point to the closest point (if it's the first time)
                if (minCollisionDistance == -1) {
                    // Save the minimum collidable
                    minCollidable = currentCollide;
                    // Change the point of the closest collision to be the point of the current collision
                    closestPoint = tempPoint;
                    // Change at the first time the minimum distance (value -1) to the value of the distance of the
                    // current collision so we will know at the next collide that it's not the first time
                    minCollisionDistance = tempDistance;
                }
                // If we already insert point to the closest point and the if the distance of the current
                // collision is smaller than the minimum distance
                if (tempDistance < minCollisionDistance) {
                    // Save the minimum collidable
                    minCollidable = currentCollide;
                    // Save the closest point as the point of the current collision
                    closestPoint = tempPoint;
                    // Change the minimum distance to the distance of the current collision
                    minCollisionDistance = tempDistance;
                }
            }
        }
        // If this object will not collide with any of the collidables in this collection, return null
        // (if the minimum collision point is still -1 it means that we didn't insert point to the closest point)
        if (minCollisionDistance == -1) {
            return null;
        }
        // "collisionInfo" is an information about the closest collision that is going to occur.
        collisionInfo = new CollisionInfo(closestPoint, minCollidable);
        return collisionInfo;
    }
}
