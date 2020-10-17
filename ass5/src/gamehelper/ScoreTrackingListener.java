// ID: 208387969


package gamehelper;

import interfaces.HitListener;
import sprites.Ball;
import sprites.Block;

/**
 * gamehelper.ScoreTrackingListener - The class update this counter when blocks are being hit and removed.
 */
public class ScoreTrackingListener implements HitListener {
    private static final int FIVE = 5;
    private Counter currentScore;

    /**
     * constructor with configurable of the gamehelper.Counter score.
     *
     * @param scoreCounter - The gamehelper.Counter score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
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
        currentScore.increase(FIVE);
    }
}
