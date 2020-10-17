// ID: 208387969

package levelsgraphics;
import biuoop.DrawSurface;
import geometry.Point;
import interfaces.Sprite;
import java.awt.Color;

/**
 * levelsgraphics.SecondLevelGraphic - The class create the graphics of the second Level.
 */
public class SecondLevelGraphic implements Sprite {
    // The upper - left point of the background rectangle
    private static final Point POINT_BACKGROUND = new Point(0, 0);
    // The width of the background block
    private static final int BACKGROUND_WIDTH = 800;
    // The height of the background block
    private static final int BACKGROUND_HEIGHT = 600;

    /**
     * constructor without configurable.
     */
    public SecondLevelGraphic() {
    }

    /**
     * timePassed - notify that time has passed.
     */
    public void timePassed() {
    }

    /**
     * drawOn - Draw the graphic.
     *
     * @param surface - The draw.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(new Color(201, 200, 164));
        surface.fillRectangle((int) POINT_BACKGROUND.getX(), (int) POINT_BACKGROUND.getY(), BACKGROUND_WIDTH,
                BACKGROUND_HEIGHT);
        // sun
        surface.setColor(new Color(236, 251, 15));
        surface.fillCircle(350, 410, 50);
        surface.setColor(new Color(228, 232, 77));
        surface.fillCircle(350, 410, 45);
        surface.setColor(new Color(242, 189, 46));
        surface.fillCircle(350, 410, 40);
        surface.setColor(new Color(242, 159, 33));
        surface.fillCircle(350, 410, 28);
        surface.setColor(new Color(242, 120, 37));
        surface.fillCircle(350, 410, 25);
        for (int i = 1; i < 51; i++) {
            surface.setColor(new Color(203, 244, 252));
            surface.drawLine(600, 445, 605 / 25 * i, 580);
            surface.setColor(new Color(160, 192, 199));
            surface.drawLine(600, 445, 605 / 25 * i, 580);
            surface.setColor(new Color(160, 192, 199));
            surface.drawLine(100, 445, 105 / 25 * i, 580);
            surface.drawLine(350, 445, 380 / 25 * i, 580);
            surface.setColor(new Color(107, 128, 133));
            //surface.drawLine(600, 495, 605 / 25 * i, 550);
            surface.drawLine(100, 455, 105 / 25 * i, 580);
            surface.drawLine(350, 435, 380 / 25 * i, 580);
            surface.drawLine(350, 475, 380 / 25 * i, 580);
            surface.setColor(new Color(74, 93, 99));
            // surface.drawLine(600, 500, 605 / 25 * i, 550);
            surface.drawLine(100, 510, 105 / 25 * i, 580);
            surface.drawLine(350, 490, 380 / 25 * i, 580);
            surface.setColor(new Color(135, 162, 168));
            surface.drawLine(600, 450, 605 / 25 * i, 580);
        }
    }
}
