// ID: 208387969

/**
 * geometry.Velocity - The class specifies the change in position on the `x` and the `y` axes.
 * The class apply the location of the center of the ball to the new location (after the change in position
 * on the `x` and the `y` axes), and also converts speed and angle to dx and dy (change in position
 * on the `x` and the `y` axes).
 */
public class Velocity {
    // Characteristics
    // Change in position on the `x` axes
    private double dx;
    // Change in position on the `y` axes
    private double dy;

    /**
     * constructor with configurable of dx and dy (The change in the position on the `X` and 'Y' axes).
     *
     * @param dx - The change in the position on the `X` axes.
     * @param dy - The change in the position on the `Y` axes.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * getDx - Return the dx value of the velocity (The change in the position on the `X` axes).
     *
     * @return The dx value of the velocity.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * getDy - Return the dy value of the velocity (The change in the position on the `Y` axes).
     *
     * @return The dy value of the velocity.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * applyToPoint - Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p - The point (that we want to change her position).
     * @return New point with position (x+dx, y+dy).
     */
    public Point applyToPoint(Point p) {
        // The new X and Y values
        double newX, newY;
        // The new X = X + dx
        newX = p.getX() + this.dx;
        // The new Y = Y + dy
        newY = p.getY() + this.dy;
        Point newPoint = new Point(newX, newY);
        //return the new point
        return newPoint;
    }

    /**
     * fromAngleAndSpeed - Converts speed and angle into dx and dy.
     *
     * @param angle - The angle of the ball.
     * @param speed - The speed of the ball.
     * @return The velocity as dx and dy.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        // converting values to radians
        double angleRadian = Math.toRadians(angle);
        // Calculate the dx by the angle (in radians) and the speed
        double dx = Math.sin(angleRadian) * speed;
        // Calculate the dy by the angle (in radians) and the speed
        double dy = -1 * (Math.cos(angleRadian) * speed);
        // Return the velocity as dx and dy
        return new Velocity(dx, dy);
    }
}
