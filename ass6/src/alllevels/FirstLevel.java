// ID: 208387969

package alllevels;

import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.LevelInformation;
import interfaces.Sprite;
import levelsgraphics.FirstLevelGraphic;
import sprites.Block;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * alllevels.FirstLevel - The class , FirstLevel , is the first level.
 * The class implements the LevelInformation interface.
 */
public class FirstLevel implements LevelInformation {
    // The number of balls at the beginning
    private static final int NUMBER_OF_BALLS = 1;
    // The paddle speed
    private static final int PADDLE_SPEED = 7;
    // The width of the paddle
    private static final int WIDTH_OF_PADDLE = 100;
    // The velocity of the balls
    private static final Velocity VELOCITY_BALL = Velocity.fromAngleAndSpeed(0, 6);
    // The string name
    private static final String LEVEL_NAME = "Direct Hit";
    // The upper - left point of the background rectangle
    private static final Point POINT_BACKGROUND = new Point(0, 0);
    // The width of the background block
    private static final int BACKGROUND_WIDTH = 800;
    // The height of the background block
    private static final int BACKGROUND_HEIGHT = 600;
    // Blocks :
    //
    // Point 1 : (the upper - left point of the block)
    private static final Point POINT_OF_BLOCK = new Point(375, 200);
    // Block 1 - width
    private static final int BLOCK_WIDTH = 50;
    // Block 1 - height
    private static final int BLOCK_HEIGHT = 50;

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
        // create list of velocities
        List<Velocity> velocities = new ArrayList<>();
        // add the new velocities to the velocities list
        velocities.add(VELOCITY_BALL);
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
        FirstLevelGraphic firstLevelGraphic = new FirstLevelGraphic();
        return firstLevelGraphic;
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
        Rectangle rectangle = new Rectangle(POINT_OF_BLOCK, BLOCK_WIDTH, BLOCK_HEIGHT);
        Block block = new Block(rectangle, Color.red);
        // Add the new block to the blocks list
        blocks.add(block);
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
