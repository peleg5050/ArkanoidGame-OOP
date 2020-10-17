// ID: 208387969

package interfaces;

import geometry.Velocity;
import sprites.Block;

import java.util.List;


/**
 * interfaces.interfaces.Animation - The interface , LevelInformation , interface specifies the information
 * required to fully describe a level.
 */
public interface LevelInformation {

    /**
     * numberOfBalls - return the number of balls.
     *
     * @return number of balls.
     */
    int numberOfBalls();

    /**
     * initialBallVelocities - initial velocity of each ball, and insert the velocity of each ball to a list.
     * By this, initialBallVelocities().size() == numberOfBalls().
     *
     * @return list of velocity of all the balls.
     */
    List<Velocity> initialBallVelocities();

    /**
     * paddleSpeed - return the paddle speed.
     *
     * @return paddle speed.
     */
    int paddleSpeed();

    /**
     * paddleWidth - return the paddle width.
     *
     * @return paddle width.
     */
    int paddleWidth();

    /**
     * levelName - return the String of the levelName.
     * The level name will be displayed at the top of the screen.
     *
     * @return String of the levelName.
     */
    String levelName();


    /**
     * getBackground - Returns a sprite with the background of the level.
     * The level name will be displayed at the top of the screen.
     *
     * @return String of the levelName.
     */
    Sprite getBackground();


    /**
     * blocks - return list of all the blocks that make up this level.
     * The Blocks that make up this level, each block contains its size, color and location.
     *
     * @return list of all the blocks that make up this level.
     */
    List<Block> blocks();


    /**
     * numberOfBlocksToRemove - return the number of blocks that should be removed before the level
     * is considered to be "cleared" ( This number should be <= blocks.size() ).
     *
     * @return number of blocks that should be removed (before the level is considered to be "cleared")
     */
    int numberOfBlocksToRemove();

}
