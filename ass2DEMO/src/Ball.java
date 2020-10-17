// ID: 208387969

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * sprites.Ball - The class draw balls on the DrawSurface.
 *
 * Each ball have size (radius), color, and location (a geometry.Point).
 */
public class Ball {
    // Characteristics
    private Point center;
    private int radius;
    private Color color;
    private Velocity velocity;
    // Const number of the size of the board
    public static final int SIZE_OF_BOARD_X = 200;
    public static final int SIZE_OF_BOARD_Y = 200;
    // Const number for the X and the Y values of the start point of the board
    public static final int BOARD_START_X = 0;
    public static final int BOARD_START_Y = 0;

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
     * getColor - Return the color of the ball.
     *
     * @return Color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * drawOn - Draw the ball on the given DrawSurface.
     *
     * @param surface - The draw.
     */
    public void drawOn(DrawSurface surface) {
        // Set the color (to be the color we got)
        surface.setColor(getColor());
        // Draw the ball
        surface.fillCircle((int) center.getX(), (int) center.getY(), radius);
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
        // Temp variable that save the current "center" point with the velocity change
        Point tempCenter = this.getVelocity().applyToPoint(this.center);
        // Tests that check if the whole ball is on the board:
        //
        // Tests if the ball exits the board in terms of the X and Y axis
        // Tests if the ball exits the board from: top - right \ top - left \ bottom - right \ bottom - left
        if (((tempCenter.getX() + radius >= xEnd) && (tempCenter.getY() - radius <= yStart))
                || ((tempCenter.getX() - radius <= xStart) && (tempCenter.getY() - radius <= yStart))
                || ((tempCenter.getX() + radius >= xEnd) && (tempCenter.getY() + radius >= yEnd))
                || ((tempCenter.getX() - radius <= xStart) && (tempCenter.getY() + radius >= yEnd))) {
            // Changes the direction of progress along the X axis and the Y axis
            setVelocity(((this.velocity.getDx()) * -1), (this.velocity.getDy() * -1));
        // Tests if the ball exits the board in terms of the X axis (from the right side of the screen)
        } else if (tempCenter.getX() + radius >= xEnd) {
            // Changes the direction of progress along the X axis
            setVelocity(((this.velocity.getDx()) * -1), this.velocity.getDy());
        // Tests if the ball exits the board in terms of the Y axis (from the bottom of the screen)
        } else if (tempCenter.getY() + radius >= yEnd) {
            // Changes the direction of progress along the Y axis
            setVelocity(this.velocity.getDx(), (this.velocity.getDy() * -1));
        // Tests if the ball exits the board in terms of the X axis (from the left side of the screen)
        } else if (tempCenter.getX() - radius <= xStart) {
            // Changes the direction of progress along the X axis
            setVelocity(((this.velocity.getDx()) * -1), this.velocity.getDy());
        // Tests if the ball exits the board in terms of the Y axis (from the top of the screen)
        } else if (tempCenter.getY() - radius <= yStart) {
            // Changes the direction of progress along the Y axis
            setVelocity(this.velocity.getDx(), (this.velocity.getDy() * -1));
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
}
