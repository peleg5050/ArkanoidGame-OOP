// ID: 208387969

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.util.Random;

/**
 * MultipleBouncingBallsAnimation - The class is invoked from the commandline, and each argument is a size of a sprites.Ball.
 * <p>
 * The class will create an animation with all the balls and each ball will change direction
 * when hitting the window border.
 * Each ball will start in a random location on the screen.
 * Each ball will start with a different speed so the larger balls will be slower.
 * Balls above size 50 can all have the same slow speed.
 */
public class MultipleBouncingBallsAnimation {
    // Const number of the size of the board
    public static final int SIZE_OF_BOARD_X = 200;
    public static final int SIZE_OF_BOARD_Y = 200;
    // Const number of the radius
    public static final int CONST_RADIUS = 50;
    // Const number of the minimum speed
    public static final int MIN_SPEED = 1;
    // Const number of the default speed
    public static final int DEFAULT_SPEED = 50;
    // Const number of the angle
    public static final int ANGLE = 360;

    /**
     * drawAnimation - Create an animation with all the balls and each ball will change direction
     * when hitting the window border.
     * The balls will start in a random location on the screen.
     * Each ball will start with a different speed so the larger balls will be slower.
     * Balls above size 50 can all have the same slow speed.
     *
     * @param arrSizeBall - Array of the sizes of the ball (array of the sizes that we get).
     * @param length      - The length of the array.
     */
    private static void drawAnimation(int[] arrSizeBall, int length) {
        // Create a window with the title "Multiple Bouncing Balls interfaces.Animation"
        // which is SIZE_OF_BOARD_X pixels wide and SIZE_OF_BOARD_Y pixels high.
        GUI gui = new GUI("Multiple Bouncing Balls interfaces.Animation", SIZE_OF_BOARD_X, SIZE_OF_BOARD_Y);
        Sleeper sleeper = new Sleeper();
        // Create array of balls
        Ball[] arrayBall = new Ball[length];
        // The radius of the ball
        int radius;
        // Speed of the ball
        double speed;
        // Create a random-number generator
        Random rand = new Random();
        // For in size of the number of balls
        for (int i = 0; i < length; i++) {
            // Radius of the current ball
            radius = arrSizeBall[i];
            // Get integer in range of the size of the board in the X axis less the radius.
            int startX = rand.nextInt(((int) SIZE_OF_BOARD_X - radius - radius) + 1) + radius;
            // Get integer in range of the size of the board in the Y axis less the radius.
            int startY = rand.nextInt(((int) SIZE_OF_BOARD_Y - radius - radius) + 1) + radius;
            // Create a ball
            arrayBall[i] = new Ball(startX, startY, radius, java.awt.Color.BLACK);
            // Get double in range 0 to 360 (the angle)
            double angle = rand.nextInt(ANGLE);
            // The diameter of the ball equals to his radius * 2
            double diameter = arrayBall[i].getSize() * 2;
            // if the ball diameter (radius*2) equals the size of the X and the Y board size
            if ((diameter == SIZE_OF_BOARD_X) && (diameter == SIZE_OF_BOARD_Y)) {
                // the ball is in the size of the board so he can't move
                speed = 0;
                // If the radius of the ball is CONST_RADIUS (50) or more, we want the balls
                // to have the same slow default speed (1)
            } else if (arrSizeBall[i] >= CONST_RADIUS) {
                // Minimum speed of 1 (DEFAULT_SPEED)
                speed = MIN_SPEED;
                // If the radius of the ball is less then the CONST_RADIUS (50)
            } else {
                // We will determine the speed to be: DEFAULT_SPEED (50) / arrSizeBall[i]
                speed = DEFAULT_SPEED / arrSizeBall[i];
            }
            // Converts speed and angle to DX and DY
            Velocity v = Velocity.fromAngleAndSpeed(angle, speed);
            // Set the velocity of the current ball
            arrayBall[i].setVelocity(v);
        }
        while (true) {
            // Create a DrawSurface
            DrawSurface draw = gui.getDrawSurface();
            // For in the sizes of the balls (so we will draw every ball)
            for (int j = 0; j < length; j++) {
                // Use the "moveOneStep" action to apply the ball position
                arrayBall[j].moveOneStep();
                // Draw the ball on the draw DrawSurface
                arrayBall[j].drawOn(draw);
            }
            // Show the draw
            gui.show(draw);
            // wait for 50 milliseconds.
            sleeper.sleepFor(50);
        }
    }

    /**
     * main - Gets integers, each integer is size of a ball and by calling the drawAnimation function
     * we draw all the balls .
     *
     * @param args - sizes of the balls.
     */
    public static void main(String[] args) {
        // The length of the elements in the input
        int length = args.length;
        // Create an array of the sizes that we get in size of the number of elements that we got
        int[] arrSizeBall = new int[length];
        // Copy the sizes from the input to an array
        for (int i = 0; i < length; i++) {
            arrSizeBall[i] = Integer.valueOf(args[i]);
        }
        // Call the "drawAnimation" function with the array of the sizes and his length
        drawAnimation(arrSizeBall, length);
    }
}


