// ID: 208387969

package geometry;

import java.util.List;

/**
 * geometry.Line - The class connects two points - a start point and an end point.
 * <p>
 * Lines have lengths, and may intersect with other lines.
 * The class return if the line intersect with other lines and can calculate his lengths.
 * The class can also tell if the line is the same as another line segment
 */
public class Line {
    // We will use Epsilon (a very small fixed number) to correct the deflection
    public static final double EPSILON = Math.pow(10, -10);

    // The start point of the line, the end point of the line
    // The middle point of a line ,the intersection point of the line with other line.
    private Point start, end, pMiddle, pIntersect;

    /**
     * constructor with configurable of start point and end point of the line.
     *
     * @param start Start point of the line
     * @param end   End point of the line
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * constructor with configurable of  X , Y values for the start point of the line and the end.
     *
     * @param x1 - X value of start point of the line.
     * @param y1 - Y value of start point of the line.
     * @param x2 - X value of end point of the line.
     * @param y2 - Y value of end point of the line.
     */
    public Line(double x1, double y1, double x2, double y2) {

        this(new Point(x1, y1), new Point(x2, y2));
    }

    /**
     * length - Return the length of the line.
     * <p>
     * Calculate the distance between the start point and the end point of this line
     *
     * @return length of the line.
     */
    public double length() {
        // Calculate length of line - calculate the distance between the start point and the end point of this line.
        return start.distance(end);
    }

    /**
     * middle - Return the middle point of the line.
     *
     * @return Middle point.
     */
    public Point middle() {
        pMiddle = new Point(((start.getX() + end.getX()) / 2), ((start.getY() + end.getY()) / 2));
        return pMiddle;
    }

    /**
     * start - Return the start point of the line.
     *
     * @return Start point.
     */
    public Point start() {
        return this.start;
    }

    /**
     * end - Return the end point of the line.
     *
     * @return End point.
     */
    public Point end() {
        return this.end;
    }

    /**
     * getIncline - Return the incline of the line.
     *
     * @param pointStart - The starting point of the line.
     * @param pointEnd   - The end point of the line.
     * @return incline of the line.
     */
    public double getIncline(Point pointStart, Point pointEnd) {
        // Incline = (Y start - Y end) / (X start - X end)
        return ((pointStart.getY() - pointEnd.getY()) / (pointStart.getX() - pointEnd.getX()));
    }

    /**
     * cuttingYAxis - Return the Y value when the line is cutting Y axis (return the 'b').
     *
     * @param pointStart - The starting point of the line.
     * @param incline    - The incline of the line.
     * @return Y value when the line is cutting Y axis (b).
     */
    public double cuttingYAxis(Point pointStart, double incline) {
        // b = Y1 - (m * X1)
        return (pointStart.getY() - (incline * (pointStart.getX())));
    }

    /**
     * isParallelY - Returns true if the line is parallel to the Y axis, false otherwise.
     * The line parallel to the Y axis if the start and the end points are have the same X value but different Y.
     *
     * @param startLine - The starting point of the line.
     * @param endLine   - The end point of the line.
     * @return 'true' if the line is parallel to the Y axis, 'false' otherwise.
     */
    public boolean isParallelY(Point startLine, Point endLine) {
        // If the start and the end points are have the same X value but different Y: the line parallel to the Y axis
        // else: the line doesn't parallel to the Y axis
        return (startLine.getX() == endLine.getX()) && (startLine.getY() != endLine.getY());
    }

    /**
     * isParallelX - Returns true if the line is parallel to the X axis, false otherwise.
     * The line parallel to the X axis if the start and the end points are have the same Y value but different X.
     *
     * @param startLine - The starting point of the line.
     * @param endLine   - The end point of the line.
     * @return 'true' if the line is parallel to the X axis, 'false' otherwise.
     */
    public boolean isParallelX(Point startLine, Point endLine) {
        // If the start and the end points are have the same Y value but different X
        // The line parallel to the X axis
        // The line doesn't parallel to the X axis
        return (startLine.getY() == endLine.getY()) && (startLine.getX() != endLine.getX());
    }

    /**
     * isPointInLine - Returns true if the point include in the line, false otherwise.
     * Checks using the "distance" action if the point is in the line.
     * If [the distance from the starting point of the line to the point] + [the distance from the point to
     * the end point of the line] equals to [the distance from the starting point of the line till his end point] so it
     * means that the point include in the line
     *
     * @param startLine - The starting point of the line.
     * @param endLine   - The end point of the line.
     * @param point     - The point that we want to find out if she include in the line.
     * @return 'true' if the point include in the line, 'false' otherwise.
     */
    public boolean isPointInLine(Point startLine, Point endLine, Point point) {
        // If the point include in the line (The way of calculation is explained in the description of the action)
        // Return true, else: return false.
        boolean isInLine = Math.abs((startLine.distance(point) + point.distance(endLine)) - startLine.distance(endLine))
                < EPSILON;
        if (isInLine) {
            return true;
        }
        return false;
    }

    /**
     * isParallelYIntersect - Returns true if the lines intersect, false otherwise.
     * Checks if the lines are intersect in case that just one of the line is parallel to the Y axis.
     *
     * @param lineParallel    - The line that parallel to the Y axis.
     * @param lineNotParallel - The line that doesn't parallel to the Y axis.
     * @param lineMinXPoint   - The point in the line that have the minimum X value.
     * @param lineMaxXPoint   - The point in the line that have the maximum X value.
     * @return 'true' if the lines intersect, false otherwise.
     */
    public boolean isParallelYIntersect(Line lineParallel, Line lineNotParallel, Point lineMinXPoint,
                                        Point lineMaxXPoint) {
        double xIntersect, m2, b2, yIntersect;
        // If the X value of this line is between the minimum and the maximum X value of the line that doesn't parallel
        // to the Y axis
        if ((lineParallel.start.getX() >= lineMinXPoint.getX())
                && (lineParallel.start.getX() <= lineMaxXPoint.getX())) {
            // The X value of the intersection is the X value of the points in "this" line
            xIntersect = lineParallel.start.getX();
            // Get the incline of the 'other' line
            m2 = getIncline(lineNotParallel.start, lineNotParallel.end);
            // Get the value of the cutting Y axis of the 'other' line
            b2 = cuttingYAxis(lineNotParallel.start, m2);
            // Calculate the Y intersection (Y = mX + b)
            yIntersect = (m2 * xIntersect) + b2;
            // geometry.Point intersection
            this.pIntersect = new Point(xIntersect, yIntersect);
            // Check if the intersection is in the line (and not just in the continue).
            // If yes return true, else return false
            if (isPointInLine(lineParallel.start, lineParallel.end, pIntersect)) {
                return true;
            }
            return false;
            // If the Y value of "this" line isn't between the minimum and the maximum Y value of the "other" line
        } else {
            return false;
        }
    }

    /**
     * isParallelXIntersect - Returns true if the lines intersect, false otherwise.
     * Checks if the lines are intersect in case that just one of the line is parallel to the X axis.
     *
     * @param lineParallel    - The line that parallel to the X axis.
     * @param lineNotParallel - The line that doesn't parallel to the X axis.
     * @param lineMinYPoint   - The point in the line (that doesn't parallel) that have the minimum Y value.
     * @param lineMaxYPoint   - The point in the line (that doesn't parallel) that have the maximum Y value.
     * @return 'true' if the lines intersect, false otherwise.
     */
    public boolean isParallelXIntersect(Line lineParallel, Line lineNotParallel, Point lineMinYPoint,
                                        Point lineMaxYPoint) {
        double xIntersect, m2, b2, yIntersect;
        // If the Y value of this line is between the minimum and the maximum Y value in the line that doesn't parallel
        if ((lineParallel.start.getY() >= lineMinYPoint.getY())
                && (lineParallel.start.getY() <= lineMaxYPoint.getY())) {
            // The Y value of the intersection is the Y value of the points in "this" line
            yIntersect = lineParallel.start.getY();
            // Get the incline of the 'other' line
            m2 = getIncline(lineNotParallel.start, lineNotParallel.end);
            // Get the value of the cutting Y axis for the 'other' line
            b2 = cuttingYAxis(lineNotParallel.start, m2);
            // Calculate the X intersection (X = (Y - b) / m)
            xIntersect = (yIntersect - b2) / m2;
            // geometry.Point intersection
            this.pIntersect = new Point(xIntersect, yIntersect);
            // Check if the intersection is in the line (and not just in the continue), and return true or false
            return isPointInLine(lineParallel.start, lineParallel.end, pIntersect);
            // If the X value of the "this" line isn't between the minimum and the maximum X value in the other line
        } else {
            return false;
        }
    }

    /**
     * isIntersecting - Returns true if the lines intersect, false otherwise.
     * The operation also includes examination of problem cases such as:
     * If one of the line is a point , if the both lines are points , if both of the lines are parallel to the Y axis ,
     * If just one of the lines is parallel to the Y axis , if the lines have more then one Intersect ,
     * If just the one of the lines is parallel to the X axis.
     *
     * @param other - The other line that we want to find out if he intersect with the current line.
     * @return 'true' if the lines intersect, 'false' otherwise.
     */
    public boolean isIntersecting(Line other) {
        // The point in this line and in the other line witch have the maximum X value and the minimum X value
        Point thisMaxXPoint, thisMinXPoint, otherMaxXPoint, otherMinXPoint;
        // The point in this line and in the other line witch have the maximum Y value and the minimum Y value
        Point thisMaxYPoint, thisMinYPoint, otherMaxYPoint, otherMinYPoint;
        // The incline of this line (m1) and the other line (m2)
        double m1, m2;
        // The Y value - when the lines cutting the Y axis - of this line (b1) and the other line (b2)
        double b1, b2;
        // The X and the Y value of the intersection
        double xIntersect, yIntersect;
        // Variable that holds information about whether this line and the other line are points
        boolean isThisPoint, isOtherPoint;
        // Save the point with the maximum and the minimum X for 'this' line
        thisMaxXPoint = this.start.xBigger(this.end);
        thisMinXPoint = this.start.xSmaller(this.end);
        // Save the point with the maximum and the minimum X for the 'other' line
        otherMaxXPoint = other.start.xBigger(other.end);
        otherMinXPoint = other.start.xSmaller(other.end);
        // Save the point with the maximum and the minimum Y in 'this' line
        thisMaxYPoint = this.start.yBigger(this.end);
        thisMinYPoint = this.start.ySmaller(this.end);
        // Save the point with the maximum and the minimum Y for the 'other' line
        otherMaxYPoint = other.start.yBigger(other.end);
        otherMinYPoint = other.start.ySmaller(other.end);
        // Check whether 'this' line is a point
        if (this.start.equals(this.end)) {
            isThisPoint = true;
        } else {
            isThisPoint = false;
        }
        // Check whether the 'other' line is a point
        if (other.start.equals(other.end)) {
            isOtherPoint = true;
        } else {
            isOtherPoint = false;
        }
        // If the both lines are points
        if (isThisPoint && isOtherPoint) {
            // If the both points are equals so it's intersection point
            if (this.start.equals(other.start)) {
                pIntersect = this.start;
                return true;
            }
            // If the both lines are points but the points are different
            return false;
            // If 'this' line is actually a point and the 'other' line isn't
        } else if (isThisPoint) {
            // Check if the point contained in the 'other' line
            if (isPointInLine(other.start, other.end, this.start)) {
                // Intersection point
                pIntersect = this.start;
                return true;
                // If the point doesn't contained in the 'other' line
            } else {
                return false;
            }
            // If the 'other' line is actually a point and 'this' line isn't
        } else if (isOtherPoint) {
            // Check if the point contained in 'this' line so it's intersection point
            if (isPointInLine(this.start, this.end, other.start)) {
                pIntersect = other.start;
                return true;
                // If the point doesn't contained in the 'this' line
            } else {
                return false;
            }
            // If both of the lines are parallel to the Y axis
        } else if ((isParallelY(this.start, this.end)) && (isParallelY(other.start, other.end))) {
            //check if the lines have just one intersection:
            // If the point in this line with the maximum Y value is  equals to the point in the other line
            // with the minimum Y value so it's intersection point
            if (thisMaxYPoint.equals(otherMinYPoint)) {
                pIntersect = thisMaxYPoint;
                return true;
                // If the point in this line with the minimum Y value is  equals to the point in the other line
                // with the maximum Y value
            } else if (thisMinYPoint.equals(otherMaxYPoint)) {
                // Intersection point
                pIntersect = thisMinYPoint;
                return true;
                // don't have intersection point
            } else {
                return false;
            }
            // If just 'this' line is parallel to the Y axis
        } else if (isParallelY(this.start, this.end)) {
            // Check if the lines intersect (using "isParallelYIntersect"): if yes return true, else return false
            if (isParallelYIntersect(this, other, otherMinXPoint, otherMaxXPoint)) {
                return true;
            }
            return false;
            // if just the 'other' line is parallel to the Y axis
        } else if (isParallelY(other.start, other.end)) {
            // Check if the lines intersect (using "isParallelYIntersect"): if yes return true, else return false
            if (isParallelYIntersect(other, this, thisMinXPoint, thisMaxXPoint)) {
                return true;
            }
            return false;
            // if just 'this' line is parallel to the X axis
        } else if ((isParallelX(this.start, this.end)) && (!isParallelX(other.start, other.end))) {
            // Check if the lines intersect (using "isParallelXIntersect"): if yes return true, else return false
            if (isParallelXIntersect(this, other, otherMinYPoint, otherMaxYPoint)) {
                return true;
            }
            return false;
            // if just the 'other' line is parallel to the X axis
        } else if ((isParallelX(other.start, other.end)) && (!isParallelX(this.start, this.end))) {
            // Check if the lines intersect (using "isParallelXIntersect"): if yes return true, else return false
            if (isParallelXIntersect(other, this, thisMinYPoint, thisMaxYPoint)) {
                return true;
            }
            return false;
        }
        // Get the incline of the line 'this'
        m1 = getIncline(this.start, this.end);
        // Get the incline of the line 'other'
        m2 = getIncline(other.start, other.end);
        // Get the value of the cutting Y axis of the line 'this'
        b1 = cuttingYAxis(this.start, m1);
        // Get the value of the cutting Y axis of the line 'other'
        b2 = cuttingYAxis(other.start, m2);
        // If the lines have the same incline
        if (m1 == m2) {
            // Check if the lines have just one intersection:
            // If the point in this line with the maximum X value is equals to the point in the other line
            // with the minimum X value
            if (thisMaxXPoint.equals(otherMinXPoint)) {
                // Intersection point
                pIntersect = thisMaxXPoint;
                return true;
                // If the point in this line with the minimum X value is equals to the point in the other line
                // with the maximum X value so it's intersection point
            } else if (thisMinXPoint.equals(otherMaxXPoint)) {
                pIntersect = thisMinXPoint;
                return true;
            } else {
                return false;
            }
        }
        // Calculate the X value of the intersection (X = [b2-b1] / [m1-m2])
        xIntersect = ((b2 - b1) / (m1 - m2));
        // Calculate the Y value of the intersection (Y = [m * X] + b)
        yIntersect = ((m1 * xIntersect) + b1);
        // Save the intersection point
        pIntersect = new Point(xIntersect, yIntersect);
        // Checks if the intersection is contained in both straight, and returns true or false
        return (isPointInLine(this.start, this.end, pIntersect))
                && (isPointInLine(other.start, other.end, pIntersect));
    }

    /**
     * intersectionWith - Returns the intersection point if the lines intersect, null otherwise.
     *
     * @param other - The other line that may intersect with the current line.
     * @return The intersection point if the lines intersect, null otherwise.
     */
    public Point intersectionWith(Line other) {
        // Calls the action "isIntersecting" and returns the intersection point
        if (this.isIntersecting(other)) {
            return this.pIntersect;
            // If we get bull from the action "isIntersecting" - return null
        } else {
            return null;
        }
    }

    /**
     * equals - Return 'true' if the lines are equal, 'false' otherwise.
     *
     * @param other - The other line that we want to find out if he equals to the current line.
     * @return Return 'true' if the lines are equal, 'false' otherwise.
     */
    public boolean equals(Line other) {
        // If the starting point of "this" line is equals to the starting point of the "other" line and if the end
        // point of "this" line is equals to the end point of the "other" line so the lines are equals
        return (this.start.equals(other.start)) && (this.end.equals(other.end));
    }

    /**
     * closestIntersectionToStartOfLine - Return the closest intersection point (with the rectangle)
     * to the start of the line.
     * If this line does not intersect with the rectangle, return null.
     *
     * @param rect - The rectangle
     * @return the closest intersection point to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        // List of the intersection points of the rectangle ribs with this line
        List<Point> listPointsIntersection;
        // Save the list (possibly empty) of intersection points between the line and the rectangle
        listPointsIntersection = rect.intersectionPoints(this);
        // If this line does not intersect with the rectangle, return null
        if (listPointsIntersection.size() == 0) {
            return null;
        }
        // The closest intersection point to the start of the line
        Point closestIntersectionPoint = listPointsIntersection.get(0);
        // If this line intersect with the rectangle
        // Initialize the minimum distance (closest intersection point)
        double minDistance = listPointsIntersection.get(0).distance(this.start);
        // Run on the intersection points
        for (int i = 1; i < listPointsIntersection.size(); i++) {
            // Temp distance from intersection point with the rib to the start of the line
            double tempDistance = listPointsIntersection.get(i).distance(this.start);
            // If the current distance is smaller than the minimum distance
            // so change the minDistance to be tempDistance
            if (tempDistance < minDistance) {
                minDistance = tempDistance;
                // Save the closest intersection point to the start of the line
                closestIntersectionPoint = listPointsIntersection.get(i);
            }
        }
        // Return the closest intersection point to the start of the line
        return closestIntersectionPoint;
    }
}
