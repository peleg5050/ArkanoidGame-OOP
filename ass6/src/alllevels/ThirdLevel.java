// ID: 208387969

package alllevels;

import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.LevelInformation;
import interfaces.Sprite;
import levelsgraphics.ThirdLevelGraphic;
import sprites.Block;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * alllevels.ThirdLevel - The class , ThirdLevel , is the third level.
 * The class implements the LevelInformation interface.
 */
public class ThirdLevel implements LevelInformation {
    // The number of balls at the beginning
    private static final int NUMBER_OF_BALLS = 2;
    // The paddle speed
    private static final int PADDLE_SPEED = 7;
    // The width of the paddle
    private static final int WIDTH_OF_PADDLE = 100;
    // The velocity of the balls :
    //
    // The velocity of ball 1
    private static final Velocity VELOCITY_BALL_FIRST = Velocity.fromAngleAndSpeed(320, 6);
    // The velocity of ball 2
    private static final Velocity VELOCITY_BALL_SECOND = Velocity.fromAngleAndSpeed(40, 6);
    // The string name
    private static final String LEVEL_NAME = "Green 3";
    // The upper - left point of the background rectangle
    private static final Point POINT_BACKGROUND = new Point(0, 0);
    // The width of the background block
    private static final int BACKGROUND_WIDTH = 800;
    // The height of the background block
    private static final int BACKGROUND_HEIGHT = 600;
    // Blocks :
    //
    // Block - width
    private static final int BLOCK_WIDTH = 51;
    // Block - height
    private static final int BLOCK_HEIGHT = 25;
    // Const number for the start rectangle point (x and y)
    public static final int START_RECT_X = BACKGROUND_WIDTH - 20;
    public static final int START_RECT_Y = BACKGROUND_HEIGHT - 350;

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
        velocities.add(VELOCITY_BALL_FIRST);
        velocities.add(VELOCITY_BALL_SECOND);
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
        ThirdLevelGraphic thirdLevelGraphic = new ThirdLevelGraphic();
        return thirdLevelGraphic;
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

        // runs on the 5 rows (from the low row to the height row, and for each row add one more block)
        for (int i = 0; i < 5; i++) {
            // The X and the Y value of the upper left point of the current block
            double x, y;
            // The upper left point of the rectangle
            Point upperLeft;
            // The current rectangle
            Rectangle rectangle;
            for (int j = 1; j < 7 + i; j++) {
                // Chose color for the block
                int numColor = i;
                Color color;
                switch (numColor) {
                    // Then colorRandom = ....
                    case 0:
                        color = Color.white;
                        break;
                    case 1:
                        color = Color.BLUE;
                        break;
                    case 2:
                        color = Color.YELLOW;
                        break;
                    case 3:
                        color = Color.RED;
                        break;
                    case 4:
                        color = Color.gray;
                        break;
                    default:
                        color = Color.CYAN;
                }
                x = START_RECT_X - (j * BLOCK_WIDTH);
                y = START_RECT_Y - (i * BLOCK_HEIGHT);
                // Create the upper left point of the rectangle
                upperLeft = new Point(x, y);
                // Create the rectangle
                rectangle = new Rectangle(upperLeft, BLOCK_WIDTH, BLOCK_HEIGHT);
                Block block = new Block(rectangle, color);
                // Add the new block to the blocks list
                blocks.add(block);
            }
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


