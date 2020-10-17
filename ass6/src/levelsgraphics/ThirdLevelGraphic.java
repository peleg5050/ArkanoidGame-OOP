// ID: 208387969

package levelsgraphics;
import biuoop.DrawSurface;
import geometry.Point;
import interfaces.Sprite;
import java.awt.Color;

/**
 * levelsgraphics.ThirdLevelGraphic - The class create the graphics of the third Level.
 */
public class ThirdLevelGraphic implements Sprite {
    // The upper - left point of the background rectangle
    private static final Point POINT_BACKGROUND = new Point(0, 0);
    // The width of the background block
    private static final int BACKGROUND_WIDTH = 800;
    // The height of the background block
    private static final int BACKGROUND_HEIGHT = 600;
    private int carPlace;

    /**
     * constructor without configurable.
     */
    public ThirdLevelGraphic() {
        this.carPlace = 700;
    }

    /**
     * timePassed - notify that time has passed.
     */
    public void timePassed() {
        if (carPlace == -30) {
            carPlace = 800;
        } else {
            carPlace = carPlace - 1;
        }
    }

    /**
     * drawOn - Draw the graphic.
     *
     * @param surface - The draw.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(new Color(17, 93, 49));
        surface.fillRectangle((int) POINT_BACKGROUND.getX(), (int) POINT_BACKGROUND.getY(), BACKGROUND_WIDTH,
                BACKGROUND_HEIGHT);
        // Tree
        surface.setColor(new Color(93, 85, 67));
        surface.fillRectangle(290, 510, 28, 100);
        surface.setColor(new Color(48, 242, 11));
        surface.fillCircle(275, 510, 27);
        surface.setColor(new Color(42, 211, 10));
        surface.fillCircle(320, 450, 27);
        surface.fillCircle(340, 470, 27);
        surface.fillCircle(320, 520, 27);
        surface.fillCircle(320, 480, 25);
        surface.setColor(new Color(26, 132, 6));
        surface.fillCircle(350, 490, 27);
        surface.fillCircle(280, 470, 27);
        surface.setColor(new Color(33, 168, 7));
        surface.fillCircle(320, 510, 27);
        surface.fillCircle(310, 470, 27);
        surface.setColor(new Color(163, 34, 29));
        surface.fillCircle(320, 510, 5);
        surface.fillCircle(280, 470, 4);
        surface.fillCircle(320, 480, 4);
        surface.setColor(new Color(141, 29, 25));
        surface.fillCircle(320, 450, 5);
        surface.fillCircle(280, 470, 3);
        surface.fillCircle(340, 470, 4);
        surface.setColor(new Color(252, 165, 47));
        surface.fillCircle(275, 510, 5);
        surface.fillCircle(280, 460, 4);
        surface.fillCircle(300, 490, 5);
        surface.setColor(new Color(193, 40, 34));
        surface.fillCircle(305, 470, 5);
        surface.fillCircle(360, 485, 4);
        surface.setColor(new Color(234, 141, 37));
        surface.fillCircle(340, 500, 5);
        surface.fillCircle(340, 450, 5);

        // car
        surface.setColor(new Color(101, 21, 18));
        surface.fillRectangle(carPlace + 20, 550, 40, 25);
        surface.setColor(new Color(111, 23, 20));
        surface.fillRectangle(carPlace, 570, 70, 25);
        surface.setColor(Color.white);
        surface.fillCircle(carPlace + 10, 594, 6);
        surface.fillCircle(carPlace + 50, 594, 6);
        surface.setColor(Color.black);
        surface.fillCircle(carPlace + 10, 594, 5);
        surface.fillCircle(carPlace + 50, 594, 5);
        surface.setColor(new Color(214, 209, 100));
        surface.fillCircle(carPlace + 1, 576, 3);
        surface.setColor(Color.orange);
        surface.fillCircle(carPlace + 1, 576, 2);
        // Building
        surface.setColor(new Color(117, 74, 39));
        surface.fillRectangle(49, 250, 190, 500);
        surface.setColor(Color.WHITE);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                surface.fillRectangle(60 + j * 25, 300 + i * 35, 18, 32);
            }
        }
    }
}
