// ID: 208387969

package levelsgraphics;
import biuoop.DrawSurface;
import geometry.Point;
import interfaces.Sprite;
import java.awt.Color;

/**
 * levelsgraphics.FourthLevelGraphic - The class create the graphics of the fourth Level.
 */
public class FourthLevelGraphic implements Sprite {
    // The upper - left point of the background rectangle
    private static final Point POINT_BACKGROUND = new Point(0, 0);
    // The width of the background block
    private static final int BACKGROUND_WIDTH = 800;
    // The height of the background block
    private static final int BACKGROUND_HEIGHT = 600;
    private int planPlace;

    /**
     * constructor without configurable.
     */
    public FourthLevelGraphic() {
        this.planPlace = 700;
    }

    /**
     * timePassed - notify that time has passed.
     */
    public void timePassed() {

        if (planPlace == -30) {
            planPlace = 800;
        } else {
            planPlace = planPlace - 1;
        }
    }

    /**
     * drawOn - Draw the graphic.
     *
     * @param surface - The draw.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(new Color(18, 238, 236));
        surface.fillRectangle((int) POINT_BACKGROUND.getX(), (int) POINT_BACKGROUND.getY(), BACKGROUND_WIDTH,
                BACKGROUND_HEIGHT);
        // The clouds
        // cloud 1
        surface.setColor(new Color(168, 164, 157));
        surface.fillCircle(70, 400, 30);
        surface.fillCircle(130, 380, 30);
        surface.setColor(new Color(180, 176, 168));
        surface.fillCircle(90, 380, 30);
        surface.fillCircle(100, 400, 30);
        surface.setColor(new Color(202, 198, 189));
        surface.fillCircle(120, 410, 30);
        surface.setColor(new Color(168, 164, 157));
        surface.fillCircle(130, 400, 30);
        // cloud 2
        surface.setColor(new Color(168, 164, 157));
        surface.fillCircle(570, 400, 30);
        surface.fillCircle(630, 380, 30);
        surface.setColor(new Color(180, 176, 168));
        surface.fillCircle(590, 380, 30);
        surface.fillCircle(600, 400, 30);
        surface.setColor(new Color(202, 198, 189));
        surface.fillCircle(650, 410, 30);
        surface.setColor(new Color(168, 164, 157));
        surface.fillCircle(670, 400, 30);
        for (int i = 0; i < 10; i++) {
            surface.setColor(new Color(224, 219, 209));
            surface.drawLine(60 + (i * 10), 425, 75 + (i * 11), 500 + (i * 2));
            surface.drawLine(560 + (i * 10), 425, 575 + (i * 11), 500 + (i * 2));
        }
        for (int i = 0; i < 10; i++) {
            // air plain
            surface.setColor(new Color(51, 76, 78));
            surface.fillCircle(planPlace + 60, 440 + (i * 5), 8);
            surface.fillCircle(planPlace + 60, 400 - (i * 5), 8);
            surface.fillCircle(planPlace + 120, 398 + (i * 5), 8);
        }
        //air plan
        surface.setColor(new Color(111, 23, 20));
        surface.fillCircle(planPlace, 420, 20);
        surface.setColor(new Color(51, 76, 78));
        surface.fillRectangle(planPlace, 400, 120, 40);
        surface.fillCircle(planPlace + 120, 420, 20);
        surface.setColor(Color.gray);
        surface.fillCircle(planPlace + 20, 420, 7);
        surface.fillCircle(planPlace + 40, 420, 7);
        surface.fillCircle(planPlace + 60, 420, 7);
        surface.fillCircle(planPlace + 80, 420, 7);
        surface.fillCircle(planPlace + 100, 420, 7);
        surface.setColor(Color.white);
        surface.fillCircle(planPlace + 20, 420, 5);
        surface.fillCircle(planPlace + 40, 420, 5);
        surface.fillCircle(planPlace + 60, 420, 5);
        surface.fillCircle(planPlace + 80, 420, 5);
        surface.fillCircle(planPlace + 100, 420, 5);
    }
}
