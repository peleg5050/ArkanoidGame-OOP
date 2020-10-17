// ID: 208387969

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import geometry.Point;
import sprites.Ball;

/**
 * BouncingBallAnimation - The class gets 4 integers and show the ball and his move to the new position.
 * <p>
 * The class gets 4 integers from the command line (X start, Y start, dx and dy) and runs the
 * drawAnimation method accordingly.
 */
public class BouncingBallAnimation {
    // Const number of the size of the board
    public static final int SIZE_OF_BOARD_X = 200;
    public static final int SIZE_OF_BOARD_Y = 200;
    // Const number of the size of the ball - radius
    public static final int SIZE = 30;

    /**
     * drawAnimation - Draw the ball and show his move to the new position.
     *
     * @param start - The point before the change in the position.
     * @param dx    - The change in the position on the `X` axes.
     * @param dy    - The change in the position on the `Y` axes.
     */
    private static void drawAnimation(Point start, double dx, double dy) {
        // Create a window with the title "Bouncing sprites.Ball interfaces.Animation"
        // which is SIZE_OF_BOARD_X pixels wide and SIZE_OF_BOARD_Y pixels high (200x200 in this case).
        GUI gui = new GUI("Bouncing sprites.Ball interfaces.Animation", SIZE_OF_BOARD_X, SIZE_OF_BOARD_Y);
        Sleeper sleeper = new Sleeper();
        // Create a new ball (in black color) with radius 30, and his center is the starting point that we got
        Ball ball = new Ball((int) start.getX(), (int) start.getY(), SIZE, java.awt.Color.BLACK);
        // Set the velocity of the ball.
        ball.setVelocity(dx, dy);
        while (true) {
            // Use the "moveOneStep" action to apply the ball position
            ball.moveOneStep();
            // Create a DrawSurface
            DrawSurface draw = gui.getDrawSurface();
            // Draw the ball on the draw DrawSurface
            ball.drawOn(draw);
            // Show the draw
            gui.show(draw);
            // wait for 50 milliseconds.
            sleeper.sleepFor(50);
        }
    }

    /**
     * main - Gets 4 integers and call the drawAnimation function .
     *
     * @param args - the 0 and 1 index is the point X and Y values, the 2 index is dx and the 3rd index is dy.
     */
    public static void main(String[] args) {
        // Save the x and y starting point
        double xStart = Double.valueOf(args[0]);
        double yStart = Double.valueOf(args[1]);
        // Create a point from the X and the Y values that we got.
        Point pointCenter = new Point(xStart, yStart);
        // Check if all the ball is in the board
        if (((xStart - SIZE < 0) || (xStart + SIZE > SIZE_OF_BOARD_X))
                || ((yStart - SIZE < 0) || (yStart + SIZE > SIZE_OF_BOARD_Y))) {
            // If no - just print error message
            System.out.println(" The ball is out of the board");
            // If all the ball is in the board
        } else {
            // Draw the point on the board (and show the change in the position)
            drawAnimation(pointCenter, Double.valueOf(args[2]), Double.valueOf(args[3]));
        }
    }
}
