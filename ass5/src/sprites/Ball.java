// ID: 208387969

package sprites;

import biuoop.DrawSurface;
import gamehelper.CollisionInfo;
import gamehelper.GameLevel;
import gamehelper.GameEnvironment;
import geometry.Line;
import geometry.Point;
import geometry.Velocity;
import interfaces.Collidable;
import interfaces.Sprite;

import java.awt.Color;

/**
 * sprites.Ball - The class draw balls on the DrawSurface.
 * <p>
 * Each ball have size (radius), color, and location (a geometry.Point).
 */
public class Ball implements Sprite {
    // Characteristics
    // Const number of the size of the board
    public static final int SIZE_OF_BOARD_X = 1000;
    public static final int SIZE_OF_BOARD_Y = 1000;
    // Const number for the X and the Y values of the start point of the board
    public static final int BOARD_START_X = 0;
    public static final int BOARD_START_Y = 0;

    private Point center;
    private int radius;
    private Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * constructor with configurable of center point, radius and color of the ball.
     *
     * @param center - The center point of the ball.
     * @param r      - The radius of the ball.
     * @param color  - Color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.gameEnvironment = new GameEnvironment();
    }

    /**
     * constructor with configurable of X and Y values of the center point, radius and color of the ball.
     *
     * @param x     - The X value of the center point of the ball.
     * @param y     - The Y value of the center point of the ball.
     * @param r     -  The radius of the ball.
     * @param color - Color of the ball.
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this(new Point(x, y), r, color);
    }

    // accessors

    /**
     * getX - Return the X value of the center point.
     *
     * @return X value of the center point.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * getY - Return the Y value of the center point.
     *
     * @return Y value of the center point.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * getSize - Return the radius of the ball.
     *
     * @return Radius of the ball.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * getGameEnvironment - Return the game environment of the ball.
     *
     * @return gamehelper.Game environment of the ball.
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * getColor - Return the color of the ball.
     *
     * @return Color of the ball.
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
        // Draw the ball
        surface.fillCircle((int) center.getX(), (int) center.getY(), radius);
        surface.setColor(Color.LIGHT_GRAY);
        surface.drawCircle((int) center.getX(), (int) center.getY(), radius);
    }

    /**
     * timePassed - notify that time has passed.
     */
    public void timePassed() {
        moveOneStep();
    }

    /**
     * setVelocity - set the velocity of the ball.
     *
     * @param v - The velocity.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * setVelocity - set the velocity of the ball.
     *
     * @param dx - The change in the position on the `X` axes.
     * @param dy - The change in the position on the `Y` axes.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * setVelocity - Get the velocity of the ball.
     *
     * @return geometry.Velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * moveOneStepHelper - Apply the ball location on the board after the change in the position on the X and Y axes.
     * The function checks that the ball is in the screen.
     * In case that the change in the X and Y axis cause the ball to exit the screen boundaries:
     * The function will change the direction of the ball so that it stays inside the screen.
     *
     * @param xStart - The X value of the starting point of the board.
     * @param yStart - The Y value of the starting point of the board.
     * @param xEnd   - The X value of the end point of the board.
     * @param yEnd   - The Y value of the end point of the board.
     */
    public void moveOneStepHelper(int xStart, int yStart, int xEnd, int yEnd) {
        // If the velocity is null - put 0 as dx and dy
        if (velocity == null) {
            this.velocity = new Velocity(0, 0);
        }
        for (int i = 0; i < 4; i++) {
            // Temp variable that save the current "center" point with the velocity change
            Point pointVelocity = this.getVelocity().applyToPoint(this.center);
            // Trajectory - line starting at the current location, and ending where the velocity will take the ball
            // if no collisions will occur.
            Line trajectory = new Line(this.center, pointVelocity);
            // The collisionInfo
            CollisionInfo collisionInfo = gameEnvironment.getClosestCollision(trajectory);
            // Check (using the game environment) if moving on this trajectory will hit anything
            if (collisionInfo != null) {
                // The point in the collision
                Point point = collisionInfo.collisionPoint();
                // The collidable object
                Collidable collidable = collisionInfo.collisionObject();
                // New velocity
                this.velocity = collidable.hit(this, point, this.velocity);
            } else {
                break;
            }
        }
        // Updating the location of the center of the ball
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * moveOneStep - Apply the ball location on the board after the change in the position on the X and Y axes.
     * The function use the "moveOneStep" function and send her the starting point and the end point of the board.
     */
    public void moveOneStep() {
        // Call the "moveOneStep" function
        moveOneStepHelper(BOARD_START_X, BOARD_START_Y, SIZE_OF_BOARD_X, SIZE_OF_BOARD_Y);
    }

    /**
     * addToGame - Let each of the game objects know how they should be added to the game.
     * (adding the ball to the game)
     *
     * @param gameObject - game objects.
     */
    public void addToGame(GameLevel gameObject) {
        // Adding the block to the interfaces.Sprite list
        gameObject.addSprite(this);
    }

    /**
     * setGame - Set the game environment.
     *
     * @param environmentGame - The game environment.
     */
    public void setGame(GameEnvironment environmentGame) {
        this.gameEnvironment = environmentGame;
    }

    /**
     * removeSprite - Remove a ball from a game "game" (that we get).
     *
     * @param game - The game that we wont to remove from him the ball.
     */
    public void removeFromGame(GameLevel game) {
        // Remove the ball from the interfaces.Sprite list
        game.removeSprite(this);
    }
}
