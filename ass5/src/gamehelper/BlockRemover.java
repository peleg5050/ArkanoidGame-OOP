// ID: 208387969

package gamehelper;

import interfaces.HitListener;
import sprites.Ball;
import sprites.Block;

/**
 * gamehelper.BlockRemover - The class is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private static final int ONE = 1;
    // Characteristics
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor with configurable of the game object and the number of blocks that remove.
     *
     * @param game - Hold a reference to the gamehelper.Game object (in order to be able to remove blocks from it).
     * @param removedBlocks - The number of blocks that remove.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * hitEvent - This method is called whenever the beingHit object (the block) is hit.
     * remove from the game blocks that were hit, and also remove this listener from the block
     * that is being removed from the game.
     *
     * @param beingHit - The blocks that were hit.
     * @param hitter   - The hitter parameter is the sprites.Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        remainingBlocks.decrease(ONE);
        // Remove the hitListen of this block from the list of listeners to hit events.
        beingHit.removeHitListener(this);
        // Remove the block from the game
        beingHit.removeFromGame(this.game);
    }
}
