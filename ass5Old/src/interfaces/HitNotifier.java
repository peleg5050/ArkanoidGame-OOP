// ID: 208387969

package interfaces;

/**
 * interfaces.HitNotifier - The interface indicate that objects that implement it send notifications when
 * they are being hit.
 */

public interface HitNotifier {

    /**
     * addHitListener - Add hitListen as a listener to hit events.
     *
     * @param hitListen - the hitListener that we want to add to the hitListeners list.
     */
    void addHitListener(HitListener hitListen);

    /**
     * removeHitListener - Remove hitListen from the list of listeners to hit events.
     *
     * @param hitListen - the hitListener that we want to remove from the hitListeners list.
     */
    void removeHitListener(HitListener hitListen);
}
