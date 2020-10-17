// ID: 208387969

package alllevels;

import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.LevelInformation;
import interfaces.Sprite;
import levelsgraphics.SecondLevelGraphic;
import sprites.Block;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * alllevels.SecondLevel  - The class , SecondLevel , is the second level.
 * The class implements the LevelInformation interface.
 */
public class SecondLevel implements LevelInformation {
    // The number of balls at the beginning
    private static final int NUMBER_OF_BALLS = 10;
    // The paddle speed
    private static final int PADDLE_SPEED = 7;
    // The width of the paddle
    private static final int WIDTH_OF_PADDLE = 450;
    // The velocity of the balls :
    //
    // The angle of the first ball
    private static final double ANGLE_BALL = 315;
    // The speed of the first ball
    private static final double SPEED_BALL = 6;
    // The string name
    private static final String LEVEL_NAME = "Wide Easy";
    // The upper - left point of the background rectangle
    private static final Point POINT_BACKGROUND = new Point(0, 0);
    // The width of the background block
    private static final int BACKGROUND_WIDTH = 800;
    // The height of the background block
    private static final int BACKGROUND_HEIGHT = 600;
    // Blocks :
    //
    // The height of all the Blocks in the row
    private static final int BLOCKS_ROW_HEIGHT = 200;
    // Block - width
    private static final double BLOCK_WIDTH = 50.8;
    // Block - height
    private static final int BLOCK_HEIGHT = 25;
    // the x value of the upper left point of the first rectangle
    private static final double START_RECT = 20;

    /**
     * numberOfBalls - return the number of balls.
     *
     * @return number of balls.
     */
    public int numberOfBalls() {
        return NUMBER_OF_BALLS;
    }

    /**
     * initialBallVelocities - initial velocity of each ball, and insert the velocity of each ball to a list.
     * By this, initialBallVelocities().size() == numberOfBalls().
     *
     * @return list of velocity of all the balls.
     */
    public List<Velocity> initialBallVelocities() {
        double angle = 0;
        // create list of velocities
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            Velocity velocity = Velocity.fromAngleAndSpeed(ANGLE_BALL + angle, SPEED_BALL);
            // add the new velocities to the velocities list
            velocities.add(velocity);
            // Add 10 to the angle of each ball
            angle = angle + 10;
        }
        // Return the list of the velocities
        return velocities;
    }

    /**
     * paddleSpeed - return the paddle speed.
     *
     * @return paddle speed.
     */
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    /**
     * paddleWidth - return the paddle width.
     *
     * @return paddle width.
     */
    public int paddleWidth() {
        return WIDTH_OF_PADDLE;
    }

    /**
     * levelName - return the String of the levelName.
     * The level name will be displayed at the top of the screen.
     *
     * @return String of the levelName.
     */
    public String levelName() {
        return LEVEL_NAME;
    }

    /**
     * getBackground - Returns a sprite with the background of the level.
     * The level name will be displayed at the top of the screen.
     *
     * @return String of the levelName.
     */
    public Sprite getBackground() {
        SecondLevelGraphic secondLevelGraphic = new SecondLevelGraphic();
        return secondLevelGraphic;
    }

    /**
     * blocks - return list of all the blocks that make up this level.
     * The Blocks that make up this level, each block contains its size, color and location.
     *
     * @return list of all the blocks that make up this level.
     */
    public List<Block> blocks() {
        // Create list of blocks
        List<Block> blocks = new ArrayList<>();
        // The X and the Y value of the upper left point of the current block
        double x, y;
        // The upper left point of the rectangle
        Point upperLeft;
        // The current rectangle
        Rectangle rectangle;
        for (int i = 0; i < 15; i++) {
            // Chose color for the block
            int numColor = i;
            Color color;
            switch (numColor) {
                // Then colorRandom = ....
                case 0:
                case 1:
                    color = Color.red;
                    break;
                case 2:
                case 3:
                    color = Color.ORANGE;
                    break;
                case 4:
                case 5:
                    color = Color.yellow;
                    break;
                case 6:
                case 7:
                case 8:
                    color = Color.green;
                    break;
                case 9:
                case 10:
                    color = Color.blue;
                    break;
                case 11:
                case 12:
                    color = Color.pink;
                    break;
                case 13:
                case 14:
                    color = Color.CYAN;
                    break;
                default:
                    color = Color.lightGray;
            }
            // The x value of the upper left point of the rectangle
            x = START_RECT + (i * BLOCK_WIDTH);
            // Create the upper left point of the rectangle
            upperLeft = new Point(x, BLOCKS_ROW_HEIGHT);
            // Create the rectangle
            rectangle = new Rectangle(upperLeft, BLOCK_WIDTH, BLOCK_HEIGHT);
            Block block = new Block(rectangle, color);
            // Add the new block to the blocks list
            blocks.add(block);
        }
        // Return the list of the velocities
        return blocks;
    }


    /**
     * numberOfBlocksToRemove - return the number of blocks that should be removed before the level
     * is considered to be "cleared" ( This number should be <= blocks.size() ).
     *
     * @return number of blocks that should be removed (before the level is considered to be "cleared")
     */
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
