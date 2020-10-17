// ID: 208387969

import java.util.ArrayList;
import java.util.List;

/**
 * geometry.Rectangle - The class create a rectangle
 * <p>
 * Each geometry.Rectangle have location (the upper left point of the rectangle) and width/height
 * The class return list of intersection points with the specified line (that she get).
 * The class return the width and height of the rectangle.
 * The class return the upper-left point of the rectangle
 */
public class Rectangle {

    // Characteristics
    // The upper left point of the rectangle
    private Point upperLeft;
    // The width and the height of the rectangle
    private double width, height;

    /**
     * constructor with configurable of the upper - Left point, the width and the height of the rectangle.
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft the upper left point of the rectangle
     * @param width     the width of the rectangle
     * @param height    the height of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * getUpperLeft - Return the upper left point of the rectangle.
     *
     * @return upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * getUpperRight - Return the upper right point of the rectangle.
     *
     * @return upper right point of the rectangle.
     */
    public Point getUpperRight() {
        Point upperRight = new Point((upperLeft.getX() + this.width), upperLeft.getY());
        return upperRight;
    }

    /**
     * getLowerLeft - Return the lower left point of the rectangle.
     *
     * @return lower left point of the rectangle.
     */
    public Point getLowerLeft() {
        Point lowerLeft = new Point(upperLeft.getX(), (upperLeft.getY() + this.height));
        return lowerLeft;
    }

    /**
     * getLowerRight - Return the upper right point of the rectangle.
     *
     * @return upper right point of the rectangle.
     */
    public Point getLowerRight() {
        Point lowerRight = new Point((upperLeft.getX() + this.width), (upperLeft.getY() + this.height));
        return lowerRight;
    }

    /**
     * ribIntersectLine - Update the list of the intersection points for each rib of the rectangle
     * with the specified line, and return the list.
     *
     * @param ribRectangle - The rib of the rectangle that may intersect with the line.
     * @param line         - The line that may intersect with the rib of the rectangle.
     * @param listPoints   - List of the intersection points of the rectangle ribs with the specified line.
     */
    public void ribIntersectLine(Line ribRectangle, Line line, java.util.List listPoints) {
        Point suspiciouspoints = line.intersectionWith(ribRectangle);
        if (suspiciouspoints != null) {
            listPoints.add(ribRectangle.intersectionWith(line));
        }
    }

    /**
     * intersectionPoints - Return the List (possibly empty) of intersection points with the specified line.
     *
     * @param line - The line that may intersect with the rectangle.
     * @return The List (possibly empty) of intersection points with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        // List of the intersection points of the rectangle ribs with the specified line
        List<Point> listPointsIntersect = new ArrayList<Point>();
        // Make lines for each rib of the rectangle
        //
        // geometry.Line of the upper rib of the rectangle
        Line lineUpRib = new Line(this.upperLeft, getUpperRight());
        // Save the intersection points of the upper rib of the rectangle with the specified line
        ribIntersectLine(lineUpRib, line, listPointsIntersect);
        // geometry.Line of the lower rib of the rectangle
        Line lineLowRib = new Line(getLowerLeft(), getLowerRight());
        // Save the intersection points of the lower rib of the rectangle with the specified line
        ribIntersectLine(lineLowRib, line, listPointsIntersect);
        // geometry.Line of the left rib of the rectangle
        Line lineLeftRib = new Line(this.upperLeft, getLowerLeft());
        // Save the intersection points of the left rib of the rectangle with the specified line
        ribIntersectLine(lineLeftRib, line, listPointsIntersect);
        // geometry.Line of the right rib of the rectangle
        Line lineRightRib = new Line(getUpperRight(), getLowerRight());
        // Save the intersection points of the right rib of the rectangle with the specified line
        ribIntersectLine(lineRightRib, line, listPointsIntersect);
        return listPointsIntersect;
    }

    /**
     * getWidth - Return the width of the rectangle.
     *
     * @return width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * getHeight - Return the height of the rectangle.
     *
     * @return height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }
}
