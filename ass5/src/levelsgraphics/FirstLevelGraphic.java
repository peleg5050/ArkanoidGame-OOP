// ID: 208387969

package levelsgraphics;
import biuoop.DrawSurface;
import geometry.Point;
import interfaces.Sprite;
import java.awt.Color;

/**
 * levelsgraphics.FirstLevelGraphic - The class create the graphics of the First Level.
 */
public class FirstLevelGraphic implements Sprite {
    // The upper - left point of the background rectangle
    private static final Point POINT_BACKGROUND = new Point(0, 0);
    // The width of the background block
    private static final int BACKGROUND_WIDTH = 800;
    // The height of the background block
    private static final int BACKGROUND_HEIGHT = 600;
    private int pacmanPlace;

    /**
     * constructor without configurable.
     */
    public FirstLevelGraphic() {
        this.pacmanPlace = 700;
    }

    /**
     * timePassed - notify that time has passed.
     */
    public void timePassed() {
        if (pacmanPlace == 0) {
            pacmanPlace = 800;
        } else {
            pacmanPlace = pacmanPlace - 1;
        }
    }

    /**
     * drawOn - Draw the graphic.
     *
     * @param surface - The draw.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.black);
        surface.fillRectangle((int) POINT_BACKGROUND.getX(), (int) POINT_BACKGROUND.getY(), BACKGROUND_WIDTH,
                BACKGROUND_HEIGHT);
        surface.setColor(Color.BLUE);
        surface.drawCircle(BACKGROUND_WIDTH / 2, BACKGROUND_HEIGHT / 2 - 100, 200);
        surface.drawCircle(BACKGROUND_WIDTH / 2, BACKGROUND_HEIGHT / 2 - 100, 150);
        surface.drawCircle(BACKGROUND_WIDTH / 2, BACKGROUND_HEIGHT / 2 - 80, 50);
        // moon
        surface.setColor(new Color(170, 161, 91));
        surface.fillCircle(100, 80, 26);
        surface.setColor(new Color(237, 224, 126));
        surface.fillCircle(100, 80, 24);
        surface.setColor(Color.yellow);
        surface.fillCircle(100, 80, 20);

        //
        surface.setColor(Color.black);
        surface.fillCircle(114, 80, 20);

        surface.setColor(Color.white);
        surface.fillCircle(114, 100, 2);
        surface.fillCircle(95, 120, 2);
        surface.fillCircle(80, 100, 2);
        surface.fillCircle(114, 80, 1);
        surface.fillCircle(70, 100, 1);
        surface.fillCircle(100, 100, 2);
        surface.setColor(Color.orange);
        surface.fillCircle(116, 100, 5);


        for (int i = 0; i < 80; i++) {
            surface.setColor(Color.orange);
            surface.fillCircle(114 + i, 100 - i, 1);
            surface.setColor(Color.blue);
            surface.fillCircle(BACKGROUND_WIDTH / 2, i * 5, 5);
            surface.setColor(Color.red);
            surface.fillCircle(BACKGROUND_WIDTH / 2, i * 5, 2);
            surface.setColor(Color.darkGray);
            surface.fillCircle(BACKGROUND_WIDTH / 2 - 10, i * 5, 5);
            surface.setColor(Color.green);
            surface.fillCircle(BACKGROUND_WIDTH / 2 - 10, i * 5, 2);
            surface.setColor(Color.darkGray);
            surface.fillCircle(BACKGROUND_WIDTH / 2 + 10, i * 5, 5);
            surface.setColor(Color.green);
            surface.fillCircle(BACKGROUND_WIDTH / 2 + 10, i * 5, 2);
            surface.setColor(Color.BLUE);
            surface.fillCircle(BACKGROUND_WIDTH / 2 - (i * 5), BACKGROUND_HEIGHT / 2 - 74, 5);
            surface.fillCircle(BACKGROUND_WIDTH / 2 + (i * 5), BACKGROUND_HEIGHT / 2 - 74, 5);
            surface.setColor(Color.red);
            surface.fillCircle(BACKGROUND_WIDTH / 2 - (i * 5), BACKGROUND_HEIGHT / 2 - 75, 2);
            surface.fillCircle(BACKGROUND_WIDTH / 2 + (i * 5), BACKGROUND_HEIGHT / 2 - 75, 2);

            surface.setColor(Color.orange);
            surface.fillCircle(120 + (i * 7), 500, 2);
            surface.setColor(Color.yellow);
            surface.fillCircle(120 + (i * 7), 500, 1);
        }
        // pacman
        // pacman 2
        surface.setColor(Color.yellow);
        surface.fillCircle(100, 500, 20);
        surface.setColor(Color.black);
        surface.fillCircle(106, 490, 6);
        surface.fillCircle(120, 503, 7);
        // pacman 1
        surface.setColor(Color.yellow);
        surface.fillCircle(pacmanPlace, 500, 20);
        surface.setColor(Color.black);
        surface.fillCircle(pacmanPlace - 9, 490, 6);
        surface.fillCircle(pacmanPlace - 20, 503, 7);
        surface.setColor(Color.black);
        surface.fillRectangle(pacmanPlace + 20, 470, 550, 90);


      //  surface.setColor(Color.blue);
       // surface.fillRectangle(pacmanPlace - 25, 498, 10, 3);

        surface.setColor(Color.WHITE);
        surface.drawLine(BACKGROUND_WIDTH / 2, BACKGROUND_HEIGHT / 2 - 50, BACKGROUND_WIDTH / 2,
                BACKGROUND_HEIGHT / 2 + 100);
        surface.drawLine(BACKGROUND_WIDTH / 2, BACKGROUND_HEIGHT / 2 - 100, 550, 70);
        surface.drawLine(BACKGROUND_WIDTH / 2, BACKGROUND_HEIGHT / 2 - 100, 400, 50);
        surface.drawLine(BACKGROUND_WIDTH / 2, BACKGROUND_HEIGHT / 2 - 100, 250, 70);
    }
}
