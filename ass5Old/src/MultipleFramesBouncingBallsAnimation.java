// ID: 208387969

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import geometry.Velocity;
import sprites.Ball;

import java.awt.Color;
import java.util.Random;

/**
 * MultipleFramesBouncingBallsAnimation - The class is invoked from the commandline, and each argument
 * is a size of a sprites.Ball.
 * <p>
 * The class create two frames -- one of them is a grey rectangle from (50,50) to (500,500),
 * and the other is a yellow rectangle from (450,450) to (600,600).
 * The class create an animation with all the balls and each ball will change direction when hitting the window border,
 * while the first half of the balls will bounce inside the first frame, and the second half of the
 * balls will bounce inside the second frame.
 * Each ball will start in a random location on his frame (so the first half of the balls will start in a
 * random location inside the first frame, and the second half of the balls will start in a random location
 * inside the second frame).
 * Each ball will start with a different speed so the larger balls will be slower then the smaller balls.
 * Balls above size 50 can all have the same slow speed.
 */
public class MultipleFramesBouncingBallsAnimation {
    // Const number of the size of the board
    public static final int SIZE_OF_BOARD_X = 800;
    public static final int SIZE_OF_BOARD_Y = 650;
    // Const number for the X value at the starting point of the gray board
    public static final int GRAY_START_X = 50;
    public static final int GRAY_START_Y = 50;
    // Const number for the Y value at the ending point of the gray board
    public static final int GRAY_END_X = 500;
    public static final int GRAY_END_Y = 500;
    // Const number for the X value at the starting point of the yellow board
    public static final int YELLOW_START_X = 450;
    public static final int YELLOW_START_Y = 450;
    // Const number for the Y value at the ending point of the yellow board
    public static final int YELLOW_END_X = 600;
    public static final int YELLOW_END_Y = 600;
    // Const number of the radius
    public static final int CONST_RADIUS = 50;
    // Const number of the minimum speed
    public static final int MIN_SPEED = 1;
    // Const number of the default speed
    public static final int DEFAULT_SPEED = 50;

    /**
     * bubbleSort - sorting algorithm that swap the elements in the array (of the sizes) so they will be sort
     * in the right order (from the big to the small).
     * The "bubbleSort" function ensures that we can see all the balls so that the big balls will not
     * hide the little balls.
     *
     * @param arraySize - Array of the sizes of the ball (the array of the sizes that we get).
     * @param start     - The index of the start of each half.
     * @param end       - The index of the end of each half less 1.
     */
    private static void bubbleSort(int[] arraySize, int start, int end) {
        // Gives an indication that the exchange was done (for optimization)
        int hasSwap = 1;
        // Temp variable for the swap
        int temp;
        // Runs from the end - 1 to the start, and check if there was a swap (for optimization)
        for (int i = end; i > start && hasSwap == 1; i--) {
            // Initialize the variable in '0'
            hasSwap = 0;
            //Runs from 0 to i (so we won't sort the part that already sort)
            for (int j = start; j < i; j++) {
                // Sort from the big to the small
                if (arraySize[j] < arraySize[j + 1]) {
                    // Swap the two numbers:
                    //
                    // Temporary variable "temp"
                    temp = arraySize[j];
                    // Swap num1 and num2
                    arraySize[j] = arraySize[j + 1];
                    arraySize[j + 1] = temp;
                    // Gives an indication that the exchange was done
                    hasSwap = 1;
                }
            }
        }
    }

    /**
     * randColor - Return a random color for each ball.
     * The methods make sure that the yellow color is not released for the yellow screen or gray color
     * for the gray screen
     *
     * @param isYellow - Gives an indication if the ball is in the Yellow frame or in the gray frame (This makes it
     *                 possible to make sure that the yellow color is not released for the yellow screen or gray color
     *                 for the gray screen).
     * @return Random color for each ball.
     */
    private static Color randColor(boolean isYellow) {
        // Variable of random color
        Color colorRandom;
        // Create a random-number generator
        Random rand = new Random();
        // Get integer in range 1-12
        int numColor = rand.nextInt(12) + 1;
        // If the color number is numColor
        switch (numColor) {
            // Then colorRandom = ....
            case 1:
                colorRandom = Color.GREEN;
                break;
            case 2:
                colorRandom = Color.MAGENTA;
                break;
            case 3:
                colorRandom = Color.BLUE;
                break;
            case 4:
                colorRandom = Color.PINK;
                break;
            case 5:
                colorRandom = Color.BLACK;
                break;
            case 6:
                colorRandom = Color.WHITE;
                break;
            case 7:
                colorRandom = Color.cyan;
                break;
            case 8:
                colorRandom = Color.RED;
                break;
            case 9:
                colorRandom = Color.ORANGE;
                break;
            case 10:
                if (!isYellow) {
                    colorRandom = Color.YELLOW;
                } else {
                    colorRandom = Color.gray;
                }
                break;
            case 11:
                colorRandom = Color.lightGray;
                break;
            case 12:
                colorRandom = Color.darkGray;
                break;
            default:
                colorRandom = Color.white;
        }
        // Return the color
        return colorRandom;
    }

    /**
     * drawAnimation - create an animation with all the balls and each ball will change direction when hitting the
     * window border, while the first half of the balls will bounce inside the first frame, and the second half of the
     * balls will bounce inside the second frame.
     * Each ball will start in a random location on his frame (so the first half of the balls will start in a
     * random location inside the first frame, and the second half of the balls will start in a random location
     * inside the second frame).
     * Each ball will start with a different speed so the larger balls will be slower then the smaller balls.
     * Balls above size 50 can all have the same slow speed.
     *
     * @param arrSizeBall - Array of the sizes of the ball (array of the sizes that we get).
     * @param length      - The length of the array.
     */
    private static void drawAnimation(int[] arrSizeBall, int length) {
        // Create a screen
        GUI gui = new GUI("title", SIZE_OF_BOARD_X, SIZE_OF_BOARD_Y);
        Sleeper sleeper = new Sleeper();
        // Create array of balls
        Ball[] arrayBall = new Ball[length];
        // radius , starting point (X , Y) values , isOdd - gives an indication if the number of balls is odd or even
        int radius, startX, startY, isOdd;
        // The speed of the ball
        double speed;
        // Is the ball in the yellow board
        boolean isYellow;
        //create a random-number generator
        Random rand = new Random();
        // If the input is even (even number of balls)
        if ((length % 2) == 0) {
            isOdd = 0;
        } else {
            // If the input is odd (odd number of balls)
            isOdd = 1;
        }
        // For in size of the numbers of balls
        for (int i = 0; i < length; i++) {
            // Radius of the current ball
            radius = arrSizeBall[i];
            // Make the first half of the balls to bounce inside the first frame (the gray frame)
            if (i < ((length / 2) + isOdd)) {
                // sprites.Ball in the gray frame
                isYellow = false;
                // Create a random starting point location on the gray frame:
                // Get integer in range of the size of the gray board in the X axis less the radius
                startX = rand.nextInt((((int) GRAY_END_X - radius) - (GRAY_START_X + radius)) + 1)
                        + (GRAY_START_X + radius);
                // Get integer in range of the size of the gray board in the Y axis less the radius
                startY = rand.nextInt((((int) GRAY_END_Y - radius) - (GRAY_START_Y + radius)) + 1)
                        + (GRAY_START_Y + radius);
                // Make the second half of the balls to bounce inside the second frame (the yellow frame)
            } else {
                // sprites.Ball in the Yellow frame
                isYellow = true;
                // Create a random starting point location on the yellow frame
                // Get integer in range of the size of the yellow board in the X axis less the radius
                startX = rand.nextInt((((int) YELLOW_END_X - radius) - (YELLOW_START_X + radius)) + 1)
                        + (YELLOW_START_X + radius);
                // Get integer in range of the size of the yellow board in the Y axis less the radius
                startY = rand.nextInt((((int) YELLOW_END_Y - radius) - (YELLOW_START_Y + radius)) + 1)
                        + (YELLOW_START_Y + radius);
            }
            // Create a ball
            arrayBall[i] = new Ball(startX, startY, radius, randColor(isYellow));
            // Get double in range 0 to 360 (the angle)
            double angle = rand.nextInt(360);
            // The diameter of the ball equals to: his radius * 2
            double diameter = arrayBall[i].getSize() * 2;
            // if the ball in the gray board, and his diameter (radius*2) equals the size of the X and Y gray board size
            if ((!isYellow) && ((diameter == (GRAY_END_X - GRAY_START_X))
                    && (diameter == (GRAY_END_Y - GRAY_START_Y)))) {
                // the ball is in the size of the board so he can't move
                speed = 0;
                // if the ball is in the yellow board,
                // and his diameter (radius * 2) equals to the size of the X and Y yellow board size
            } else if ((isYellow) && ((diameter == (YELLOW_END_X - YELLOW_START_X))
                    && (diameter == (YELLOW_END_Y - YELLOW_START_Y)))) {
                // the ball is in the size of the board so he can't move
                speed = 0;
                // If the radius of the ball is CONST_RADIUS (50) or more, we want all the balls to have
                // the same slow default speed (of 1)
            } else if (arrSizeBall[i] >= CONST_RADIUS) {
                // Min speed of DEFAULT_SPEED (1)
                speed = MIN_SPEED;
                // If the radius of the ball is less then 50
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
            // Make the color of the first rectangle (first frame) to be in gray
            draw.setColor(Color.gray);
            // Draw the gray rectangle from the starting point to the end point
            draw.fillRectangle(GRAY_START_X, GRAY_START_Y, (GRAY_END_X - GRAY_START_X), (GRAY_END_Y - GRAY_START_Y));
            // Make the color of the second rectangle (second frame) to be in yellow
            draw.setColor(Color.yellow);
            // Draw the yellow rectangle from the starting point to the end point
            draw.fillRectangle(YELLOW_START_X, YELLOW_START_Y, (YELLOW_END_X - YELLOW_START_X),
                    (YELLOW_END_Y - YELLOW_START_Y));
            // For in length of the number of balls
            for (int j = 0; j < length; j++) {
                // If it's the ball at the first half of the balls
                if (j < ((length / 2) + isOdd)) {
                    // Send the size of the gray board (X and Y start and end) to the "moveOneStepHelper" function so
                    // The function will apply the location of the ball and will make sure that the ball won't get out
                    // of the gray screen.
                    arrayBall[j].moveOneStepHelper(GRAY_START_X, GRAY_START_Y, GRAY_END_X, GRAY_END_Y);
                    // If it's the ball at the second half of the balls
                } else {
                    // Send the size of the yellow board (X and Y start and end) to the "moveOneStepHelper" function
                    // The function will apply the location of the ball and will make sure that the ball won't get out
                    // of the yellow screen.
                    arrayBall[j].moveOneStepHelper(YELLOW_START_X, YELLOW_START_Y, YELLOW_END_X, YELLOW_END_Y);
                }
                // Draw the ball on the 'draw' DrawSurface
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
     * we draw all the balls (the first half of the balls will start at a random location inside the first frame,
     * and the second half of the balls will start at a random location inside the second frame).
     *
     * @param args - sizes of the balls.
     */
    public static void main(String[] args) {
        // The length of the elements in the input
        int length = args.length;
        //  The index in the middle of the array (less 1)
        int endHalfOne;
        // If the length of the arguments is even
        if (length % 2 == 0) {
            // The index in the middle of the array equals to: the length/2 less 1
            endHalfOne = (args.length / 2) - 1;
            // If the length of the arguments is odd
        } else {
            // The index in the middle of the array less 1 plus 1
            // (if the length is odd, the first half will be bigger in 1 from the second half, so we had 1)
            endHalfOne = args.length / 2;
        }
        // Array of the sizes (of the balls) that we got
        int[] arrSizeBall = new int[length];
        // For in the size of the input
        for (int i = 0; i < length; i++) {
            // Copy the sizes to our array
            arrSizeBall[i] = Integer.valueOf(args[i]);
        }
        // sort the first half of the array
        bubbleSort(arrSizeBall, 0, endHalfOne);
        // sort the second half of the array
        bubbleSort(arrSizeBall, endHalfOne + 1, length - 1);
        // Send the array of the sizes and his length to "drawAnimation" function
        drawAnimation(arrSizeBall, length);
    }
}
