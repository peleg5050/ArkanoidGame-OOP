// ID: 208387969

/**
 * geometry.Point - The class make a point from X and Y - 2 numbers that she receive.
 *
 * The class check if one point is equal to another point, and measure the distance to other points.
 */
public class Point {
    // Characteristics
    private double x, y;

    /**
     * constructor with configurable X,Y.
     *
     * @param x - x value of the point.
     * @param y - y value of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * distance - return the distance of this point to the other point.
     *
     * @param other the other point with which we measure the distance.
     * @return The distance between "this" point to "other" point.
     */
    public double distance(Point other) {
        return Math.sqrt(((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y)));
    }

    /**
     * equals - Return true if the points are equal, false otherwise.
     *
     * @param other -  The "other" point with which we want to check if it equal to "this" point.
     * @return 'true' if the points are equal, 'false' otherwise.
     */
    public boolean equals(Point other) {
        // If the X value is equal in both of the points and also the Y value is equal: return true, else return false
        return (this.x == other.x) && (this.y == other.y);
    }

    /**
     * getX - Return the X value of this point.
     *
     * @return The X value of point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * getY - Return the Y value of this point.
     *
     * @return The Y value of point.
     */
    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x= x;
    }
    public void setY(double y) {
        this.y = y;
    }
    /**
     * xBigger - Equates the value of X at "this" point and the "other" point
     * and returns the point that have the bigger X.
     *
     * @param other - The "other" point with which we will compare the value of X.
     * @return Returns the point that have the bigger X.
     */
    public Point xBigger(Point other) {
        if (this.x > other.x) {
            return this;
        }  else {
            return other;
        }
    }

    /**
     * xSmaller - Equates the value of X at "this" point and the "other" point
     * and returns the point that have the smallest X.
     *
     * @param other - The "other" point with which we will compare the value of X.
     * @return Returns the point that have the smallest X.
     */
    public Point xSmaller(Point other) {
        if (this.x < other.x) {
            return this;
        } else {
            return other;
        }
    }

    /**
     * yBigger - Equates the value of Y at "this" point and the "other" point
     * and returns the point that have the bigger Y.
     *
     * @param other - The "other" point with which we will compare the value of Y.
     * @return Returns the point that have the bigger Y.
     */
    public Point yBigger(Point other) {
        if (this.y > other.y) {
            return this;
        }  else {
            return other;
        }
    }

    /**
     * ySmaller - Equates the value of Y at "this" point and the "other" point
     * and returns the point that have the smallest Y.
     *
     * @param other - The "other" point with which we will compare the value of Y.
     * @return Returns the point that have the smallest Y.
     */
    public Point ySmaller(Point other) {
        if (this.y < other.y) {
            return this;
        } else {
            return other;
        }
    }
}
