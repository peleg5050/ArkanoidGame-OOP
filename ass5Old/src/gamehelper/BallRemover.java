// ID: 208387969


package gamehelper;

import interfaces.HitListener;
import sprites.Ball;
import sprites.Block;

/**
 * gamehelper.BallRemover - The class be in charge of removing balls, and updating an availabe-balls counter.
 * The gamehelper.BallRemover is a listener of the death-region block, so that gamehelper.
 * BallRemover will be notified whenever a ball hits the death-region. Whenever this happens, the gamehelper.
 * BallRemover will remove the ball from the game.
 */
public class BallRemover implements HitListener {
    private static final int ONE = 1;
    // Characteristics
    private Game game;
    private Counter remainingBalls;

    /**
     * constructor with configurable of the game object and the number of balls that remove.
     *
     * @param game - Hold a reference to the gamehelper.Game object (in order to be able to remove balls from it).
     * @param removedBalls - The number of balls that removed.
     */
    public BallRemover(Game game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }

    /**
     * hitEvent - This method is called whenever the beingHit object is hit.
     * Remove from the game balls that were hit, and also remove this listener from the balls
     * that is being removed from the game.
     *
     * @param beingHit - The blocks that were hit.
     * @param hitter   - The hitter parameter is the sprites.Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        remainingBalls.decrease(ONE);
        // Remove the ball (the hitter parameter) from the game
        hitter.removeFromGame(this.game);
    }
}
