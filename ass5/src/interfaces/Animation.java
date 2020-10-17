// ID: 208387969

package interfaces;

import biuoop.DrawSurface;

/**
 * interfaces.interfaces.Animation - The interface do the animation in the game frame by frame, and stop the game when
 * it's required.
 */
public interface Animation {
    /**
     * doOneFrame - help to run the game (frame by frame).
     *
     * @param draw - the draw surface.
     */
    void doOneFrame(DrawSurface draw);

    /**
     * shouldStop - return true if the game is continue, false otherwise.
     *
     * @return true if the game is continue, false otherwise.
     */
    boolean shouldStop();
}
