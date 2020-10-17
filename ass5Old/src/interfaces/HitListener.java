// ID: 208387969

package interfaces;

import sprites.Ball;
import sprites.Block;

/**
 * interfaces.HitListener - The interface indicate that objects that implement it can get notifications
 * of hit events and register themselves with a interfaces.HitNotifier object using its addHitListener method.
 */
public interface HitListener {
    /**
     * hitEvent - This method is called whenever the beingHit object is hit.
     * The parameter that's doing the hitting is the ball.
     *
     * @param beingHit - The blocks that were hit.
     * @param hitter   - The hitter parameter is the sprites.Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
