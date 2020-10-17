// ID: 208387969

import interfaces.HitListener;
import sprites.Ball;
import sprites.Block;

/**
 * PrintingHitListener - The class prints a message to the screen whenever a block is hit.
 */
public class PrintingHitListener implements HitListener {
    /**
     * hitEvent - This method is called whenever the beingHit object is hit
     * (The hitter parameter is the sprites.Ball that's doing the hitting).
     *
     * @param beingHit - The object that being hit.
     * @param hitter   - The hitter parameter is the sprites.Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A sprites.Block was hit.");
    }
}
